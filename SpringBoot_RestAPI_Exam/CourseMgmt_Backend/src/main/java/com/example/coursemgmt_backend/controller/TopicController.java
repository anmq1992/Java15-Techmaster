package com.example.coursemgmt_backend.controller;

import com.example.coursemgmt_backend.model.Topic;
import com.example.coursemgmt_backend.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
@RequiredArgsConstructor
public class TopicController {
    private final TopicService topicService;

    @GetMapping("")
    public List<Topic> getAllCategory() {
        return topicService.getAllTopics();
    }
}
