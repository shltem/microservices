package com.example.API.conference;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@Configuration
public class ConferenceConfig {
   // @Bean
//     CommandLineRunner commandLineRunnerConference(ConferenceRepository repository){
//        return args -> {
//                Conference ravArosh = new Conference(
//                    "Rav Arosh",
//                    "arosh@gmail.com",
//                    LocalDateTime.of(2000, Month.JANUARY, 5, 20,00,00),
//                "shlomo");
//
//            Conference ravDov = new Conference(
//                "Rav Dov",
//                "Dov@gmail.com",
//                LocalDateTime.of(2000, Month.JANUARY, 5, 21,00,00),
//                "shlomo"
//            );
//
//            repository.saveAll(List.of(ravArosh, ravDov));
//            };
//        }
}

