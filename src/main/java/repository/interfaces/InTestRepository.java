package repository.interfaces;
import entity.Test;
import entity.Question;
import entity.Course;

import java.util.List;
import java.util.Optional;

public interface InTestRepository {
//    Test createTest(String testTitle, Course course);

    Test createTest(String testTitle, int courseId);

    List<Test> findAll();
    Optional<Test> findById(int testId);
    Optional<Test> findByTitle(String testTitle);
    List<Test> findByCourse(int courseId);
    boolean updateTestTitle(int testId, String newTitle);
    boolean updateCourse(int testId, Course newCourse);
    boolean updateQuestions(int testId, List<Question> questions);
    boolean deleteTest(int testId);
}
