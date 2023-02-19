package com.example.API.participant;

import com.example.API.conference.Conference;
import com.example.API.conference.ConferenceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class ParticipantConfig {
//    Conference ravDov = new Conference(
//            "Rav Dov",
//            "Dov@gmail.com",
//            LocalDateTime.of(2000, Month.JANUARY, 5, 21,00,00),
//            "shlomo");
//
//    Conference ravArosh = new Conference(
//            "Rav Arosh",
//            "arosh@gmail.com",
//            LocalDateTime.of(2000, Month.JANUARY, 5, 20,00,00),
//            "shlomo");
//
//
//    @Bean
//     CommandLineRunner commandLineRunnerParticipant(ParticipantRepository repository){
//        return args -> {
//            Participant mair = new Participant(
//                    "mair",
//                    "mair@gmail.com",
//                    LocalDate.of(2000, Month.JANUARY, 5),
//                    List.of(ravArosh, ravDov));
//
//                    repository.save(mair);
//            };
//    }
}

