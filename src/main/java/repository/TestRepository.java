package repository;

import entities.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestRepository {
    private List<Test> tests = new ArrayList<>();
    private int currentId = 1;

    // CREATE: создание нового теста
    public Test createTest(String testTitle, Course course) {
        Test test = new Test();
        test.setTestId(currentId++);
        test.setTestTitle(testTitle);
        test.setCourse(course);
        test.setQuestions(new ArrayList<>());
        tests.add(test);
        return test;
    }

    // findAll: список всех тестов
    public List<Test> findAll() {
        return new ArrayList<>(tests);
    }

    // findById: поиск теста по ID
    public Optional<Test> findById(int testId) {
        return tests.stream().filter(test -> test.getTestId() == testId).findFirst();
    }

    // findByTitle: поиск теста по названию
    public Optional<Test> findByTitle(String testTitle) {
        return tests.stream().filter(test -> test.getTestTitle().equals(testTitle)).findFirst();
    }

    // findByCourse: поиск тестов по курсу
    public List<Test> findByCourse(int courseId) {
        return tests.stream().filter(test -> test.getCourse().getCourseId() == courseId).collect(Collectors.toList());
    }

    // updateTestTitle: обновление названия теста
    public boolean updateTestTitle(int testId, String newTitle) {
        Optional<Test> testOptional = findById(testId);
        if (testOptional.isPresent()) {
            Test test = testOptional.get();
            test.setTestTitle(newTitle);
            return true;
        }
        return false;
    }

    // updateCourse: обновление курса теста
    public boolean updateCourse(int testId, Course newCourse) {
        Optional<Test> testOptional = findById(testId);
        if (testOptional.isPresent()) {
            Test test = testOptional.get();
            test.setCourse(newCourse);
            return true;
        }
        return false;
    }

    // updateQuestions: обновление вопросов теста
    public boolean updateQuestions(int testId, List<Question> newQuestions) {
        Optional<Test> testOptional = findById(testId);
        if (testOptional.isPresent()) {
            Test test = testOptional.get();
            test.setQuestions(newQuestions);
            return true;
        }
        return false;
    }

    // deleteTest: удаление теста
    public boolean deleteTest(int testId) {
        return tests.removeIf(test -> test.getTestId() == testId);
    }
}