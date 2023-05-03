package com.example.ktspringrestapi.repository;


import com.example.ktspringrestapi.db.CourseDB;
import com.example.ktspringrestapi.exception.NotFoundException;
import com.example.ktspringrestapi.model.Course;
import com.example.ktspringrestapi.model.Topic;
import com.example.ktspringrestapi.request.UpdateCourseRequest;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CourseRepository {
    public List<Course> findAll() {
        return CourseDB.courses;
    }


    public Optional<Course> findCourseById(Integer id) {
        Optional<Course> courseOptional =  CourseDB.courses.stream()
                .filter(course -> course.getId().equals(id))
                .findFirst();

//        return courseOptional;

        if (courseOptional.isPresent()){
            Course course = courseOptional.get();
            return courseOptional;
        }else{
            throw new NotFoundException("Not found the Course with that Id");

        }
    }


    // Lưu Course vào DB
    public Course createCourse() {
        Random rd = new Random();
        Integer id = rd.nextInt(100000);
        String description = "Some Random Description";
        String type= "online";
        String name = "Java-15";
        ArrayList<Topic> topics = new ArrayList<>();;
        topics.add(new Topic("Java"));
        topics.add(new Topic("Web-Dev"));
        String thumbnail = "";
        Integer userId = 100;


        Course course = new Course(id,name, description,type, topics, thumbnail,userId);
        CourseDB.courses.add(course);
        return course;
    }

    public Course updateCourse(Integer id, UpdateCourseRequest request) {
        List<Course> courseList =  CourseDB.courses.stream()
                .filter(course -> course.getId().equals(id))
                .toList();
        for (Course course : courseList){
            if (Objects.equals(course.getId(), id)){
                course.setDescription(request.getDescription());
                course.setType(request.getType());
                course.setName(request.getName());
                course.setTopics(request.getTopics());
                course.setThumbnail(request.getThumbnail());
                course.setUserId(request.getUserId());
            }
            return course;

        }

        throw new NotFoundException("Not found the Course with that Id");
    }


    // Xóa course theo ID
    public void deleteById(Integer id) {
        CourseDB.courses.removeIf(course -> course.getId().equals(id.toString()));
    }
}
