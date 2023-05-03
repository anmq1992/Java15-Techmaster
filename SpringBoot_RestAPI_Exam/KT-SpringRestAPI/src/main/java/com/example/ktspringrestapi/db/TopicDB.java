package com.example.ktspringrestapi.db;

import com.example.ktspringrestapi.model.Topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TopicDB {
    public static List<Topic> topics = new ArrayList<>();
    public static List<Topic> categories = new ArrayList<>(List.of(
            new Topic("frontend"),
            new Topic( "backend"),
            new Topic( "database"),
            new Topic( "devops"),
            new Topic( "AWS"),
            new Topic( "basic"),
            new Topic( "mobile")
    ));


}
