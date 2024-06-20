package service;


import dto.CourseResponse;
import dto.testResult.TestResultRequest;
import dto.testResult.TestResultResponce;
import entity.Student;
import entity.Test;
import entity.Question;
import entity.TestResult;
import exception.TestNotFoundException;
import repository.StudentRepository;
import repository.TestRepository;
import service.util.TestValidation;
import exception.CourseNotFoundException;
import service.interfaces.InTestService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class TestService implements InTestService {
    private final TestRepository testRepository;
    private final CourseService courseService;
    private StudentService studentService;
    private final QuestionService questionService;
    private final TestResultService testResultService;
    private final TestValidation validation;

    public TestService(TestRepository testRepository, CourseService courseService, StudentService studentService, QuestionService questionService, TestResultService testResultService, TestValidation validation) {
        this.testRepository = testRepository;
        this.courseService = courseService;
        this.studentService = studentService;
        this.questionService = questionService;
        this.testResultService = testResultService;
        this.validation = validation;
    }

    //public Test(int testId, String testTitle, int courseId, List<Question> questions)
    //public Test(int testId, String testTitle, Course course, List<Question> questions)
    @Override
    public Test createTest(String testTitle, int courseId) throws CourseNotFoundException {
        List<String> errors = validation.validateTestData(testTitle, courseId);
        if (!errors.isEmpty()) {
            throw new IllegalArgumentException("Invalid test data: " + errors);
        }
//CourseResponse(String courseTitle, String courseDescription, List<String> courseContent)
        CourseResponse courseResponse = courseService.getCourseById(courseId);

        return testRepository.createTest(courseResponse.getCourseTitle(), courseId);
    }

    @Override
    public List<Test> getAllTests() {
        return testRepository.findAll();
    }

    @Override
    public Test getTestById(int testId) throws TestNotFoundException {
        return testRepository.findById(testId).orElseThrow(() -> new TestNotFoundException("Test with ID " + testId + " not found"));
    }

    @Override
    public Test getTestByTitle(String testTitle) throws TestNotFoundException {
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
//        Test testForUpdate = getTestById(testId);1

        return false;
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
    public boolean addQuestionToTest(int testId, Question question) throws TestNotFoundException {
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
    public boolean removeQuestionFromTest(int testId, int questionId) throws TestNotFoundException {
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

    @Override
    public TestResult startTest(int testId, int studentId, List<Integer> answers) {
        return null;
    }

    // Метод для прохождения теста студентом
    //TestResultResponce(int testId, List<String> errors)
//    public TestResultResponce startTest(int testId, int studentId, List<Integer> answers) {
//        Optional<Test> testOptional = testRepository.findById(testId);
//        Optional<Student> findedStudent = studentService.getStudentById(studentId);
//        if (findedStudent.isPresent()) {
//            if (testOptional.isPresent()) {
//                Test test = testOptional.get();
//                int correctAnswers = 0;
//                List<Question> questions = test.getQuestions();
//                for (int i = 0; i < questions.size(); i++) {
//
//                    if (Objects.equals(questions.get(i).getCorrectAnswer(), answers.get(i))) {
//
//                        correctAnswers++;
//                    }
//                }
//                double result = (double) correctAnswers / questions.size() * 100;
//                TestResultRequest testResultRequest = new TestResultRequest(testId, studentId, result);
//                return testResultService.addNewTestResult(testResultRequest);
//            }
//        }
//        return null; // или выбросить исключение
//    }


    // Преобразование из сущности в DTO
    //TestDTO(int testId, String testTitle, int courseId, List<QuestionDTO> questions)
    //   Test(int testId, String testTitle, Course course, List<Question> questions)
//    private TestDTO toDTO(Test test) {
//        return new TestDTO(
//                test.getTestId(),
//                test.getTestTitle(),
//                test.getCourse().getCourseId(),
//                test.getQuestions().stream().map(this::toDTO).collect(Collectors.toList())
//        );
//    }
//
//    // Преобразование из DTO в сущность
//    private QuestionDTO toDTO(Question question) {
//        return new QuestionDTO(
//                question.getQuestionId(),
//                question.getQuestionText(),
//                question.getAnswers().stream().map(this::toDTO).collect(Collectors.toList()),
//                question.getCorrectAnswerId()
//        );
//    }
//
//    private Question fromDTO(QuestionDTO questionDTO) {
//        return new Question(
//                questionDTO.getQuestionId(),
//                questionDTO.getQuestionText(),
//                questionDTO.getAnswers().stream().map(this::fromDTO).collect(Collectors.toList()),
//                questionDTO.getCorrectAnswerId()
//        );
//    }
//
//    private AnswerDTO toDTO(Answer answer) {
//        return new AnswerDTO(
//                answer.getAnswerId(),
//                answer.getAnswerText()
//        );
//    }
//
//    private Answer fromDTO(AnswerDTO answerDTO) {
//        return new Answer(
//                answerDTO.getAnswerId(),
//                answerDTO.getAnswerText()
//        );
//    }
}
