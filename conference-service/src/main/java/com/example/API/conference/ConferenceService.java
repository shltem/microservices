package com.example.API.conference;

import com.example.API.participant.Participant;
import com.example.API.participant.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConferenceService {
    private final ConferenceRepository conferenceRepository;
    private ParticipantService participantService;
    @Lazy
    @Autowired
    public ConferenceService(ConferenceRepository conferenceRepository, ParticipantService participantService) {
        this.conferenceRepository = conferenceRepository;
        this.participantService = participantService;
    }
    public List<Conference> getConferencesForParticipant(Long id) {
        return conferenceRepository.findConferenceByParticipant(id);
    }
    public List<Conference> getConferences(){
        return conferenceRepository.findAll();
    }

    public Conference addNewConference(Conference conference) {
        Optional<Conference> conferenceOptional = conferenceRepository.findConferenceByEmail(conference.getContactEmail());
        if ((conferenceOptional.isPresent())){
            throw new IllegalStateException("email taken");
        }
        Conference newConference = new Conference();
        newConference.setConferenceId(conference.getConferenceId());
        newConference.setConferenceName(conference.getConferenceName());
        newConference.setContactName(conference.getContactName());
        newConference.setContactEmail(conference.getContactEmail());
        newConference.setDateAndTimeOfConference(conference.getDateAndTimeOfConference());
        addParticipants(conference, newConference);
        return conferenceRepository.save(newConference);
    }

    public void deleteConference(Long ConferenceId) {
        if(conferenceRepository.existsById(ConferenceId)){
            conferenceRepository.deleteById(ConferenceId);
        }else{
            throw new IllegalStateException(
                    "Conference with id = "+ ConferenceId + " does not exsists"
            );
        }
    }
    public void updateConference(Long id, Conference conference) {
        if (conference.getConferenceName() != null) {
            conferenceRepository.getReferenceById(id).setConferenceName(conference.getConferenceName());
        }

        if (conference.getDateAndTimeOfConference() != null) {
            conferenceRepository.getReferenceById(id).setDateAndTimeOfConference(conference.getDateAndTimeOfConference());
        }
        if (null != conference.getContactEmail()) {
            Optional<Conference> conferenceOptional = conferenceRepository.findConferenceByEmail(conference.getContactEmail());
            if ((conferenceOptional.isPresent())){
                throw new IllegalStateException("email taken");
            }
            conferenceRepository.getReferenceById(id).setContactEmail(conference.getContactEmail());
        }
        if (null != conference.getContactName()) {
            conferenceRepository.getReferenceById(id).setContactName(conference.getContactName());
        }
        if (conference.getParticipants() != null) {
            removeParticipants(id);
            addParticipants(conference, conferenceRepository.getReferenceById(id));
            conferenceRepository.save(conferenceRepository.getReferenceById(id));
        }
    }  
    public Conference getConference(Long id) {
        return conferenceRepository.getReferenceById(id);
    }
    private void addParticipants(Conference conference, Conference newConference) {
        newConference.getParticipants().
                addAll(conference
                        .getParticipants()
                        .stream()
                        .map(c -> {
                            Participant pp = participantService.getParticipant(c.getId());
                            pp.getConferences().add(newConference);
                            return pp;
                        }).collect(Collectors.toList()));
    }
    private void removeParticipants(Long  existConferenceId) {
        conferenceRepository.getReferenceById(existConferenceId).getParticipants().stream()
                .map(c -> {
                    Participant cc = participantService.getParticipant(c.getId());
                    cc.getConferences().remove(conferenceRepository.getReferenceById(existConferenceId));
                    return cc;
                }).collect(Collectors.toList());
        conferenceRepository.getReferenceById(existConferenceId).getParticipants().clear();
    }
}
