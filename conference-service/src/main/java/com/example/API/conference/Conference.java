package com.example.API.conference;

import com.example.API.participant.Participant;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;


@Table
@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Conference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "conferenceId",
            updatable = false
    )
    private Long conferenceId;
    @Column(
            name = "conferenceName",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String conferenceName;

    @Column(
            name = "contactEmail",
            nullable = false,
            columnDefinition = "TEXT",
            unique = true
    )
    private String contactEmail;
    private LocalDateTime dateAndTimeOfConference;
    private String ContactName;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "participant_conference",
            joinColumns = @JoinColumn(name = "conference_id"),
            inverseJoinColumns = @JoinColumn(name = "participant_id")
    )

    private Collection<Participant> participants = new ArrayList<>();
    public Conference() {
    }
}