package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.GroupRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private GroupRepository groupRepository;

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public void removeStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public long countStudents() {
        return studentRepository.count();
    }

    public List<Student> getStudentsByGroup(Long groupId) {
        final var group = groupRepository.findById(groupId).orElse(null);
        return studentRepository.findByGroup(group);
    }

    public List<Student> getStudentsOlderThanByCourse(int age, Long courseId) {
        final var course = courseRepository.findById(courseId).orElse(null);
        return studentRepository.findByAgeGreaterThanAndCourses(age, course);
    }

    public List<Student> getStudentsByCourse(Long courseId) {
        final var course = courseRepository.findById(courseId).orElse(null);
        return studentRepository.findByCourses(course);
    }
}
