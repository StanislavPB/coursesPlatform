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

    //Create
    @Override
    public Question create(String questionText, Map<Integer, String> answers, Integer correctAnswer){
        int id = currentId++;
        Question question = new Question(id, questionText, answers, correctAnswer);
        questions.put(id, question);
        return question;
    }

    @Override
    public QuestionResponse create(QuestionRequestCreate request) {
        return null;
    }

    // find all (aka PrintAll) => список всех вопросов (вся коллекция)
    @Override
    public List<Question> findAll(){
        return new ArrayList<>(questions.values());
    }




    // find by Keyword

    private QuestionResponse toQuestionResponse(Question question) {
        return new QuestionResponse(
                question.getQuestionId(),
                question.getQuestionText(),
                question.getAnswers(),
                question.getCorrectAnswer()
        );
    }
    @Override
    public List<QuestionResponse> searchByKeyword(String keyword) {
        List<QuestionResponse> results = new ArrayList<>();
        for (Question question : questions.values()) {
            if (question.getQuestionText().contains(keyword)) {
                results.add(toQuestionResponse(question));
            }
        }
        return results;
    }
//
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
    @Override
    public Question updateQuestionText(Integer questionId, String newQuestionText) {
        Question question = questions.get(questionId);
        if (question != null) {
            question.setQuestionText(newQuestionText);
        }
        return question;
    }



    // update Answers => DTO result
    @Override
    public Question updateAnswers(Integer questionId, Map<Integer, String> newAnswers) {
        Question question = questions.get(questionId);
        if (question != null) {
            question.setAnswers(newAnswers);
        }
        return question;
    }

    // update correctAnswer => DTO result
    @Override
    public Question updateCorrectAnswer(Integer questionId, Integer newCorrectAnswer) {
        Question question = questions.get(questionId);
        if (question != null) {
            question.setCorrectAnswer(newCorrectAnswer);
        }
        return question;
    }

    // deleteQuestion => boolean
    @Override
    public boolean deleteQuestion(Integer questionId) {
        return questions.remove(questionId) != null;
    }

    @Override
    public Optional<QuestionResponse> findById(Integer id) {
        return Optional.ofNullable(questions.get(id)).map(this::toQuestionResponse);
    }


}
