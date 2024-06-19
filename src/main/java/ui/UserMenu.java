package ui;

import entity.Course;
import service.TestResultService;

public class UserMenu {
    private final CourseService courseService;
    private final QuestionService questionService;
    private final StudentService studentService;
    private final TestService testService;
    private final TestResultService testResultService;

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
            System.out.println("-----------------------------");
            printMenu();
            int userChoice = ui.inputInt("Enter menu number:");

            switch (userChoice){
                case 1:
                    serviceAdd.add();
                    break;
                case 2:
                    serviceFind.printAll();
                    break;
                case 3:
                    serviceFind.printTaskById();
                    break;
                case 4:
                    serviceFind.printTaskByTaskName();
                    break;
                case 5:
                    serviceDelete.deleteById();
                    break;
                case 0:
                    System.out.println("The app has been shut down");
                    return;
            }
        }

    }

}
