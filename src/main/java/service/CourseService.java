package service;

import dto.CourseRequest;
import dto.CourseResponse;
import entity.Course;
import entity.Student;
import exception.CourseCreationException;
import exception.CourseNotFoundException;
import repository.interfaces.InterfaceCourseRepository;
import service.interfaces.CourseServiceInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CourseService implements CourseServiceInterface {
    private final InterfaceCourseRepository courseRepository;

    public CourseService(InterfaceCourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    private CourseResponse convertToResponse(Course course) {
        return new CourseResponse(
                course.getCourseTitle(),
                course.getCourseDescription(),
                course.getCourseContent()
        );
    }

    @Override
    public CourseResponse createCourse(CourseRequest courseRequest) throws CourseCreationException {
        try {
            int courseId = courseRepository.findAll().stream()
                    .mapToInt(Course::getCourseId)
                    .max()
                    .orElse(0) + 1;

            Course newCourse = new Course(
                    courseId,
                    courseRequest.getCourseTitle(),
                    courseRequest.getCourseDescription(),
                    new ArrayList<>(),
                    new ArrayList<>()
            );

            courseRepository.addCourse(newCourse.getCourseTitle(), newCourse.getCourseDescription());

            Course createdCourse = courseRepository.findByCourseTitle(newCourse.getCourseTitle())
                    .orElseThrow(() -> new CourseCreationException("Failed to create course"));

            return convertToResponse(createdCourse);
        } catch (Exception e) {
            throw new CourseCreationException("Ошибка при создании курса: " + e.getMessage());
        }
    }

    @Override
    public void addContentToCourse(Integer courseId, String content) throws CourseNotFoundException {
        try {
            Optional<Course> optionalCourse = courseRepository.findCourseById(courseId);
            if (optionalCourse.isPresent()) {
                Course course = optionalCourse.get();
                course.getCourseContent().add(content);

            } else {
                throw new CourseNotFoundException("Курс с ID " + courseId + " не найден");
            }
        } catch (Exception e) {
            throw new CourseNotFoundException("Ошибка при добавлении контента к курсу: " + e.getMessage());
        }
    }

    @Override
    public String addStudentToCourse(Integer courseId, Student student) throws CourseNotFoundException {
        Optional<Course> optionalCourse = courseRepository.findCourseById(courseId);
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            course.getStudents().add(student);

            return "Student added to the course successfully";
        } else {
            throw new CourseNotFoundException("Курс с ID " + courseId + " не найден");
        }
    }

    @Override
    public List<CourseResponse> getAllCourses() {
        List<CourseResponse> courseResponses = courseRepository.findAll().stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());

        System.out.println("Все курсы:");
        System.out.println();
        courseResponses.forEach(courseResponse -> {
            System.out.println(courseResponse);
            System.out.println("---------------------------");
        });

        return courseResponses;
    }

    @Override
    public void updateCourseContent(Integer courseId, CourseRequest updatedCourse) throws CourseNotFoundException {
        try {
            Optional<Course> optionalCourse = courseRepository.findCourseById(courseId);
            if (optionalCourse.isPresent()) {
                Course course = optionalCourse.get();
                course.setCourseTitle(updatedCourse.getCourseTitle());
                course.setCourseDescription(updatedCourse.getCourseDescription());

            } else {
                throw new CourseNotFoundException("Курс с ID " + courseId + " не найден");
            }
        } catch (Exception e) {
            throw new CourseNotFoundException("Ошибка при обновлении контента курса: " + e.getMessage());
        }
    }

    @Override
    public void printCourseContent(Integer courseId) throws CourseNotFoundException {
        Optional<Course> optionalCourse = courseRepository.findCourseById(courseId);
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            System.out.println("Контент курса:");
            System.out.println();
            course.getCourseContent().forEach(System.out::println);
        } else {
            throw new CourseNotFoundException("Курс с ID " + courseId + " не найден");
        }
    }

    @Override
    public void printCourseStudents(Integer courseId) throws CourseNotFoundException {
        Optional<Course> optionalCourse = courseRepository.findCourseById(courseId);
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            System.out.println("Студенты курса:");
            course.getStudents().forEach(student -> System.out.println(student.getName())); // Предполагается, что у студента есть метод getName()
        } else {
            throw new CourseNotFoundException("Курс с ID " + courseId + " не найден");
        }
    }

    @Override
    public void editCourseContent(Integer courseId, int contentIndex, String newContent) throws CourseNotFoundException {
        Optional<Course> optionalCourse = courseRepository.findCourseById(courseId);
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            if (contentIndex >= 0 && contentIndex < course.getCourseContent().size()) {
                course.getCourseContent().set(contentIndex, newContent);
            } else {
                throw new CourseNotFoundException("Индекс контента выходит за пределы");
            }
        } else {
            throw new CourseNotFoundException("Курс с ID " + courseId + " не найден");
        }
    }

    @Override
    public void removeCourseContent(Integer courseId, String content) throws CourseNotFoundException {
        Optional<Course> optionalCourse = courseRepository.findCourseById(courseId);
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            course.getCourseContent().remove(content);
        } else {
            throw new CourseNotFoundException("Курс с ID " + courseId + " не найден");
        }
    }

    @Override
    public void removeStudentFromCourse(Integer courseId, Student student) throws CourseNotFoundException {
        Optional<Course> optionalCourse = courseRepository.findCourseById(courseId);
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            course.getStudents().remove(student);
        } else {
            throw new CourseNotFoundException("Курс с ID " + courseId + " не найден");
        }
    }

    @Override
    public CourseResponse getCourseById(Integer courseId) throws CourseNotFoundException {
        Optional<Course> optionalCourse = courseRepository.findCourseById(courseId);
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            return convertToResponse(course);
        } else {
            throw new CourseNotFoundException("Курс с ID " + courseId + " не найден");
        }
    }
}
