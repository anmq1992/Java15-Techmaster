package com.example.coursemgmt_backend.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Course {


    private Integer id;
    private String name;
    private String description;
    private String type;
    private List<String> topics;
    private String thumbnail;
    private Integer userId;

//    public List<String> convertTopicString(){
//        ArrayList<String> topicNames = topics.stream()
//                .map(Topic::getName)
//                .collect(Collectors.toCollection(ArrayList::new));
//        return topicNames;
//    }
}
