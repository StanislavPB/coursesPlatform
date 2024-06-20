package repository.interfaces;

import entity.Course;
import entity.Student;
import exception.CourseNotFoundException;

import java.util.List;
import java.util.Optional;

public interface InterfaceCourseRepository {

        List<Course> addCourse(String courseTitle, String courseDescription);
        Optional<Course> findCourseById(Integer courseId); // Новый метод для поиска курса по ID
        List<Course> findAll();
        Optional<Course> findByCourseTitle(String courseTitle);
        boolean deleteCourse(Course course);
        boolean deleteAllCourses(List<Course> coursesToDelete);
        String addStudentToCourse(Integer courseId, Student student) throws CourseNotFoundException;
}


