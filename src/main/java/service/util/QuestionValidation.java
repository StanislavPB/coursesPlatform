package service.util;

import dto.question.AnswersRequestUpdate;
import dto.question.CorrectAnswerRequestUpdate;
import dto.question.QuestionRequestCreate;
import dto.question.QuestionTextRequestUpdate;

import java.util.Map;

public class QuestionValidation {

//    QuestionRequestCreate:
//    questionText не должен быть пустым.
//    answers не должен быть пустым и должен содержать не менее двух ответов.
//    correctAnswer должен быть
    public static boolean validateCreateQuestionRequest(QuestionRequestCreate request) {
        if (request.getQuestionText() == null || request.getQuestionText().trim().isEmpty()) {
            System.out.println("Question text must not be empty.");
            return false;
        }
        if (request.getAnswers() == null || request.getAnswers().isEmpty() || request.getAnswers().size() < 2) {
            System.out.println("There must be at least two answers.");
            return false;
        }
        if (!request.getAnswers().containsKey(request.getCorrectAnswer())) {
            System.out.println("Correct answer must be a valid answer ID.");
            return false;
        }
        return true;
    }
    public static boolean validateUpdateQuestionTextRequest(QuestionTextRequestUpdate request) {

//        QuestionTextRequestUpdate:
//        questionText не должен быть пустым.
        if (request.getQuestionText() == null || request.getQuestionText().trim().isEmpty()) {
            System.out.println("Question text must not be empty.");
            return false;
        }
        return true;
    }


//    UpdateAnswersRequest:
//    answers не должен быть пустым и должен содержать не менее двух ответов.
    public static boolean validateUpdateAnswersRequest(AnswersRequestUpdate request) {
        if (request.getAnswers() == null || request.getAnswers().isEmpty() || request.getAnswers().size() < 2) {
            System.out.println("There must be at least two answers.");
            return false;
        }
        return true;
    }

//    UpdateCorrectAnswerRequest:
//    correctAnswer должен быть допустимым ключом в answers.
    public static boolean validateUpdateCorrectAnswerRequest(CorrectAnswerRequestUpdate request, Map<Integer, String> existingAnswers) {
        if (!existingAnswers.containsKey(request.getCorrectAnswer())) {
            System.out.println("Correct answer must be a valid answer ID.");
            return false;
        }
        return true;
    }
}
