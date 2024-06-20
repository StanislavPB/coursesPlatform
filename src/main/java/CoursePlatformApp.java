import exception.CourseCreationException;
import exception.CourseNotFoundException;
import repository.*;
import repository.interfaces.InQuestionRepository;
import repository.interfaces.InTestRepository;
import repository.interfaces.InterfaceCourseRepository;
import service.*;
import service.util.TestValidation;
import service.util.Validation;
import ui.UserMenu;

public class CoursePlatformApp {
    public static void main(String[] args) throws CourseCreationException, CourseNotFoundException, InterruptedException {


        InterfaceCourseRepository courseRepository = new CourseRepository();
        CourseService courseService = new CourseService(courseRepository);

        InQuestionRepository questionRepository = new QuestionRepository();
        QuestionService questionService = new QuestionService(questionRepository);

        StudentService studentService = new StudentService();

        TestRepository testRepository = new TestRepository();

        TestResultRepository testResultRepository = new TestResultRepository();
        StudentRepository studentRepository = new StudentRepository();
        Validation validation = new Validation();
        TestValidation testValidation = new TestValidation();


        TestResultService testResultService = new TestResultService(testResultRepository, testRepository, studentRepository, validation);
        TestService testService = new TestService(testRepository, courseService, studentService, questionService, testResultService,testValidation);

        UserMenu menu = new UserMenu(courseService, questionService, studentService, testService, testResultService);

        menu.menu();

    }
}
