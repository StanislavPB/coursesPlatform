package service.interfaces;
import entity.Test;
import entity.Question;
import entity.TestResult;

import java.util.List;
public interface InTestService {
    Test createTest(String testTitle, int courseId);
    List<Test> getAllTests();
    Test getTestById(int testId);
    Test getTestByTitle(String testTitle);
    List<Test> getTestsByCourse(int courseId);
    boolean updateTestTitle(int testId, String newTitle);
    boolean updateTestCourse(int testId, int newCourseId);
    boolean updateTestQuestions(int testId, List<Question> questions);
    boolean addQuestionToTest(int testId, Question question);
    boolean removeQuestionFromTest(int testId, int questionId);
    boolean deleteTest(int testId);
    TestResult startTest(int testId, int studentId, List<Integer> answers);
}
