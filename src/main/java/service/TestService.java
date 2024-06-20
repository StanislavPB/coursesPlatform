package service;

import dto.testResult.TestResultRequest;
import entity.Test;
import entity.Course;
import entity.Question;
import entity.TestResult;
import exception.TestNotFoundException;
import repository.interfaces.InTestRepository;
import service.util.TestValidation;
import exception.CourseNotFoundException;
import service.interfaces.InTestService;

import java.util.List;
import java.util.Optional;

public class TestService implements InTestService {
    private final InTestRepository testRepository;
    private final CourseService courseService;
    private final QuestionService questionService;
    private final TestResultService testResultService;
    private final TestValidation validation;

    public TestService(InTestRepository testRepository, CourseService courseService, QuestionService questionService, TestResultService testResultService, TestValidation validation) {
        this.testRepository = testRepository;
        this.courseService = courseService;
        this.questionService = questionService;
        this.testResultService = testResultService;
        this.validation = validation;
    }

    @Override
    public Test createTest(String testTitle, int courseId) {
        List<String> errors = validation.validateTestData(testTitle, courseId);
        if (!errors.isEmpty()) {
            throw new IllegalArgumentException("Invalid test data: " + errors);
        }

        Optional<Course> courseOptional = courseService.getCourseById(courseId);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            return testRepository.createTest(testTitle, course);
        }
        throw new CourseNotFoundException("Course with ID " + courseId + " not found");
    }

    @Override
    public List<Test> getAllTests() {
        return testRepository.findAll();
    }

    @Override
    public Test getTestById(int testId) {
        return testRepository.findById(testId).orElseThrow(() -> new TestNotFoundException("Test with ID " + testId + " not found"));
    }

    @Override
    public Test getTestByTitle(String testTitle) {
        return testRepository.findByTitle(testTitle).orElseThrow(() -> new TestNotFoundException("Test with title " + testTitle + " not found"));
    }

    @Override
    public List<Test> getTestsByCourse(int courseId) {
        return testRepository.findByCourse(courseId);
    }

    @Override
    public boolean updateTestTitle(int testId, String newTitle) {
        if (newTitle == null || newTitle.trim().isEmpty()) {
            throw new IllegalArgumentException("Test title cannot be empty");
        }
        return testRepository.updateTestTitle(testId, newTitle);
    }

    @Override
    public boolean updateTestCourse(int testId, int newCourseId) {
        Optional<Course> courseOptional = courseService.getCourseById(newCourseId);
        if (courseOptional.isPresent()) {
            Course newCourse = courseOptional.get();
            return testRepository.updateCourse(testId, newCourse);
        }
        throw new CourseNotFoundException("Course with ID " + newCourseId + " not found");
    }

    @Override
    public boolean updateTestQuestions(int testId, List<Question> questions) {
        for (Question question : questions) {
            List<String> errors = validation.validateQuestionData(question);
            if (!errors.isEmpty()) {
                throw new IllegalArgumentException("Invalid question data: " + errors);
            }
        }
        return testRepository.updateQuestions(testId, questions);
    }

    @Override
    public boolean addQuestionToTest(int testId, Question question) {
        List<String> errors = validation.validateQuestionData(question);
        if (!errors.isEmpty()) {
            throw new IllegalArgumentException("Invalid question data: " + errors);
        }
        Optional<Test> testOptional = testRepository.findById(testId);
        if (testOptional.isPresent()) {
            Test test = testOptional.get();
            List<Question> questions = test.getQuestions();
            questions.add(question);
            return testRepository.updateQuestions(testId, questions);
        }
        throw new TestNotFoundException("Test with ID " + testId + " not found");
    }

    @Override
    public boolean removeQuestionFromTest(int testId, int questionId) {
        Optional<Test> testOptional = testRepository.findById(testId);
        if (testOptional.isPresent()) {
            Test test = testOptional.get();
            List<Question> questions = test.getQuestions();
            questions.removeIf(question -> question.getQuestionId() == questionId);
            return testRepository.updateQuestions(testId, questions);
        }
        throw new TestNotFoundException("Test with ID " + testId + " not found");
    }

    @Override
    public boolean deleteTest(int testId) {
        return testRepository.deleteTest(testId);
    }

    // Метод для прохождения теста студентом
    public TestResult startTest(int testId, int studentId, List<Integer> answers) {
        Optional<Test> testOptional = testRepository.findById(testId);
        if (testOptional.isPresent()) {
            Test test = testOptional.get();
            int correctAnswers = 0;
            List<Question> questions = test.getQuestions();
            for (int i = 0; i < questions.size(); i++) {
                if (questions.get(i).getCorrectAnswer() == answers.get(i)) {
                    correctAnswers++;
                }
            }
            double result = (double) correctAnswers / questions.size() * 100;
            return new TestResult(testId, studentId, result);
        }
        return null; // или выбросить исключение
    }
}