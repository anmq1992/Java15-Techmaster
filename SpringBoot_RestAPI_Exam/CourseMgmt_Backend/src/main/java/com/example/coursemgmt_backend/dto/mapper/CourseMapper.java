package com.example.coursemgmt_backend.dto.mapper;

import com.example.coursemgmt_backend.dto.CourseDto;
import com.example.coursemgmt_backend.exception.NotFoundException;
import com.example.coursemgmt_backend.model.Course;
import com.example.coursemgmt_backend.model.Topic;
import com.example.coursemgmt_backend.model.User;
import com.example.coursemgmt_backend.repository.CourseRepository;
import com.example.coursemgmt_backend.repository.UserRepository;
import com.example.coursemgmt_backend.request.CreateCourseReq;
import com.example.coursemgmt_backend.request.UpdateCourseReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class CourseMapper {
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;


    public CourseDto toCourseDto(Course course) {
        User user = userRepository.findById(course.getUserId())
                .orElseThrow(() -> {
                    throw new NotFoundException("Not found user with id = " + course.getUserId());
                });


        return CourseDto.builder()
                .id(course.getId())
                .name(course.getName())
                .description(course.getDescription())
                .type(course.getType())
                .topics(course.getTopics())
                .thumbnail(course.getThumbnail())
                .user(user)
                .build();
    }

    public Course toCourse(CreateCourseReq req){
        Random rd = new Random();
        Integer newId = courseRepository.getSize() + 1;
        while (courseRepository.findById(newId) == null ){
            newId = courseRepository.getSize() + 1;
        }
//        ArrayList<Topic> topics = new ArrayList<>();
//
//        //create a List of Topics
//        for (String str: req.getTopics()){
//            topics.add(new Topic(str));
//        }

        Course course = new Course();
        course.setId(newId);
        course.setName(req.getName());
        course.setDescription(req.getDescription());
        course.setType(req.getType());
        course.setTopics(req.getTopics());
        course.setThumbnail(req.getThumbnail());
        course.setUserId(req.getUserId());

        return course;
    }

    public Course toCourse(UpdateCourseReq req, int id){
        Random rd = new Random();
        Integer newId = courseRepository.getSize() + 1;
        while (courseRepository.findById(newId) == null ){
            newId = courseRepository.getSize() + 1;
        }

        Course course = new Course();
        course.setId(newId);
        course.setName(req.getName());
        course.setDescription(req.getDescription());
        course.setType(req.getType());
        course.setTopics(req.getTopics());
        course.setThumbnail(req.getThumbnail());
        course.setUserId(req.getUserId());
        course.setId(id);

        return course;
    }
}
