package com.example.scheduleservice.scheduleservice;


import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;


@Service
@RequiredArgsConstructor
public class SchedulerService {
    private final WebClient webClient;
   public Schedule getSchedule(Long id){
       Schedule schedule = new Schedule();
       List<Conference> list =  webClient.get()
               .uri("http://localhost:8080/api/v1/conference/" +id)
               .retrieve().bodyToMono(new ParameterizedTypeReference<List<Conference>>() {
               }).block();

       for (Conference runner: list) {
           schedule.getSchedule().put(runner.getDateAndTimeOfConference(), runner.getConferenceName());
       }
       return schedule;
   }
}
