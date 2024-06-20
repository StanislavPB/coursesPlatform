package service;

import entity.Course;
import entity.Student;
import exception.CourseNotFoundException;
import org.junit.jupiter.api.Test;
import repository.CourseRepository;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CourseServiceTest {

    private static class SpoofCourseRepository extends CourseRepository {   // здесь мы реализуем фиктивную реализацию CourseRepository для теста
        public SpoofCourseRepository(List<Course> courses) {
            super(courses);
        }
    }

    @Test
    void addContentToExistingCourse() {                  // Тест, проверяющий добавление контента к существующему курсу.
        // здесь мы подготавливаем данные для теста
        List<Course> courses = new ArrayList<>(); // создаем пустой список курсов
        SpoofCourseRepository fakeRepository = new SpoofCourseRepository(courses); // создаем экземпляр фиктивного репозитория с пустым списком курсов
        CourseService courseService = new CourseService(fakeRepository); // создаем экземпляр CourseService с фиктивным репозиторием

        List<String> initialContent = new ArrayList<>();      // создаем пустой список начального контента
        List<Student> students = new ArrayList<>();            // и пустой список студентов
        Course existingCourse = new Course(1, "Java Basics", "Introduction to Java", initialContent, students); // наконец создаем новый курс
        fakeRepository.addCourse(existingCourse.getCourseTitle(), existingCourse.getCourseDescription());    // добавляем курс в фиктивный репозиторий
        fakeRepository.findCourseById(1).ifPresent(course -> course.setCourseContent(initialContent)); // устанавливаем начальный контент для курса, если он найден
        fakeRepository.findCourseById(1).ifPresent(course -> course.setStudents(students));   // добавляем студентов для курса, если он найден

        Integer courseId = existingCourse.getCourseId(); // получаем ID курса
        String contentToAdd = "New content";  // задаем новый контент для добавления

        try {
            courseService.addContentToCourse(courseId, contentToAdd);           // пробуем добавить контент к курсу
            assertTrue(existingCourse.getCourseContent().contains(contentToAdd));  // проверяем, что новый контент добавлен в курс
        } catch (CourseNotFoundException e) {
            fail("Unexpected CourseNotFoundException: " + e.getMessage());   // если нет - ловим ошибку
        }
    }

    @Test
    void addContentToCourseAndShouldThrowException() {           // Тест, проверяющий выброс исключения при попытке добавления контента к несуществующему курсу
        //  здесь мы подготавливаем данные для теста
        List<Course> courses = new ArrayList<>();    // создаем пустой список курсов
        SpoofCourseRepository fakeRepository = new SpoofCourseRepository(courses); // создаем экземпляр фиктивного репозитория с пустым списком курсов
        CourseService courseService = new CourseService(fakeRepository);   // создает экземпляр CourseService с фиктивным репозиторием

        Integer nonExistingCourseId = 999;     // задаем ID несуществующего курса
        String contentToAdd = "New content";   // задаем новый контент для добавления

        // Act & Assert
        CourseNotFoundException exception = assertThrows(CourseNotFoundException.class, () -> {    // проверяем, что при попытке добавления контента к несуществующему курсу
            courseService.addContentToCourse(nonExistingCourseId, contentToAdd);                   // выбрасывается исключение CourseNotFoundException
        });

        assertEquals("Курс с ID " + nonExistingCourseId + " не найден", exception.getMessage());  // проверяем, что сообщение исключения соответствует ожидаемому
    }
}
