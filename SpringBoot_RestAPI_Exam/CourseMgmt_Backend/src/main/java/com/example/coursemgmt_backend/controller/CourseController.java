package com.example.coursemgmt_backend.controller;

import com.example.coursemgmt_backend.dto.CourseDto;
import com.example.coursemgmt_backend.model.Course;
import com.example.coursemgmt_backend.request.CreateCourseReq;
import com.example.coursemgmt_backend.request.UpdateCourseReq;
import com.example.coursemgmt_backend.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
@Slf4j
public class CourseController {
    private final CourseService courseService;

    // 1. Lấy danh sách course (có lọc course theo name, category type)
    @GetMapping("courses")
    public List<Course> getAllCourse(@RequestParam(required = false) String name,
                                     @RequestParam(required = false) String topic,
                                     @RequestParam(required = false) String type) {
        log.info("name : {}, category : {}, type : {}", name, topic, type);
        return courseService.getAllCourse(type, name, topic);
    }

    // 2. Tìm kiếm course theo id
    @GetMapping("courses/{id}")
    public CourseDto getCourseById(@PathVariable Integer id) {
        return courseService.getCourseById(id);
    }

    // Admin API
    @PostMapping("admin/courses")
    public ResponseEntity<?> createCourse(@Valid @RequestBody CreateCourseReq req) {
        CourseDto result = courseService.createCourse(req);
        return ResponseEntity.ok(result);
    }

    @GetMapping("admin/courses/{id}")
    public CourseDto getCourseAdminById(@PathVariable Integer id) {
        return courseService.getCourseById(id);
    }

    @PutMapping("admin/courses/{id}")
    public ResponseEntity<?> updateCourse(@Valid @RequestBody UpdateCourseReq req, @PathVariable int id){
        CourseDto result = courseService.updateCourse(req,id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("admin/courses/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok("Delete success");
    }


}
