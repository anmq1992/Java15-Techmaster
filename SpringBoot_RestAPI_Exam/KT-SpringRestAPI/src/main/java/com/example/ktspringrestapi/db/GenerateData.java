package com.example.ktspringrestapi.db;
import com.example.ktspringrestapi.model.Course;
import com.example.ktspringrestapi.model.Topic;
import com.example.ktspringrestapi.model.User;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@AllArgsConstructor
public class GenerateData {
    private final Faker faker;
    public List<User> initUsers(){
        List<User> users = new ArrayList<>();
        for(int i  = 1; i <4; i++){
            User user = new User(
                    i,
                    faker.name().fullName(),
            faker.internet().emailAddress(),
                    faker.phoneNumber().phoneNumber(),
                    faker.company().logo()
            );
            users.add(user);
        }
        return users;
    }

    public List<Course> initCourses(List<User> users){

        /*
        *
        * private Integer id;
        * private String name;
        * private String description;
    private String type;
    private List<String> topics;
    private String thumbnail;
    private Integer userId;*/

        List<Course> courses = new ArrayList<>();
        List<Topic> topics = TopicDB.topics;
        Random rd = new Random();


        for(int i = 1; i < 10; i++){

            //random topic List of size 4
            List<Topic> rdTopics = new ArrayList<>();
            for (int j = 0; j < 4; j++){
                Topic rdTopic = topics.get(rd.nextInt(topics.size()));
                if(!rdTopics.contains(rdTopic)){
                    rdTopics.add(rdTopic);
                }
            }

            //random user
            User rdUser = users.get(rd.nextInt(users.size()));

            Course course = new Course(
                    i,
                    faker.name().fullName(),
                    faker.lorem().sentence(15),
                    rd.nextInt(2) == 1 ? "online" : "onlab",
                    rdTopics,
                    faker.company().logo(),
                    rdUser.getId());
            courses.add(course);

        }
        return courses;

    }
}
