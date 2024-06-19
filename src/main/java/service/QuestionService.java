package service;

import dto.question.AnswersRequestUpdate;
import dto.question.CorrectAnswerRequestUpdate;
import dto.question.QuestionRequestCreate;
import dto.question.QuestionResponse;
import dto.question.QuestionTextRequestUpdate;
import entity.Question;
import repository.interfaces.InQuestionRepository;

import java.util.ArrayList;
import java.util.Optional;

import java.util.List;
import java.util.stream.Collectors;

public class QuestionService implements InQuestionService{
    private InQuestionRepository questionRepository;

    public QuestionService(InQuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    @Override
    public QuestionResponse createQuestion(QuestionRequestCreate request) {
        return questionRepository.create(request);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Optional<QuestionResponse> getQuestionById(int id) {
        return Optional.empty();
    }

    @Override
    public QuestionResponse updateQuestionText(QuestionTextRequestUpdate request) {
        return questionRepository.updateQuestionText(request);
    }

    @Override
    public QuestionResponse updateAnswers(AnswersRequestUpdate request) {
        return questionRepository.updateAnswers(request);
    }

    @Override
    public QuestionResponse updateCorrectAnswer(CorrectAnswerRequestUpdate request) {
        return questionRepository.updateCorrectAnswer(request);
    }

    @Override
    public boolean deleteQuestion(int id) {
        return questionRepository.deleteQuestion(id);
    }

    @Override
    public List<QuestionResponse> searchByKeyword(String keyword) {
        List<Question> allQuestions = questionRepository.findAll();
        List<QuestionResponse> result = new ArrayList<>();

        for (Question question : allQuestions) {
            if (question.getQuestionText().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(toQuestionResponse(question));
            }
        }
        return result;
    }

    private QuestionResponse toQuestionResponse(Question question) {
        return new QuestionResponse(
                question.getQuestionId(),
                question.getQuestionText(),
                question.getAnswers(),
                question.getCorrectAnswer()
        );
    }


}
