package com.example.coursemgmt_backend.repository;

import com.example.coursemgmt_backend.model.Topic;
import org.springframework.stereotype.Repository;
import com.example.coursemgmt_backend.db.TopicDB;


import java.util.List;

@Repository
public class TopicRepository {
    public List<Topic> findAll() {
        return TopicDB.topics;
    }
}
