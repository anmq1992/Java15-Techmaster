package com.example.ktspringrestapi.mapper;

import com.example.ktspringrestapi.dto.CourseDto;
import com.example.ktspringrestapi.exception.NotFoundException;
import com.example.ktspringrestapi.model.Course;
import com.example.ktspringrestapi.model.User;
import com.example.ktspringrestapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseMapper {

    private final UserRepository userRepository;


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
}
/*
    private Integer id;
    private String name;
    private String description;
    private String type;
    private List<String> topics;
    private String thumbnail;
    private Integer userId;
}*/


