package com.example.API.participant;

import com.example.API.conference.Conference;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Component
@Table
@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(
            name = "email",
            nullable = false,
            //columnDefinition = "TEXT",
            unique = true
    )
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;
    @ManyToMany(mappedBy = "participants", cascade = CascadeType.ALL)
    private Collection<Conference> conferences = new ArrayList<>();
    public Participant() {

    }
}
