package com.example.ktspringrestapi.service;

import com.example.ktspringrestapi.dto.CourseDto;
import com.example.ktspringrestapi.exception.NotFoundException;
import com.example.ktspringrestapi.mapper.CourseMapper;
import com.example.ktspringrestapi.repository.CourseRepository;
import com.example.ktspringrestapi.model.Course;
import com.example.ktspringrestapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    private final UserRepository userRepository;

//    private static final Logger LOGGER = LoggerFactory.getLogger(CourseService.class);


//    public List<CourseDto>  getAllCourses() {
//
//        List<CourseDto> coursesDto = new ArrayList<CourseDto>();
//
//        List<Course> courses = courseRepository.findAll();
//        for (Course course:courses) {
//            coursesDto.add(courseMapper.toCourseDto(course));
//        }
//        return coursesDto;
//    }

    public List<CourseDto> getAllCourses(String type, String name, String topic) {
//        LOGGER.info("Getting all courses with type={}, name={}, topic={}", type, name, topic);

        if (courseRepository.findAll() == null) {
//            LOGGER.error("Unable to retrieve courses from database");
            return new ArrayList<>();
        }

        CourseMapper courseMapper = new CourseMapper(userRepository);
        List<CourseDto> courseDtos = new ArrayList<>();

        List<Course> courses = courseRepository.findAll()
                .stream()
                .filter(course -> (type == null || course.getType().equals(type))
                        && (name == null || course.getName().toLowerCase().contains(name.toLowerCase()))
                        && (topic == null || course.getTopics().stream().anyMatch(c -> c.equals(topic))))
                .collect(Collectors.toList());

        for(Course course : courses){
            courseDtos.add(courseMapper.toCourseDto(course));
        }



//        LOGGER.info("Found {} courses matching criteria", courses.size());

        return courseDtos;
    }


    public CourseDto getCourseById(Integer id) {
        Course course = courseRepository.findCourseById(id)
                .orElseThrow(() -> {
                    throw new NotFoundException("Not found course with id = " + id);
                });

        CourseMapper courseMapper = new CourseMapper(userRepository);

        return courseMapper.toCourseDto(course);
    }

//
//    public Course createCourse() {
//        return courseRepository.createCourse();
//
//    }
//
//    public Course updateCourse(Integer id, UpdateCourseRequest request) {
//        return courseRepository.updateCourse(id, request);
//
//    }
//
//    public void deleteCourseById(Integer id) {
//        courseRepository.deleteById(id);
//    }


}
