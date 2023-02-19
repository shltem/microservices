package com.example.scheduleservice.scheduleservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "schedule-service/schedule")
public class ScheduleController {
    private final SchedulerService schedulerService;
    @Autowired
    public ScheduleController(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    @GetMapping(path = {"{participantID}"})
    public Schedule getSchedule(@PathVariable("participantID") Long participantID){
        return schedulerService.getSchedule(participantID);
    }
}
