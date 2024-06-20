package repository;

import entity.Test;
import entity.Question;
import entity.Course;
import repository.interfaces.InTestRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestRepository {
    private List<Test> tests;

    public TestRepository() {
        this.tests = new ArrayList<>();
    }

//    @Override
    public Test createTest(String testTitle, int courseId) {
        int testId = generateUniqueId();
        Test test = new Test(testId, testTitle, courseId, new ArrayList<>());
        tests.add(test);
        return test;
    }

//    @Override
    public List<Test> findAll() {
        return tests;
    }

//    @Override
    public Optional<Test> findById(int testId) {
        return tests.stream().filter(test -> test.getTestId() == testId).findFirst();
    }

//    @Override
    public Optional<Test> findByTitle(String testTitle) {
        return tests.stream().filter(test -> test.getTestTitle().equalsIgnoreCase(testTitle)).findFirst();
    }

//    @Override
    public List<Test> findByCourse(int courseId) {
        return tests.stream().filter(test -> test.getCourseId() == courseId).collect(Collectors.toList());
    }

//    @Override
    public boolean updateTestTitle(int testId, String newTitle) {
        Optional<Test> testOptional = findById(testId);
        if (testOptional.isPresent()) {
            Test test = testOptional.get();
            test.setTestTitle(newTitle);
            return true;
        }
        return false;
    }

//    @Override
    public boolean updateCourse(int testId, int courseId) {
        Optional<Test> testOptional = findById(testId);
        if (testOptional.isPresent()) {
            Test test = testOptional.get();
            test.setCourseId(courseId);
            return true;
        }
        return false;
    }

//    @Override
    public boolean updateQuestions(int testId, List<Question> questions) {
        Optional<Test> testOptional = findById(testId);
        if (testOptional.isPresent()) {
            Test test = testOptional.get();
            test.setQuestions(questions);
            return true;
        }
        return false;
    }

//    @Override
    public boolean deleteTest(int testId) {
        return tests.removeIf(test -> test.getTestId() == testId);
    }

    private int generateUniqueId() {
        return tests.size() + 1;
    }
}