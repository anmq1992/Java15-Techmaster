package com.example.coursemgmt_backend.db;

import com.example.coursemgmt_backend.model.Topic;

import java.util.ArrayList;
import java.util.List;

public class TopicDB {
    public static List<Topic> topics = new ArrayList<>(List.of(
            new Topic ("frontend"),
            new Topic("backend"),
            new Topic( "database"),
            new Topic( "devops"),
            new Topic("AWS"),
            new Topic("basic"),
            new Topic("mobile")
    ));
}
