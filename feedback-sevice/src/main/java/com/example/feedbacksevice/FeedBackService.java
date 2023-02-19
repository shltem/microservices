package com.example.feedbacksevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class FeedBackService {
    private final WebClient webClient;
    private final FeedBackRepository feedBackRepository;
    @Autowired
    public FeedBackService(WebClient webClient, FeedBackRepository feedBackRepository) {
        this.webClient = webClient;
        this.feedBackRepository = feedBackRepository;
    }

    public void addNewFeedBack(FeedBack feedBack) throws IllegalArgumentException {
        Boolean isExists =  webClient.get()
                .uri("http://localhost:8080/api/v1/participant/" + feedBack.getParticipantId()+ "/" +feedBack.getConferenceId())
                .retrieve().bodyToMono(Boolean.class).block();
        if(isExists) {
            feedBackRepository.save(feedBack);
            System.out.println("exsists");
        }else{
            System.out.println("not exsists");

            throw new IllegalArgumentException("participant didnt attened the conference");
        }
    }

    public FeedBack getFeedBack(Long id) {
        return feedBackRepository.getReferenceById(id);
    }
}
