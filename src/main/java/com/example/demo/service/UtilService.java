package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.entity.StudentGroup;
import com.example.demo.entity.Teacher;
import com.example.demo.model.StudentDto;
import com.example.demo.model.TeacherDto;
import org.springframework.stereotype.Service;

@Service
public class UtilService {
    public StudentDto convertToStudentDTO(Student student) {
        final var newStudent = new StudentDto();
        newStudent.setId(student.getId());
        newStudent.setAge(student.getAge());
        newStudent.setName(student.getName());
        newStudent.setGroupName(student.getGroup().getName());
        newStudent.setCourseNames(student.getCourses().stream().map(Course::getName).toArray(String[]::new));
        return newStudent;
    }

    public TeacherDto convertToTeacherDTO(Teacher teacher) {
        final var newTeacher = new TeacherDto();
        newTeacher.setId(teacher.getId());
        newTeacher.setAge(teacher.getAge());
        newTeacher.setName(teacher.getName());
        newTeacher.setGroupNames(teacher.getGroups().stream().map(StudentGroup::getName).toArray(String[]::new));
        newTeacher.setCourseNames(teacher.getCourses().stream().map(Course::getName).toArray(String[]::new));
        return newTeacher;
    }
}
