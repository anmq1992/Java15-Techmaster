package com.example.coursemgmt_backend.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCourseReq {
    @NotNull(message = "Course Name is required")
    @NotEmpty(message = "Course Name is required")
    private String name;

    @NotNull(message = "Description is required")
    @NotEmpty(message = "Description is required")
    private String description;

    @NotNull(message = "Course Type is required")
    @NotEmpty(message = "Course Type is required")
    private String type;

    private List<String> topics;

    private String thumbnail;
    @NotNull(message = "User ID is required")
    private Integer userId;

}
