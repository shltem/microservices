package com.example.feedbacksevice;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Component
@Data
public class Participant {

    private Long id;
    private String name;
    private String email;
    private LocalDate dob;

    private Integer age;
    private Collection<Conference> conferences = new ArrayList<>();

}
