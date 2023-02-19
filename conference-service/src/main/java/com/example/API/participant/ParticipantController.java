package com.example.API.participant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/participant")
public class ParticipantController {

    private final ParticipantService participantService;

    @Autowired
     private ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @GetMapping()
    public List<Participant> getParticipants(){
        return participantService.getParticipants();
    }
    @GetMapping(path = "{ParticipantID}")
    public Participant getParticipant(@PathVariable("ParticipantID") Long ParticipantID){
        return participantService.getParticipant(ParticipantID);
    }
    @PostMapping
    public void registerNewParticipant(@RequestBody Participant participant){
        participantService.addNewParticipant(participant);
    }
    @DeleteMapping(path = "{ParticipantID}")
    public void deleteParticipant(@PathVariable("studentID") Long studentId){
        participantService.deleteParticipant(studentId);
    }

    @PutMapping(path = "{ParticipantID}")
    public void updateParticipant(
            @PathVariable("ParticipantID") Long studentID,
            @RequestBody Participant participant)

    {
        System.out.println(participant.getName() + "hello~~");
        participantService.updateParticipant(studentID, participant);
    }
    @GetMapping (path = "{participantID}/{conferenceId}")
    public boolean isJoinedParticipantAndConferenceExists(@PathVariable Long participantID,
                                                          @PathVariable Long conferenceId){
        return participantService.isJoinedParticipantAndConferenceExists(participantID, conferenceId);
    }
}
