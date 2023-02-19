package com.example.API.conference;

import com.example.API.participant.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/conference")
public class ConferenceController {
    private final ConferenceService conferenceService;
    @Autowired
     private ConferenceController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @GetMapping()
    public List<Conference> getConference(){
        return conferenceService.getConferences();
    }
    @GetMapping(path = "{ParticipantID}")
    public List<Conference> getConference(@PathVariable("ParticipantID") Long ParticipantID){
        return conferenceService.getConferencesForParticipant(ParticipantID);
    }
    @PostMapping
    public void registerNewConference(@RequestBody Conference conference){
        conferenceService.addNewConference(conference);
    }
    @DeleteMapping(path = "{studentID}")
    public void deleteConference(@PathVariable("studentID") Long studentId){
        conferenceService.deleteConference(studentId);
    }
    @PutMapping(path = "{ConferenceID}")
    public void updateConference(
            @PathVariable("ConferenceID") Long studentID,
            @RequestBody Conference conference){
        conferenceService.updateConference(studentID, conference);
    }
}
