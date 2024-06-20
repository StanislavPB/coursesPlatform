package dto.question;

import entity.Question;

import java.util.Map;

public class QuestionResponse extends Question {

    public QuestionResponse(Integer questionId, String questionText, Map<Integer, String> answers, Integer correctAnswer) {
        super(questionId, questionText, answers, correctAnswer);
    }

    @Override
    public String toString() {
        return "QuestionResponse{" +
                "questionId=" + getQuestionId() +
                ", questionText='" + getQuestionText() + '\'' +
                ", answers=" + getAnswers() +
                ", correctAnswer=" + getCorrectAnswer() +
                '}';
    }
}