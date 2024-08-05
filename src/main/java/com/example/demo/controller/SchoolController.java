package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.entity.StudentGroup;
import com.example.demo.entity.Teacher;
import com.example.demo.model.GroupCourseResponseDto;
import com.example.demo.model.GroupDto;
import com.example.demo.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @PostMapping("/teachers")
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return schoolService.addTeacher(teacher);
    }

    @DeleteMapping("/teachers/{id}")
    public void removeTeacher(@PathVariable Long id) {
        schoolService.removeTeacher(id);
    }

    @PutMapping("/teachers")
    public Teacher updateTeacher(@RequestBody Teacher teacher) {
        return schoolService.updateTeacher(teacher);
    }

    @GetMapping("/teachers/count")
    public long countTeachers() {
        return schoolService.countTeachers();
    }

    @PostMapping("/groups")
    public StudentGroup addGroup(@RequestBody GroupDto group) {
        return schoolService.createNewGroup(group);
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course) {
        return schoolService.addCourse(course);
    }

    @DeleteMapping("/courses/{id}")
    public void removeCourse(@PathVariable Long id) {
        schoolService.removeCourse(id);
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course) {
        return schoolService.updateCourse(course);
    }

    @GetMapping("/courses/count")
    public long countCoursesByType(@RequestParam String type) {
        return schoolService.countCoursesByType(type);
    }

    @GetMapping("/group/course")
    public GroupCourseResponseDto getTeachersAndStudentsByGroupAndCourse(@RequestParam Long groupId, @RequestParam Long courseId) {
        return schoolService.getTeachersAndStudentsByGroupAndCourse(groupId, courseId);
    }
}
