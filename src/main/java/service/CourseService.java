package service;

import entity.Course;
import entity.Student;
import exception.CourseCreationException;
import exception.CourseNotFoundException;
import repository.interfaces.InterfaceCourseRepository;

import java.util.Optional;

public class CourseService {
    private final InterfaceCourseRepository courseRepository;

    public CourseService(InterfaceCourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // Создание нового курса
    public Course createCourse(String courseTitle, String courseDescription) throws CourseCreationException {
        try {
            courseRepository.addCourse(courseTitle, courseDescription);
            return courseRepository.findByCourseTitle(courseTitle)
                    .orElseThrow(() -> new CourseCreationException("Failed to create course"));
        } catch (Exception e) {
            throw new CourseCreationException("An error occurred while creating the course: " + e.getMessage());
        }
    }

    // Добавление контента в курс
    public void addContentToCourse(Integer courseId, String content) throws CourseNotFoundException {
        try {
            Optional<Course> optionalCourse = courseRepository.findById(courseId);
            if (optionalCourse.isPresent()) {
                Course course = optionalCourse.get();
                course.getCourseContent().add(content);
                courseRepository.updateCourseContent(courseId, course);
            } else {
                throw new CourseNotFoundException("Course with ID " + courseId + " not found");
            }
        } catch (Exception e) {
            throw new CourseNotFoundException("An error occurred while adding content to the course: " + e.getMessage());
        }
    }

    // Добавление студента в курс
    public void addStudentToCourse(Integer courseId, Student student) throws CourseNotFoundException {
        try {
            Optional<Course> optionalCourse = courseRepository.findById(courseId);
            if (optionalCourse.isPresent()) {
                Course course = optionalCourse.get();
                course.getStudents().add(student);
                courseRepository.updateCourseContent(courseId, course);
            } else {
                throw new CourseNotFoundException("Course with ID " + courseId + " not found");
            }
        } catch (Exception e) {
            throw new CourseNotFoundException("An error occurred while adding the student to the course: " + e.getMessage());
        }
    }
}
