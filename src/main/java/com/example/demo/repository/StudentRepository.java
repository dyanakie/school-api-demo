package com.example.demo.repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.StudentGroup;
import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByCourses(Course course);
    List<Student> findByGroup(StudentGroup group);
    List<Student> findByAgeGreaterThanAndCourses(int age, Course course);
}
