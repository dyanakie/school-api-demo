package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GroupCourseResponseDto {
    private List<StudentDto> students;
    private List<TeacherDto> teachers;
}
