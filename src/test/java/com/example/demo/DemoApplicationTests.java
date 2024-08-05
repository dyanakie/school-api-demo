package com.example.demo;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.entity.StudentGroup;
import com.example.demo.entity.Teacher;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.GroupRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.TeacherRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private TeacherRepository teacherRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private GroupRepository groupRepository;

	@Test
	void contextLoads() {
	}

	@Test
	@Transactional
	void testStudentCRUD() {
		final var group = groupRepository.save(new StudentGroup(null, "Group A", null, null));
		final var course1 = courseRepository.save(new Course(null, "Course 1", "Main"));
		final var course2 = courseRepository.save(new Course(null, "Course 2", "Secondary"));

		final var courses = new ArrayList<>(Arrays.asList(course1, course2));
		var student = new Student(null, "John Doe", 20, group, courses);
		student = studentRepository.save(student);

		Assertions.assertNotNull(student.getId());
		Assertions.assertEquals("John Doe", student.getName());

		student.setName("John Doe Updated");
		student.setCourses(new ArrayList<>(Arrays.asList(course1)));
		student = studentRepository.save(student);

		final var foundStudent = studentRepository.findById(student.getId()).orElse(null);
		Assertions.assertNotNull(foundStudent);
		Assertions.assertEquals("John Doe Updated", foundStudent.getName());

		studentRepository.deleteById(student.getId());
		final var deletedStudent = studentRepository.findById(student.getId()).orElse(null);
		Assertions.assertNull(deletedStudent);
	}

	@Test
	@Transactional
	void testTeacherCRUD() {
		final var course1 = courseRepository.save(new Course(null, "Course 1", "Main"));
		final var course2 = courseRepository.save(new Course(null, "Course 2", "Secondary"));
		final var group1 = groupRepository.save(new StudentGroup(null, "Group A", null, null));
		final var group2 = groupRepository.save(new StudentGroup(null, "Group B", null, null));

		final var courses = new ArrayList<>(Arrays.asList(course1, course2));
		final var groups = new ArrayList<>(Arrays.asList(group1, group2));
		var teacher = new Teacher(null, "Prof. Alan Turing", 45, courses, groups);
		teacher = teacherRepository.save(teacher);

		Assertions.assertNotNull(teacher.getId());
		Assertions.assertEquals("Prof. Alan Turing", teacher.getName());

		teacher.setName("Prof. Alan Turing Updated");
		teacher.setCourses(new ArrayList<>(List.of(course1)));
		teacher.setGroups(new ArrayList<>(List.of(group1)));
		teacher = teacherRepository.save(teacher);

		final var foundTeacher = teacherRepository.findById(teacher.getId()).orElse(null);
		Assertions.assertNotNull(foundTeacher);
		Assertions.assertEquals("Prof. Alan Turing Updated", foundTeacher.getName());

		teacherRepository.deleteById(teacher.getId());
		final var deletedTeacher = teacherRepository.findById(teacher.getId()).orElse(null);
		Assertions.assertNull(deletedTeacher);
	}

	@Test
	@Transactional
	void testCourseCRUD() {
		var course = new Course(null, "Course 1", "Main");
		course = courseRepository.save(course);

		Assertions.assertNotNull(course.getId());
		Assertions.assertEquals("Course 1", course.getName());

		course.setName("Course 1 Updated");
		course = courseRepository.save(course);

		final var foundCourse = courseRepository.findById(course.getId()).orElse(null);
		Assertions.assertNotNull(foundCourse);
		Assertions.assertEquals("Course 1 Updated", foundCourse.getName());

		courseRepository.deleteById(course.getId());
		final var deletedCourse = courseRepository.findById(course.getId()).orElse(null);
		Assertions.assertNull(deletedCourse);
	}

	@Test
	@Transactional
	void testGroupCRUD() {
		var group = new StudentGroup(null, "Group A", null, null);
		group = groupRepository.save(group);

		Assertions.assertNotNull(group.getId());
		Assertions.assertEquals("Group A", group.getName());

		group.setName("Group A Updated");
		group = groupRepository.save(group);

		final var foundGroup = groupRepository.findById(group.getId()).orElse(null);
		Assertions.assertNotNull(foundGroup);
		Assertions.assertEquals("Group A Updated", foundGroup.getName());

		groupRepository.deleteById(group.getId());
		final var deletedGroup = groupRepository.findById(group.getId()).orElse(null);
		Assertions.assertNull(deletedGroup);
	}
}
