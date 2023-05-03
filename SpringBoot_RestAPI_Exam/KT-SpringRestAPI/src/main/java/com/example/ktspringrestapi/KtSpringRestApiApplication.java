package com.example.ktspringrestapi;

import com.example.ktspringrestapi.db.CourseDB;
import com.example.ktspringrestapi.db.GenerateData;
import com.example.ktspringrestapi.db.UserDB;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KtSpringRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(KtSpringRestApiApplication.class, args);
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
