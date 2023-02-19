package com.example.API.participant;

import com.example.API.conference.Conference;
import com.example.API.conference.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParticipantService {
    private final ConferenceService conferenceService;
    private final ParticipantRepository participantRepository;
    @Autowired
    public ParticipantService(ParticipantRepository participantRepository, ConferenceService conferenceService) {
        this.participantRepository = participantRepository;
        this.conferenceService = conferenceService;
    }

    public Participant getParticipant(Long id) {
        return participantRepository.getReferenceById(id);
    }
    public List<Conference> getConferencesForParticipant(Long id) {
        return participantRepository.findConferenceByParticipant(id);
    }
    public List<Participant> getParticipants(){
        return participantRepository.findAll();
    }

    public Participant addNewParticipant(Participant participant) {
        Optional<Participant> participantOptional = participantRepository.findParticipantByEmail(participant.getEmail());
        if ((participantOptional.isPresent())){
            throw new IllegalStateException("email taken");
        }
        Participant newParticipant = new Participant();
        newParticipant.setName(participant.getName());
        newParticipant.setEmail(participant.getEmail());
        newParticipant.setDob(participant.getDob());
        addConferences(participant, newParticipant);
        return participantRepository.save(newParticipant);
    }
    public void deleteParticipant(Long participantId) {
        if(participantRepository.existsById(participantId)){
            participantRepository.deleteById(participantId);
        }else{
            throw new IllegalStateException(
                    "Participant with id = "+ participantId + " does not exists"
            );
        }
    }
    public void updateParticipant(Long id, Participant participant) {
        if(participant.getName() != null){
            participantRepository.getReferenceById(id).setName(participant.getName());
        }
        if(participant.getDob() != null){
            participantRepository.getReferenceById(id).setDob(participant.getDob());
        }
        if(participant.getEmail() != null){
            Optional<Participant> participantOptional = participantRepository.findParticipantByEmail(participant.getEmail());
            if ((participantOptional.isPresent())){
                throw new IllegalStateException("email taken");
            }
            participantRepository.getReferenceById(id).setEmail(participant.getEmail());
        }
        if (participant.getConferences() != null){
            removeConferences(id);
            addConferences(participant, participantRepository.getReferenceById(id));
            participantRepository.save(participantRepository.getReferenceById(id));
        }
    }

    private void addConferences(Participant participant, Participant newParticipant) {
        newParticipant.getConferences().
                addAll(participant
                        .getConferences()
                        .stream()
                        .map(c -> {
                            Conference cc = conferenceService.getConference(c.getConferenceId());
                            cc.getParticipants().add(newParticipant);
                            return cc;
                        }).collect(Collectors.toList()));
    }
    private void removeConferences(Long existParticipantId) {
        participantRepository.getReferenceById(existParticipantId).getConferences().stream()
                .map(c -> {
                    Conference cc = conferenceService.getConference(c.getConferenceId());
                    cc.getParticipants().remove(participantRepository.getReferenceById(existParticipantId));
                    return cc;
                }).collect(Collectors.toList());
        participantRepository.getReferenceById(existParticipantId).getConferences().clear();
    }

    public boolean isJoinedParticipantAndConferenceExists(Long participantId, Long conferenceId){
        if(participantRepository.findConferenceByParticipantAndConferences(participantId, conferenceId).isPresent()){
            return true;
        }
        return false;
    }
}
