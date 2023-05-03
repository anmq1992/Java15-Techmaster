package com.example.ktspringrestapi.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Course {
    private Integer id;
    private String name;
    private String description;
    private String type;
    private List<Topic> topics;
    private String thumbnail;
    private Integer userId;


}
