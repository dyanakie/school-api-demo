package com.example.demo.model.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseSchoolEntity {
    private Long id;
    private String name;
    private int age;
    private String[] courseNames;
}
