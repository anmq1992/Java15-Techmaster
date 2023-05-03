package com.example.coursemgmt_backend.dto;

import com.example.coursemgmt_backend.model.Topic;
import com.example.coursemgmt_backend.model.User;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CourseDto {
    private Integer id;
    private String name;
    private String description;
    private String type;
    private List<String> topics;
    private String thumbnail;
    private User user;
}
