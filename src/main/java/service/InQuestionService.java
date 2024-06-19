package service;

import dto.question.AnswersRequestUpdate;
import dto.question.CorrectAnswerRequestUpdate;
import dto.question.QuestionRequestCreate;
import dto.question.QuestionResponse;
import dto.question.QuestionTextRequestUpdate;
import entity.Question;

import java.util.List;
import java.util.Optional;

public interface InQuestionService {
    QuestionResponse createQuestion(QuestionRequestCreate request);
    List<Question> getAllQuestions();
    Optional<QuestionResponse> getQuestionById(int id);
    QuestionResponse updateQuestionText(QuestionTextRequestUpdate request);
    QuestionResponse updateAnswers(AnswersRequestUpdate request);
    QuestionResponse updateCorrectAnswer(CorrectAnswerRequestUpdate request);
    boolean deleteQuestion(int id);
    List<QuestionResponse> searchByKeyword(String keyword);

}
