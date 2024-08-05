package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentsController {
    @Autowired
    private StudentsService studentsService;

    @PostMapping()
    public Student addStudent(@RequestBody Student student) {
        return studentsService.addStudent(student);
    }

    @DeleteMapping("/{id}")
    public void removeStudent(@PathVariable Long id) {
        studentsService.removeStudent(id);
    }

    @PutMapping()
    public Student updateStudent(@RequestBody Student student) {
        return studentsService.updateStudent(student);
    }

    @GetMapping("/count")
    public long countStudents() {
        return studentsService.countStudents();
    }

    @GetMapping("/course")
    public List<Student> getStudentsByCourse(@RequestParam Long courseId) {
        return studentsService.getStudentsByCourse(courseId);
    }

    @GetMapping("/group")
    public List<Student> getStudentsByGroup(@RequestParam Long groupId) {
        return studentsService.getStudentsByGroup(groupId);
    }

    @GetMapping("/age")
    public List<Student> getStudentsOlderThanByCourse(@RequestParam int age, @RequestParam Long courseId) {
        return studentsService.getStudentsOlderThanByCourse(age, courseId);
    }
}
