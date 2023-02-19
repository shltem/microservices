package com.example.feedbacksevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/feedback")

public class FeedBackController {
    private final FeedBackService feedBackService;
    private final FeedBackRepository feedBackRepository;

    @Autowired
    public FeedBackController(FeedBackService feedBackService,
                              FeedBackRepository feedBackRepository) {
        this.feedBackService = feedBackService;
        this.feedBackRepository = feedBackRepository;
    }

    @PostMapping
    public void addNewFeedBack(@RequestBody FeedBack feedBack){
        feedBackService.addNewFeedBack(feedBack);

    }

    @GetMapping(path = "{id}")
    public FeedBack getFeedBack(@PathVariable Long id){
        return feedBackService.getFeedBack(id);
    }
}
