package com.example.ktspringrestapi.request;

import com.example.ktspringrestapi.model.Topic;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCourseRequest {

    private Integer id;
    private String name;
    private String description;
    private String type;
    private List<Topic> topics;
    private String thumbnail;
    private Integer userId;

}
