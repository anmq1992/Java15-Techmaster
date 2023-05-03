package com.example.ktspringrestapi.controller;
import com.example.ktspringrestapi.dto.CourseDto;
import com.example.ktspringrestapi.service.CourseService;
import com.example.ktspringrestapi.model.Course;
import com.example.ktspringrestapi.util.CustomPage;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    //API User
    @GetMapping("/courses")
    public ResponseEntity<?> getAllCourse(@RequestParam(name = "type", required = false) String type,
                                          @RequestParam(name = "name",required = false) String name,
                                          @RequestParam(name = "topic",required = false) String topic) {
        List<CourseDto> coursesList = courseService.getAllCourses(type, name, topic);
        return ResponseEntity.ok(coursesList);
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable Integer id) {
        CourseDto course = courseService.getCourseById(id);
        return ResponseEntity.ok(course);
    }

//    // API Admin
//    @GetMapping("/admin/courses")
//    public ResponseEntity<CustomPage<CourseDto>> getAllCoursesAdmin(@RequestParam(defaultValue = "1") int page,
//                                                                    @RequestParam(defaultValue = "10") int pageSize,
//                                                                    @RequestParam(required = false) String type,
//                                                                    @RequestParam(required = false) String name,
//                                                                    @RequestParam(required = false) String topic) {
//        CustomPage<CourseDto> coursesPage = courseService.getAllCourses(page, pageSize, type, name, topic);
//        return ResponseEntity.ok(coursesPage);
//    }
//
//    @GetMapping("admin/courses/{id}")
//    public ResponseEntity<?> getCourseByIdAdmin(@PathVariable Integer id) {
//        Course course = courseService.getCourseById(id);
//        return ResponseEntity.ok(course);
//    }
//
//    @PostMapping("admin/courses/{id}")
//    @ResponseStatus(HttpStatus.CREATED) // 201
//    public ResponseEntity<?> createCourse() {
//        Course course = courseService.createCourse();
//        return ResponseEntity.ok(course);
//    }
//
//    @PutMapping("admin/courses/{id}")
//    public ResponseEntity<?> updateCourseById(@PathVariable Integer id) {
//        Course course = courseService.getCourseById(id);
//        return ResponseEntity.ok(course);
//    }
//
//    @DeleteMapping("admin/courses/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
//    public void deleteCourseById(@PathVariable Integer id) {
//        courseService.deleteCourseById(id);
//    }
}





