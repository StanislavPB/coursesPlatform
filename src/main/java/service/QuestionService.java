package service;

import dto.question.AnswersRequestUpdate;
import dto.question.CorrectAnswerRequestUpdate;
import dto.question.QuestionRequestCreate;
import dto.question.QuestionResponse;
import dto.question.QuestionTextRequestUpdate;
import entity.Question;
import repository.interfaces.InQuestionRepository;
import service.util.QuestionValidation;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class QuestionService implements InQuestionService{
    private InQuestionRepository questionRepository;

    public QuestionService(InQuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    @Override
    public QuestionResponse createQuestion(QuestionRequestCreate request) {
        if (!QuestionValidation.validateCreateQuestionRequest(request)) {
            return null;
        }
        Question question = questionRepository.create(request);
        return toQuestionResponse(question);
    }

//    @Override
//    public List<QuestionResponse> getAllQuestions() {
//        return null;
//    }

    @Override
    public List<QuestionResponse> getAllQuestions() {
        List<QuestionResponse> responses = new ArrayList<>();
        for (Question question : questionRepository.findAll()) {
            responses.add(toQuestionResponse(question));
        }
        return responses;
    }

    @Override
    public Optional<QuestionResponse> getQuestionById(int id) {
        Optional<QuestionResponse> question = questionRepository.findById(id);
        return question.map((Function<? super QuestionResponse, ? extends QuestionResponse>) this::toQuestionResponse);
    }


    @Override
    public QuestionResponse updateQuestionText(QuestionTextRequestUpdate request) {
        if (!QuestionValidation.validateUpdateQuestionTextRequest(request)) {
            return null;
        }
        QuestionResponse question = questionRepository.updateQuestionText(request);
        if (question != null) {
            return toQuestionResponse(question);
        }
        return null;
    }

    @Override
    public QuestionResponse updateAnswers(AnswersRequestUpdate request) {
        if (!QuestionValidation.validateUpdateAnswersRequest(request)) {
            return null;
        }
        QuestionResponse question = questionRepository.updateAnswers(request);
        if (question != null) {
            return toQuestionResponse(question);
        }
        return null;
    }

    @Override
    public QuestionResponse updateCorrectAnswer(CorrectAnswerRequestUpdate request) {
        Optional<QuestionResponse> existingQuestion = questionRepository.findById(request.getId());
        if (existingQuestion.isEmpty() || !QuestionValidation.validateUpdateCorrectAnswerRequest(request, existingQuestion.get().getAnswers())) {
            return null;
        }
        QuestionResponse question = questionRepository.updateCorrectAnswer(request);
        if (question != null) {
            return toQuestionResponse(question);
        }
        return null;
    }

    @Override
    public boolean deleteQuestion(int id) {
        return questionRepository.deleteQuestion(id);
    }

//    @Override
//    public List<QuestionResponse> searchByKeyword(String keyword) {
//        return null;
//    }

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

    public QuestionResponse toQuestionResponse(Question question) {
        return new QuestionResponse(
                question.getQuestionId(),
                question.getQuestionText(),
                question.getAnswers(),
                question.getCorrectAnswer()
        );
    }


}
