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

/*
##Курс
Создать новый курс ~~~~~~ +++ ~~~~~~
Вывести на экран контент курса (строки из коллекции)
Вывести на экран список студентов курса
Вывод на экран списка всех курсов (В читабельном виде) ~~~~~~ +++ ~~~~~~

Изменить контент курса ~~~~~~ +++ ~~~~~~
Редактировать экземпляр коллекции контент курса(Строку)
Удалить экземпляр коллекции контент курса (Строку)
Добавить Студента на курс (в коллекцию) ~~~~~~ +++ ~~~~~~
Удалить студента из коллекции курса
 */

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
    public CourseResponse createCourse(CourseRequest courseRequest) throws CourseCreationException {  //Создать новый курс
        try {
            int courseId = courseRepository.findAll().stream()
                    .mapToInt(Course::getCourseId)
                    .max()
                    .orElse(0) + 1;

            Course course = new Course(
                    courseId,
                    courseRequest.getCourseTitle(),
                    courseRequest.getCourseDescription(),
                    new ArrayList<>(),
                    new ArrayList<>()
            );

            courseRepository.addCourse(course.getCourseTitle(), course.getCourseDescription());

            Course createdCourse = courseRepository.findByCourseTitle(course.getCourseTitle())
                    .orElseThrow(() -> new CourseCreationException("Failed to create course"));

            return convertToResponse(createdCourse);
        } catch (Exception e) {
            throw new CourseCreationException("An error occurred while creating the course: " + e.getMessage());
        }
    }

    @Override
    public void addContentToCourse(Integer courseId, String content) throws CourseNotFoundException {
        try {
            Optional<Course> optionalCourse = courseRepository.findById(courseId);
            if (optionalCourse.isPresent()) {
                Course course = optionalCourse.get();
                course.getCourseContent().add(content);

            } else {
                throw new CourseNotFoundException("Course with ID " + courseId + " not found");
            }
        } catch (Exception e) {
            throw new CourseNotFoundException("An error occurred while adding content to the course: " + e.getMessage());
        }
    }

    @Override
    public void addStudentToCourse(Integer courseId, Student student) throws CourseNotFoundException {
        try {
            Optional<Course> optionalCourse = courseRepository.findById(courseId);
            if (optionalCourse.isPresent()) {
                Course course = optionalCourse.get();
                course.getStudents().add(student);

            } else {
                throw new CourseNotFoundException("Course with ID " + courseId + " not found");
            }
        } catch (Exception e) {
            throw new CourseNotFoundException("An error occurred while adding the student to the course: " + e.getMessage());
        }
    }


    @Override
    public List<CourseResponse> getAllCourses() {                                                      // Вывод на экран списка всех курсов (В читабельном виде)
        List<CourseResponse> courseResponses = courseRepository.findAll().stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());

        System.out.println("All courses:");
        System.out.println();
        courseResponses.forEach(courseResponse -> {
            System.out.println(courseResponse);
            System.out.println("---------------------------");
        });

        return courseResponses;
    }

    @Override
    public void updateCourseContent(Integer courseId, CourseRequest updatedCourse) throws CourseNotFoundException { // Изменить контент курса
        try {
            Optional<Course> optionalCourse = courseRepository.findById(courseId);
            if (optionalCourse.isPresent()) {
                Course course = optionalCourse.get();
                course.setCourseTitle(updatedCourse.getCourseTitle());
                course.setCourseDescription(updatedCourse.getCourseDescription());

            } else {
                throw new CourseNotFoundException("Course with ID " + courseId + " not found");
            }
        } catch (Exception e) {
            throw new CourseNotFoundException("An error occurred while adding the student to the course: " + e.getMessage());
        }
    }

    @Override
    public void printCourseContent(Integer courseId) throws CourseNotFoundException {
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        if (optionalCourse.isPresent()){
            Course course = optionalCourse.get();
            System.out.println("Course content: ");
            System.out.println();
            course.getCourseContent().forEach(System.out::println);
        } else {
            throw new CourseNotFoundException("Course with ID " + courseId + " not found");
        }
    }

    @Override
    public void printCourseStudents(Integer courseId) throws CourseNotFoundException {
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            System.out.println("Course students:");
            course.getStudents().forEach(student -> System.out.println(student.getName())); // Assuming Student has a getName method
        } else {
            throw new CourseNotFoundException("Course with ID " + courseId + " not found");
        }
    }

    @Override
    public void editCourseContent(Integer courseId, int contentIndex, String newContent) throws CourseNotFoundException {
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            if (contentIndex >= 0 && contentIndex < course.getCourseContent().size()) {
                course.getCourseContent().set(contentIndex, newContent);
            } else {
                throw new CourseNotFoundException("Content index out of bounds");
            }
        } else {
            throw new CourseNotFoundException("Course with ID " + courseId + " not found");
        }
    }

    @Override
    public void removeCourseContent(Integer courseId, String content) throws CourseNotFoundException {
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            course.getCourseContent().remove(content);
        } else {
            throw new CourseNotFoundException("Course with ID " + courseId + " not found");
        }
    }

    @Override
    public void removeStudentFromCourse(Integer courseId, Student student) throws CourseNotFoundException {
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            course.getStudents().remove(student);
        } else {
            throw new CourseNotFoundException("Course with ID " + courseId + " not found");
        }
    }

}

