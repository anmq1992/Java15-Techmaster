package com.example.ktspringrestapi.repository;

import com.example.ktspringrestapi.db.TopicDB;
import com.example.ktspringrestapi.model.Topic;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TopicRepository {
    public List<Topic> findAll() {
        return TopicDB.topics;
    }
}

