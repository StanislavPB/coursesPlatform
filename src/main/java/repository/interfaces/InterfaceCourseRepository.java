package repository.interfaces;

import entity.Course;

import java.util.List;
import java.util.Optional;

public interface InterfaceCourseRepository {

        List<Course> addCourse (String courseTitle, String courseDescription);
        Optional <Course> findById(Integer courseId);
        List<Course> findAll();
        Optional <Course> findByCourseTitle(String courseTitle);

        boolean deleteCourse(Course course);
        boolean deleteAllCourses(List<Course> coursesToDelete);

    }

