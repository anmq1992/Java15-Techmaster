package com.example.coursemgmt_backend;

import com.example.coursemgmt_backend.db.CourseDB;
import com.example.coursemgmt_backend.db.GenerateData;
import com.example.coursemgmt_backend.db.UserDB;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CourseMgmtBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseMgmtBackendApplication.class, args);
    }
    @Bean
    public Faker faker() {
        return new Faker();
    }

    // Sử dụng để khởi tạo dữ liệu ban đầu cho ứng dụng (users, courses)
    @Bean
    public CommandLineRunner commandLineRunner(GenerateData generateData) {
        return (args) -> {
            UserDB.users = generateData.initUsers();
            CourseDB.courses = generateData.initCourses(UserDB.users);
        };
    }
}
