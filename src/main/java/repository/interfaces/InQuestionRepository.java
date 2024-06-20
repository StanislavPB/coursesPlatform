package repository.interfaces;

import dto.question.AnswersRequestUpdate;
import dto.question.CorrectAnswerRequestUpdate;
import dto.question.QuestionRequestCreate;
import dto.question.QuestionResponse;
import dto.question.QuestionTextRequestUpdate;
import entity.Question;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface InQuestionRepository {
    //Create
    Question create(String questionText, Map<Integer, String> answers, Integer correctAnswer);

    public QuestionResponse create(QuestionRequestCreate request);

    public List<Question> findAll();

    public List<QuestionResponse> searchByKeyword(String keyword);

    public QuestionResponse updateQuestionText(QuestionTextRequestUpdate request);

    public QuestionResponse updateAnswers(AnswersRequestUpdate request);

    public QuestionResponse updateCorrectAnswer(CorrectAnswerRequestUpdate request);

    // update questionText => DTO result
    Question updateQuestionText(Integer questionId, String newQuestionText);

    // update Answers => DTO result
    Question updateAnswers(Integer questionId, Map<Integer, String> newAnswers);

    // update correctAnswer => DTO result
    Question updateCorrectAnswer(Integer questionId, Integer newCorrectAnswer);

    public boolean deleteQuestion(Integer questionId);

    Optional<QuestionResponse> findById(Integer id);
}
