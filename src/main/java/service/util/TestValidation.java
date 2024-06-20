package service.util;
import entity.Question;

import java.util.ArrayList;
import java.util.List;

public class TestValidation {
    // Валидация данных для теста
    public List<String> validateTestData(String testTitle, int courseId) {
        List<String> errors = new ArrayList<>();

        if (testTitle == null || testTitle.trim().isEmpty()) {
            errors.add("Test title cannot be empty");
        }

        if (courseId <= 0) {
            errors.add("Course ID must be a positive integer");
        }

        return errors;
    }

    // Валидация данных для вопроса
    public List<String> validateQuestionData(Question question) {
        List<String> errors = new ArrayList<>();

        if (question.getQuestionText() == null || question.getQuestionText().trim().isEmpty()) {
            errors.add("Question text cannot be empty");
        }

        if (question.getAnswers() == null || question.getAnswers().isEmpty()) {
            errors.add("Answers cannot be empty");
        }

        if (question.getCorrectAnswer() == null || !question.getAnswers().containsKey(question.getCorrectAnswer())) {
            errors.add("Correct answer must be one of the provided answers");
        }

        return errors;
    }
}
