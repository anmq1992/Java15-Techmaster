package com.example.ktspringrestapi.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateCoursePostRequest {
    private Integer id;
    private String title;
    private String author;
}
