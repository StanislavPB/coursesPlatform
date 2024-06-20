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

    String addStudentToCourse(Integer courseId, Student student) throws CourseNotFoundException;

    List<CourseResponse> getAllCourses();

    void updateCourseContent(Integer courseId, CourseRequest updatedCourse) throws CourseNotFoundException;

    void printCourseContent(Integer courseId) throws CourseNotFoundException;

    void printCourseStudents(Integer courseId) throws CourseNotFoundException;

    void editCourseContent(Integer courseId, int contentIndex, String newContent) throws CourseNotFoundException;

    void removeCourseContent(Integer courseId, String content) throws CourseNotFoundException;

    void removeStudentFromCourse(Integer courseId, Student student) throws CourseNotFoundException;

    CourseResponse getCourseById(Integer courseId) throws CourseNotFoundException;
}
