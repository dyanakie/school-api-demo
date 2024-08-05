package com.example.demo.model;

import com.example.demo.model.base.BaseSchoolEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDto extends BaseSchoolEntity {
    private String[] groupNames;
    private final String type = "Teacher";
}
