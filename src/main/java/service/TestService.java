package service;

import dto.test.TestDTO;
import dto.testResult.TestResultRequest;
import dto.testResult.TestResultResponce;
import entity.Course;
import entity.Question;
import entity.Test;
import entity.TestResult;
import repository.TestRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestService {
    private final TestRepository testRepository;
    private final CourseService courseService;
    private final TestResultService testResultService;

    public TestService(TestRepository testRepository, CourseService courseService, TestResultService testResultService) {
        this.testRepository = testRepository;
        this.courseService = courseService;
        this.testResultService = testResultService;
    }

    public TestDTO createTest(String testTitle, int courseId) {
        Optional<Course> courseOptional = courseService.findCourseById(courseId);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            Test test = testRepository.createTest(testTitle, course);
            return toDTO(test);
        }
        return null; // или выбросить исключение
    }


    public List<TestDTO> getAllTests() {
        return testRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public TestDTO getTestById(int testId) {
        return testRepository.findById(testId).map(this::toDTO).orElse(null); // или выбросить исключение
    }

    public TestDTO getTestByTitle(String testTitle) {
        return testRepository.findByTitle(testTitle).map(this::toDTO).orElse(null); // или выбросить исключение
    }

    public List<TestDTO> getTestsByCourse(int courseId) {
        return testRepository.findByCourse(courseId).stream().map(this::toDTO).collect(Collectors.toList());
    }

    public boolean updateTestTitle(int testId, String newTitle) {
        return testRepository.updateTestTitle(testId, newTitle);
    }

    public boolean updateTestCourse(int testId, int newCourseId) {
        Optional<Course> courseOptional = courseService.findCourseById(newCourseId);
        if (courseOptional.isPresent()) {
            Course newCourse = courseOptional.get();
            return testRepository.updateCourse(testId, newCourse);
        }
        return false; // или выбросить исключение
    }

    public boolean updateTestQuestions(int testId, List<QuestionDTO> questionDTOs) {
        List<Question> questions = questionDTOs.stream().map(this::fromDTO).collect(Collectors.toList());
        return testRepository.updateQuestions(testId, questions);
    }

    // Метод для добавления вопроса в коллекцию вопросов теста
    public boolean addQuestionToTest(int testId, QuestionDTO questionDTO) {
        Optional<Test> testOptional = testRepository.findById(testId);
        if (testOptional.isPresent()) {
            Test test = testOptional.get();
            List<Question> questions = test.getQuestions();
            questions.add(fromDTO(questionDTO));
            return testRepository.updateQuestions(testId, questions);
        }
        return false; // или выбросить исключение
    }

    // Метод для удаления вопроса из коллекции вопросов теста
    public boolean removeQuestionFromTest(int testId, int questionId) {
        Optional<Test> testOptional = testRepository.findById(testId);
        if (testOptional.isPresent()) {
            Test test = testOptional.get();
            List<Question> questions = test.getQuestions();
            questions.removeIf(question -> question.getQuestionId() == questionId);
            return testRepository.updateQuestions(testId, questions);
        }
        return false; // или выбросить исключение
    }

    public boolean deleteTest(int testId) {
        return testRepository.deleteTest(testId);
    }

    // Метод для прохождения теста студентом
    public TestResultResponce startTest(int testId, int studentId, List<Integer> answers) {
        Optional<Test> testOptional = testRepository.findById(testId);
        //Нужна еще проверка на наличие такого студента (может быть не тут, а при вызове)
        if (testOptional.isPresent()) {
            Test test = testOptional.get();
            int correctAnswers = 0;
            List<Question> questions = test.getQuestions();
            for (int i = 0; i < questions.size(); i++) {
                if (Objects.equals(questions.get(i).getCorrectAnswer(), answers.get(i))) {
                    correctAnswers++;
                }
            }
            double result = (double) correctAnswers / questions.size() * 100;
            TestResultRequest testResultRequest = new TestResultRequest(testId, studentId, result);
            return testResultService.addNewTestResult(testResultRequest);
        }
        return null; // или выбросить исключение
    }


    // Преобразование из сущности в DTO
    //TestDTO(int testId, String testTitle, int courseId, List<QuestionDTO> questions)
    //   Test(int testId, String testTitle, Course course, List<Question> questions)
    private TestDTO toDTO(Test test) {
        return new TestDTO(
                test.getTestId(),
                test.getTestTitle(),
                test.getCourse().getCourseId(),
                test.getQuestions().stream().map(this::toDTO).collect(Collectors.toList())
        );
    }

    // Преобразование из DTO в сущность
    private QuestionDTO toDTO(Question question) {
        return new QuestionDTO(
                question.getQuestionId(),
                question.getQuestionText(),
                question.getAnswers().stream().map(this::toDTO).collect(Collectors.toList()),
                question.getCorrectAnswerId()
        );
    }

    private Question fromDTO(QuestionDTO questionDTO) {
        return new Question(
                questionDTO.getQuestionId(),
                questionDTO.getQuestionText(),
                questionDTO.getAnswers().stream().map(this::fromDTO).collect(Collectors.toList()),
                questionDTO.getCorrectAnswerId()
        );
    }

    private AnswerDTO toDTO(Answer answer) {
        return new AnswerDTO(
                answer.getAnswerId(),
                answer.getAnswerText()
        );
    }

    private Answer fromDTO(AnswerDTO answerDTO) {
        return new Answer(
                answerDTO.getAnswerId(),
                answerDTO.getAnswerText()
        );
    }
}
