package com.example.feedbacksevice;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Data public class Conference {

    private Long conferenceId;

    private String conferenceName;

    private String contactEmail;
    private LocalDateTime dateAndTimeOfConference;
    private String ContactName;
    private Collection<Participant> participants = new ArrayList<>();
    public Conference() {
    }
}
