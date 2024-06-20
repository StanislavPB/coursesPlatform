package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    private Course course;
    private List<String> initialContent;
    private List<Student> initialStudents;

    @BeforeEach
    void setUp() {
        initialContent = new ArrayList<>();
        initialContent.add("Introduction");
        initialContent.add("Chapter 1");

        initialStudents = new ArrayList<>();
        initialStudents.add(new Student(1, "John Doe", "john_doe@gmail.com"));
        initialStudents.add(new Student(2, "Jane Smith", "jane_smith@gmail.com"));

        course = new Course(1, "Test Course", "This is a test course", initialContent, initialStudents);
    }

    @Test
    void testGetCourseId() {
        assertEquals(1, course.getCourseId());
    }

    @Test
    void testSetCourseId() {
        course.setCourseId(2);
        assertEquals(2, course.getCourseId());
    }

    @Test
    void testGetCourseTitle() {
        assertEquals("Test Course", course.getCourseTitle());
    }

    @Test
    void testSetCourseTitle() {
        course.setCourseTitle("New Title");
        assertEquals("New Title", course.getCourseTitle());
    }

    @Test
    void testGetCourseDescription() {
        assertEquals("This is a test course", course.getCourseDescription());
    }

    @Test
    void testSetCourseDescription() {
        course.setCourseDescription("New Description");
        assertEquals("New Description", course.getCourseDescription());
    }

    @Test
    void testGetCourseContent() {
        List<String> content = course.getCourseContent();
        assertEquals(initialContent, content);
    }

    @Test
    void testSetCourseContent() {
        List<String> newContent = new ArrayList<>();
        newContent.add("New Introduction");
        course.setCourseContent(newContent);

        List<String> content = course.getCourseContent();
        assertEquals(newContent, content);
    }

    @Test
    void testGetStudents() {
        List<Student> students = course.getStudents();
        assertEquals(initialStudents, students);
    }

    @Test
    void testSetStudents() {
        List<Student> newStudents = new ArrayList<>();
        newStudents.add(new Student(3, "Alice Johnson", "alice_johnson@gmail.com"));
        course.setStudents(newStudents);

        List<Student> students = course.getStudents();
        assertEquals(newStudents, students);
    }

    @Test
    void testToString() {
        String expected = "Course{" +
                "courseId=" + course.getCourseId() +
                ", courseTitle='" + course.getCourseTitle() + '\'' +
                ", courseDescription='" + course.getCourseDescription() + '\'' +
                ", courseContent=" + course.getCourseContent() +
                ", students=" + course.getStudents() +
                '}';
        assertEquals(expected, course.toString());
    }
}
