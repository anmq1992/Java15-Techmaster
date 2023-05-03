package com.example.ktspringrestapi.dto;

import com.example.ktspringrestapi.model.Topic;
import com.example.ktspringrestapi.model.User;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CourseDto {
    private Integer id;
    private String name;
    private String description;
    private String type;
    private List<Topic> topics;
    private String thumbnail;
    private User user;
}
