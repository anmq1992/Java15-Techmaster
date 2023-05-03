package com.example.coursemgmt_backend.service;

import com.example.coursemgmt_backend.dto.CourseDto;
import com.example.coursemgmt_backend.dto.mapper.CourseMapper;
import com.example.coursemgmt_backend.exception.DuplicateRecordException;
import com.example.coursemgmt_backend.exception.InternalServerException;
import com.example.coursemgmt_backend.exception.NotFoundException;
import com.example.coursemgmt_backend.model.Course;
import com.example.coursemgmt_backend.repository.CourseRepository;
import com.example.coursemgmt_backend.request.CreateCourseReq;
import com.example.coursemgmt_backend.request.UpdateCourseReq;
import com.example.coursemgmt_backend.util.CustomPage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    // 1. Lấy danh sách course
    public List<Course> getAllCourse(String type, String name, String topic) {
        return courseRepository.findAll()
                .stream()
                .filter(course -> (type == null || course.getType().equals(type))
                        && (name == null || course.getName().toLowerCase().contains(name.toLowerCase()))
                        && (topic == null || course.getTopics().stream().anyMatch(c -> c.equals(topic))))
                .toList();
    }

    public CustomPage<Course> getAllCoursePaging(Integer page, Integer pageSize) {
        List<Course> courses = courseRepository.findAll();
        int startIndex = (page - 1) * pageSize;
        int totalPage = (int) Math.floor(courses.size() *1.0 / pageSize);
        int endIndex = Math.min(startIndex + pageSize, courses.size());
        List<Course> pageData = courses.subList(startIndex, endIndex);

        return new CustomPage<>(page, pageSize,totalPage,  courses.size(), pageData);

//        CustomPage<Course> pageResult = new CustomPage(page, pageSize,totalPage,  courses.size(), pageData);
//        return pageResult;
    }

    // 2. Lấy chi tiết course
    public CourseDto getCourseById(Integer id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> {
                    throw new NotFoundException("Not found course with id = " + id);
                });

        return courseMapper.toCourseDto(course);
    }

    public CourseDto createCourse(CreateCourseReq req){
        //check if the course exist
        Optional<Course> course = courseRepository.findByName(req.getName());
        if (course.isPresent()){
            throw new DuplicateRecordException("Course already exist");
        }
        Course newCourse = courseMapper.toCourse(req);
        courseRepository.save(newCourse);
        return courseMapper.toCourseDto(newCourse);
    }

    public CourseDto updateCourse(UpdateCourseReq req, int id){
        Optional<Course> course = courseRepository.findById(id);
        if (course.isEmpty()){
            throw new NotFoundException("Course not exist");
        }
        Course updateCourse = courseMapper.toCourse(req,id);
        try{
            courseRepository.save(updateCourse);
        }catch(Exception ex){
            throw new InternalServerException("Database error. Can't update user");
        }

        return courseMapper.toCourseDto(updateCourse);
    }

    public void deleteCourse(int id){
        Optional<Course> course = courseRepository.findById(id);
        if(course.isEmpty()){
            throw new NotFoundException("No Course Found");
        }
        try{
            courseRepository.deleteById(id);
        }catch (Exception ex){
            throw new InternalServerException("Database error. Cannot delete user");
        }
    }
    }
