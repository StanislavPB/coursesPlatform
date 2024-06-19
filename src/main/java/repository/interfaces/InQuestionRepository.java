package repository.interfaces;

import dto.question.AnswersRequestUpdate;
import dto.question.CorrectAnswerRequestUpdate;
import dto.question.QuestionRequestCreate;
import dto.question.QuestionResponse;
import dto.question.QuestionTextRequestUpdate;
import entity.Question;

import java.util.List;
import java.util.Optional;

public interface InQuestionRepository {
    public QuestionResponse create(QuestionRequestCreate request);

    public List<Question> findAll();

    public Optional<Question> findById (Integer questionId);

    public QuestionResponse updateQuestionText(QuestionTextRequestUpdate request);

    public QuestionResponse updateAnswers(AnswersRequestUpdate request);

    public QuestionResponse updateCorrectAnswer(CorrectAnswerRequestUpdate request);

    public boolean deleteQuestion(Integer questionId);

}
