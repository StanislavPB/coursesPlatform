package ui;

import dto.CourseRequest;
import dto.question.QuestionRequestCreate;
import dto.question.QuestionResponse;
import dto.testResult.TestResultRequest;
import entity.Course;
import entity.Question;
import entity.Student;
import exception.CourseCreationException;
import exception.CourseNotFoundException;
import service.CourseService;
import service.QuestionService;
import service.StudentService;
import service.TestResultService;
import service.util.UserInput;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMenu {
    private final CourseService courseService;
    private final QuestionService questionService;
    private final StudentService studentService;
    private final TestService testService;
    private final TestResultService testResultService;
    private final UserInput ui = new UserInput();

    public UserMenu(CourseService courseService, QuestionService questionService, StudentService studentService, TestService testService, TestResultService testResultService) {
        this.courseService = courseService;
        this.questionService = questionService;
        this.studentService = studentService;
        this.testService = testService;
        this.testResultService = testResultService;
    }
    private void printMenu(){
        System.out.println("=============== MENU ===============");
        System.out.println("=== COURSE ===");
        System.out.println("1. Create new Course");
        System.out.println("2. Print Course content");
        System.out.println("3. Print Students from Course");
        System.out.println("4. Print all Courses");
        System.out.println("5. Edit Course content (FAKE TEMPLATE)");
        System.out.println("6. Add Student to the Course");
        System.out.println("7. Remove Student from the Course");
        System.out.println("=== STUDENT ===");
        System.out.println("8. Create new Student");
        System.out.println("9. Print all Students");
        System.out.println("=== TEST ===");
        System.out.println("10. Create new Test");
        System.out.println("11. Assign Course to the Test");
        System.out.println("12. Add Questions collection to the Test");
        System.out.println("13. Edit Questions collection (FAKE TEMPLATE)");
        System.out.println("14. Start Test");
        System.out.println("15. Print all Tests");
        System.out.println("=== QUESTION ===");
        System.out.println("16. Create new Question");
        System.out.println("17. Edit Question (FAKE TEMPLATE)");
        System.out.println("18. Print all Questions");
        System.out.println("19. Find Questions by text search (FAKE TEMPLATE)");
        System.out.println("=== TEST RESULTS ===");
        System.out.println("20. Print all Test Results");
        System.out.println("21. Print all Test Results statistics");
        System.out.println("22. Print Test Results statistics of Student");
        System.out.println("23. Print Test Results statistics of Test");
        System.out.println("0. Exit");

    }
    public void menu() throws CourseCreationException, InterruptedException, CourseNotFoundException {
        while (true){
            printMenu();
            int userChoice = ui.inputInt("Enter menu number:");

            switch (userChoice){
                case 1:
                //1. Create new Course
                    //CourseResponse createCourse(CourseRequest courseRequest)
                        //CourseResponse(String courseTitle, String courseDescription, List<String> courseContent)
                        //CourseRequest(String courseTitle, String courseDescription)
                    System.out.println("====== Create new Course ======");
                    String courseTitle = ui.inputText("Enter the course title:");
                    String courseDescription = ui.inputText("Enter the course description:");
                    CourseRequest request = new CourseRequest(courseTitle, courseDescription);
                    courseService.createCourse(request);

                    break;
                case 2:
                //2. Print Course content

                    System.out.println("====== Print Course content ======");
                    Integer courseId = ui.inputInt("Enter course ID:");
                    courseService.printCourseContent(courseId);

                    break;

                case 3:
                //3. Print Students from Course
                    System.out.println("====== Print Students from Course ======");

                    Integer courseIdForStudentSearch = ui.inputInt("Enter course ID:");
                    courseService.printCourseStudents(courseIdForStudentSearch);

                    break;

                case 4:
                //4. Print all Courses
                    //List<CourseResponse> getAllCourses()
                    //Использую как есть - с непричесанным выводом на экран внутри метода
                    System.out.println("====== Print all Courses ======");

                    courseService.getAllCourses();

                    break;
                case 5:
                //5. Edit Course content (FAKE TEMPLATE)
                    //updateCourseContent(Integer courseId, CourseRequest updatedCourse)
                    //CourseRequest(String courseTitle, String courseDescription)
                    System.out.println("====== Edit Course content ======");

                    Integer courseIdForUpdateContent = ui.inputInt("Enter course ID:");
                    String courseTitleForEdit = ui.inputText("Enter the course title:");
                    String courseDescriptionForEdit = ui.inputText("Enter the course description:");

                    CourseRequest updatedCourse = new CourseRequest(courseTitleForEdit, courseDescriptionForEdit);

                    courseService.updateCourseContent(courseIdForUpdateContent, updatedCourse);

                    break;
                case 6:
                //6. Add Student to the Course
                    //addStudentToCourse(Integer courseId, Student student)
                    //Optional<Student> getStudentById

                    System.out.println("====== Add Student to the Course ======");

                    Integer courseIdForStudentAdd = ui.inputInt("Enter student ID:");
                    Student studentForAddToCourse;
                    if(studentService.getStudentById(courseIdForStudentAdd).isPresent()){
                        studentForAddToCourse = studentService.getStudentById(courseIdForStudentAdd).get();
                    } else {
                        String studentName = ui.inputText("Enter student's name:");
                        String email = ui.inputText("Enter student's email:");
                        studentForAddToCourse = studentService.createStudent(studentName, email);
                    }
                    courseService.addStudentToCourse(courseIdForStudentAdd, studentForAddToCourse);

                    break;

                case 7:
                //7. Remove Student from the Course
                    System.out.println("====== Remove Student from the Course ======");
                    Thread.sleep(3000);
                    break;
                case 8:
                //8. Create new Student

                    System.out.println("====== Create new Student ======");

                    String studentName = ui.inputText("Enter student's name:");
                    String email = ui.inputText("Enter student's email:");
                    Student newStudent = studentService.createStudent(studentName, email);

                    break;
                case 9:
                //9. Print all Students
                    //List<Student> getAllStudents()
                    System.out.println("====== Print all Students ======");
                    List<Student> allStudentsList = studentService.getAllStudents();

                    for (Student student : allStudentsList){
                        System.out.println(student.getStudentId() + " " + student.getName() + " " + student.getEmail());
                    }

                    break;

                case 10:
                //10. Create new Test
                    System.out.println("====== Create new Test ======");
                    Thread.sleep(3000);
                    break;
                case 11:
                //11. Assign Course to the Test
                    System.out.println("====== Assign Course to the Test ======");
                    Thread.sleep(3000);
                    break;
                case 12:
                //12. Add Questions collection to the Test
                    System.out.println("====== Add Questions collection to the Test ======");
                    Thread.sleep(3000);
                    break;
                case 13:
                //13. Edit Questions collection (FAKE TEMPLATE)
                    System.out.println("====== Edit Questions collection ======");
                    Thread.sleep(3000);
                    break;
                case 14:
                //14. Start Test
                    //TestResultResponce addNewTestResult(TestResultRequest testResultRequest)
                    //TestResultRequest(int testId, int studentId, double result)
                    //TestResultResponce(int testId, List<String> errors)
                    System.out.println("====== Start Test ======");
                    int fakeTestId = (int) Math.random() * 3000;
                    int fakeStudentId = (int) Math.random() * 3000;
                    double fakeTestResult = Math.random() * 0.7 + 0.3; // рандомный результат от 30% до 100%

                    TestResultRequest resultRequest = new TestResultRequest(fakeTestId, fakeStudentId, fakeTestResult);

                    if (testResultService.addNewTestResult(resultRequest).getErrors().isEmpty()) {
                        System.out.println("Student with ID " + fakeStudentId + " has passed the Test with ID " + fakeTestId + " with result " + fakeTestResult);
                    }

                    break;
                case 15:
                //15. Print all Tests
                    System.out.println("====== Print all Tests ======");
                    Thread.sleep(3000);
                    break;
                case 16:
                //16. Create new Question
                    //QuestionResponse createQuestion(QuestionRequestCreate request)
                    //QuestionResponse(Integer questionId, String questionText, Map<Integer, String> answers, Integer correctAnswer)
                    //QuestionRequestCreate(String questionText, Map<Integer, String> answers, Integer correctAnswer)
                    System.out.println("====== Create new Question ======");

                    String questionText = ui.inputText("Enter the question:");
                    Map<Integer, String> answers = new HashMap<>();
                    Integer correctAnswer = ui.inputInt("Enter a number of the correct answer:");
                    QuestionRequestCreate questionRequest = new QuestionRequestCreate(questionText, answers, correctAnswer);

                    questionService.createQuestion(questionRequest);

                    System.out.println("Question with ID " + questionService.createQuestion(questionRequest).getQuestionId() + " has been created");

                    break;

                case 17:
                //17. Edit Question (FAKE TEMPLATE)
                    System.out.println("====== Edit Question ======");
                    Thread.sleep(3000);
                    break;
                case 18:
                //18. Print all Questions
                    //List<Question> getAllQuestions()
                    //Question(Integer questionId, String questionText, Map<Integer, String> questions, Integer correctAnswer)
                    System.out.println("====== Print all Questions ======");

                    List<Question> allQuestions = questionService.getAllQuestions();

                    for (Question question : allQuestions){
                        System.out.println(question.getQuestionId() + " " + question.getQuestionText());
                    }

                    break;
                case 19:
                //19. Find Questions by text search (FAKE TEMPLATE)
                    //List<QuestionResponse> searchByKeyword(String keyword);
                    //QuestionResponse(Integer questionId, String questionText, Map<Integer, String> answers, Integer correctAnswer)

                    System.out.println("====== Find Questions by text search ======");

                    String textQuery = ui.inputText("Enter text, you want to find among questions");
                    List<QuestionResponse> responseList = questionService.searchByKeyword(textQuery);
                    if (!responseList.isEmpty()){
                        for (QuestionResponse response : responseList){
                            System.out.println(response.getQuestionId() + " " + response.getQuestionText());
                        }
                    } else {
                        System.out.println("No questions with text \"" + textQuery + "\" have been found");
                    }
                    break;

                case 20:
                //20. Print all Test Results
                    System.out.println("====== Print all Test Results ======");
                    testResultService.printAllTestResults();
                    break;

                case 21:
                //21. Print all Test Results statistics
                    System.out.println("====== Print all Test Results statistics ======");
                    testResultService.printAllTestResultStatistic();
                    break;

                case 22:
                //22. Print Test Results statistics of Student
                    System.out.println("====== Print Test Results statistics of Student ======");
                    int studentId = ui.inputInt("Enter student ID for printing his Test Results statistics:");
                    testResultService.printTestResultStatisticByStudentId(studentId);
                    break;

                case 23:
                //23. Print Test Results statistics of Test
                    System.out.println("====== Print Test Results statistics of Test ======");
                    int testtId = ui.inputInt("Enter test ID for printing Results statistics:");
                    testResultService.printTestResultStatisticByTestId(testtId);
                    break;

                case 0:
                    System.out.println("The app has been shut down");
                    return;
            }
        }

    }

}
