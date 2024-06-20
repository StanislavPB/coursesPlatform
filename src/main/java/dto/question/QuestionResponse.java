package dto.question;

import entity.Question;

import java.util.Map;

public class QuestionResponse extends Question {
    private Integer questionId;
    private String questionText;
    private Map<Integer, String> answers;
    private Integer correctAnswer;

    public QuestionResponse(Integer questionId, String questionText, Map<Integer, String> answers, Integer correctAnswer) {

        this.questionId = questionId;
        this.questionText = questionText;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Map<Integer, String> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<Integer, String> answers) {
        this.answers = answers;
    }

    public Integer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Integer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString() {
        return "QuestionResponse{" +
                "questionId=" + questionId +
                ", questionText='" + questionText + '\'' +
                ", answers=" + answers +
                ", correctAnswer=" + correctAnswer +
                '}';
    }
}
