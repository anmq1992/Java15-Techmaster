package com.example.coursemgmt_backend.repository;

import com.example.coursemgmt_backend.db.CourseDB;
import com.example.coursemgmt_backend.model.Course;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepository {
    public List<Course> findAll() {
        return CourseDB.courses;
    }

    public Integer getSize() {
        return CourseDB.courses.size();
    }

    public Optional<Course> findById(Integer id) {
        return CourseDB.courses.stream()
                .filter(course -> course.getId().equals(id))
                .findFirst();
    }

    public Optional<Course> findByName(String name) {
        return CourseDB.courses.stream()
                .filter(course -> course.getName().equals(name))
                .findFirst();
    }

    public void save(Course course) {
        CourseDB.courses.add(course);
    }

    public void deleteById(int id){
        CourseDB.courses.removeIf(course -> course.getId() == id);

    }
}
