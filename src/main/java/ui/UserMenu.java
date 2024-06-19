package ui;

import entity.Course;
import service.TestResultService;
import service.util.UserInput;

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
    public void menu(){
        while (true){
            printMenu();
            int userChoice = ui.inputInt("Enter menu number:");

            switch (userChoice){
                case 1:
                //1. Create new Course
                    break;
                case 2:
                //2. Print Course content
                    break;
                case 3:
                //3. Print Students from Course
                    break;
                case 4:
                //4. Print all Courses
                    break;
                case 5:
                //5. Edit Course content (FAKE TEMPLATE)
                    break;
                case 6:
                //6. Add Student to the Course
                    break;
                case 7:
                //7. Remove Student from the Course
                    break;
                case 8:
                //8. Create new Student
                    break;
                case 9:
                //9. Print all Students
                    break;
                case 10:
                //10. Create new Test
                    break;
                case 11:
                //11. Assign Course to the Test
                    break;
                case 12:
                //12. Add Questions collection to the Test
                    break;
                case 13:
                //13. Edit Questions collection (FAKE TEMPLATE)
                    break;
                case 14:
                //14. Start Test
                    break;
                case 15:
                //15. Print all Tests
                    break;
                case 16:
                //16. Create new Question
                    break;
                case 17:
                //17. Edit Question (FAKE TEMPLATE)
                    break;
                case 18:
                //18. Print all Questions

                    break;
                case 19:
                //19. Find Questions by text search (FAKE TEMPLATE)
                    break;
                case 20:
                //20. Print all Test Results
                    break;
                case 21:
                //21. Print all Test Results statistics
                    break;
                case 22:
                //22. Print Test Results statistics of Student
                    break;
                case 23:
                //23. Print Test Results statistics of Test
                    break;
                case 0:
                    System.out.println("The app has been shut down");
                    return;
            }
        }

    }

}
