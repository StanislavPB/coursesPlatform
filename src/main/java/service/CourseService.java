package service;

import dto.CourseRequest;
import dto.CourseResponse;
import entity.Course;
import entity.Student;
import exception.CourseCreationException;
import exception.CourseNotFoundException;
import repository.interfaces.InterfaceCourseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CourseService {
    private final InterfaceCourseRepository courseRepository;

    public CourseService(InterfaceCourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // Преобразование CourseRequest в Course
    private Course convertToEntity(CourseRequest courseRequest, int courseId) {
        return new Course(
                courseId,
                courseRequest.getCourseTitle(),
                courseRequest.getCourseDescription(),
                new ArrayList<>(), // Пустой контент при создании нового курса
                new ArrayList<>()
        );
    }

    // Преобразование Course в CourseResponse
    private CourseResponse convertToResponse(Course course) {
        return new CourseResponse(
                course.getCourseTitle(),
                course.getCourseDescription(),
                course.getCourseContent()
        );
    }

    public CourseResponse createCourse(CourseRequest courseRequest) throws CourseCreationException {
        try {
            int courseId = courseRepository.findAll().stream()
                    .mapToInt(Course::getCourseId)
                    .max()
                    .orElse(0) + 1;
            Course course = convertToEntity(courseRequest, courseId);
            courseRepository.addCourse(course.getCourseTitle(), course.getCourseDescription());
            Course createdCourse = courseRepository.findByCourseTitle(course.getCourseTitle())
                    .orElseThrow(() -> new CourseCreationException("Failed to create course"));
            return convertToResponse(createdCourse);
        } catch (Exception e) {
            throw new CourseCreationException("An error occurred while creating the course: " + e.getMessage());
        }
    }

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

    public List<CourseResponse> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }
}
