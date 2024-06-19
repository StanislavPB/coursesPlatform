package repository;

import dto.question.AnswersRequestUpdate;
import dto.question.CorrectAnswerRequestUpdate;
import dto.question.QuestionRequestCreate;
import dto.question.QuestionResponse;
import dto.question.QuestionTextRequestUpdate;
import entity.Question;
import repository.interfaces.InQuestionRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class QuestionRepository implements InQuestionRepository {
    private Map<Integer, Question> questions = new HashMap<>();
    private Integer currentId = 0;




    @Override
    public QuestionResponse create(QuestionRequestCreate request) {
        int id = currentId++;
        Question question = new Question(id, request.getQuestionText(), request.getAnswers(), request.getCorrectAnswer());
        questions.put(id, question);
        return new QuestionResponse(id, question.getQuestionText(), question.getCorrectAnswer(), question.getCorrectAnswer());
    }

    // find all (aka PrintAll) => список всех вопросов (вся коллекция)
    public List<Question> findAll(){
        return new ArrayList<>(questions.values());
    }

    // find by ID => объект вопрос
    public Optional<Question> findById (Integer questionId){
        return Optional.ofNullable(questions.get(questionId));
    }

    @Override
    public QuestionResponse updateQuestionText(QuestionTextRequestUpdate request) {
        return null;
    }

    @Override
    public QuestionResponse updateAnswers(AnswersRequestUpdate request) {
        return null;
    }

    @Override
    public QuestionResponse updateCorrectAnswer(CorrectAnswerRequestUpdate request) {
        return null;
    }

    // update questionText => DTO result
    public Question updateQuestionText(Integer questionId, String newQuestionText) {
        Question question = questions.get(questionId);
        if (question != null) {
            question.setQuestionText(newQuestionText);
        }
        return question;
    }



    // update Answers => DTO result
    public Question updateAnswers(Integer questionId, Map<Integer, String> newAnswers) {
        Question question = questions.get(questionId);
        if (question != null) {
            question.setAnswers(newAnswers);
        }
        return question;
    }

    // update correctAnswer => DTO result
    public Question updateCorrectAnswer(Integer questionId, Integer newCorrectAnswer) {
        Question question = questions.get(questionId);
        if (question != null) {
            question.setCorrectAnswer(newCorrectAnswer);
        }
        return question;
    }

    // deleteQuestion => boolean
    public boolean deleteQuestion(Integer questionId) {
        return questions.remove(questionId) != null;
    }


}
