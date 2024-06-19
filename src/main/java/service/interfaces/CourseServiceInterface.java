package service.interfaces;

import dto.CourseRequest;
import dto.CourseResponse;
import entity.Student;
import exception.CourseCreationException;
import exception.CourseNotFoundException;

import java.util.List;

public interface CourseServiceInterface {
    CourseResponse createCourse(CourseRequest courseRequest) throws CourseCreationException;
    void addContentToCourse(Integer courseId, String content) throws CourseNotFoundException;
    void addStudentToCourse(Integer courseId, Student student) throws CourseNotFoundException;
    List<CourseResponse> getAllCourses();
}

