package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.StudentGroup;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.model.GroupDto;
import com.example.demo.model.StudentDto;
import com.example.demo.model.TeacherDto;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.GroupRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    @Autowired
    private UtilService utilService;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private GroupRepository groupRepository;

    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public void removeTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

    public Teacher updateTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public long countTeachers() {
        return teacherRepository.count();
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public void removeCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    public long countCoursesByType(String type) {
        return courseRepository.findAll().stream().filter(course -> course.getType().equals(type)).count();
    }

    public StudentGroup createNewGroup(GroupDto group) {
        final var newGroup = new StudentGroup();
        newGroup.setName(group.getName());
        return groupRepository.save(newGroup);
    }

    public List<Object> getTeachersAndStudentsByGroupAndCourse(Long groupId, Long courseId) {
        final var group = groupRepository.findById(groupId).orElse(null);
        final var course = courseRepository.findById(courseId).orElse(null);
        final var students = studentRepository.findByGroup(group).stream()
                .filter(student -> student.getCourses().contains(course))
                .map(utilService::convertToStudentDTO)
                .toList();
        final var teachers = teacherRepository.findAll().stream()
                .filter(teacher -> teacher.getCourses().contains(course))
                .map(utilService::convertToTeacherDTO)
                .toList();;
        return Arrays.asList(students, teachers);
    }
}
