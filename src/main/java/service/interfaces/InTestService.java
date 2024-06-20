package service.interfaces;
import entity.Test;
import entity.Question;
import entity.TestResult;
import exception.CourseNotFoundException;
import exception.TestNotFoundException;

import java.util.List;
public interface InTestService {
    Test createTest(String testTitle, int courseId) throws CourseNotFoundException;
    List<Test> getAllTests();
    Test getTestById(int testId) throws TestNotFoundException;
    Test getTestByTitle(String testTitle) throws TestNotFoundException;
    List<Test> getTestsByCourse(int courseId);
    boolean updateTestTitle(int testId, String newTitle);
    boolean updateTestCourse(int testId, int newCourseId);
    boolean updateTestQuestions(int testId, List<Question> questions);
    boolean addQuestionToTest(int testId, Question question) throws TestNotFoundException;
    boolean removeQuestionFromTest(int testId, int questionId) throws TestNotFoundException;
    boolean deleteTest(int testId);
    TestResult startTest(int testId, int studentId, List<Integer> answers);
}
