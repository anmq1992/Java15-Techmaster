package com.example.ktspringrestapi.db;

import com.example.ktspringrestapi.model.Course;
import com.example.ktspringrestapi.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;
import java.util.List;
import java.util.Random;

public class CourseDB {

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseDB.class);

    public static List<Course> courses;
//    public static List<Course> courses;



//
//    public static void setCourses(List<Course> courses) {
//        CourseDB.courses = courses;
//    }

}
