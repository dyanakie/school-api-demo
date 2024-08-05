package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.model.StudentDto;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.GroupRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentsService {

    @Autowired
    private UtilService utilService;
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

    public List<StudentDto> getStudentsByGroup(Long groupId) {
        final var group = groupRepository.findById(groupId).orElse(null);
        return studentRepository.findByGroup(group).stream()
                .map(utilService::convertToStudentDTO)
                .toList();
    }

    public List<StudentDto> getStudentsOlderThanByCourse(int age, Long courseId) {
        final var course = courseRepository.findById(courseId).orElse(null);
        return studentRepository.findByAgeGreaterThanAndCourses(age, course).stream()
                .filter(student -> Objects.equals(student.getType(), "Student"))
                .map(utilService::convertToStudentDTO)
                .toList();
    }

    public List<StudentDto> getStudentsByCourse(Long courseId) {
        final var course = courseRepository.findById(courseId).orElse(null);
        return studentRepository.findByCourses(course).stream()
                .map(utilService::convertToStudentDTO)
                .toList();
    }
}
