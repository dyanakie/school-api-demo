package com.example.demo.model;

import com.example.demo.model.base.BaseSchoolEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto extends BaseSchoolEntity {
    private String groupName;
    private final String type = "Student";
}
