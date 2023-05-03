package com.example.ktspringrestapi.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCourseRequest {
    @NotEmpty(message = "Course Name cannot be empty")
    private String name;

    @NotEmpty(message = "userID cannot be empty")
    private Integer userId;

    @NotEmpty(message = "description cannot be empty")
    @Size(min = 50)
    private String description ;

    @NotEmpty(message = "type cannot be empty")
    private String type ;
    private List<String> topics ;
    private String thumbnail;

//    @NotEmpty(message = "level không được để trống")
//    private String level;
}
