package entity;

import java.util.Map;

public class Question {
    private Integer questionId;
    private String questionText; // Как называется твой предмет?
    private Map<Integer, String> questions; // 1. Java, 2. Ruby
    private Integer correctAnswer; //1


    public Question(Integer questionId, String questionText, Map<Integer, String> questions, Integer correctAnswer) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.questions = questions;
        this.correctAnswer = correctAnswer;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public Map<Integer, String> getQuestions() {
        return questions;
    }

    public Integer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setQuestions(Map<Integer, String> questions) {
        this.questions = questions;
    }

    public void setCorrectAnswer(Integer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setAnswers(Map<Integer, String> newAnswers) {
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", questionText='" + questionText + '\'' +
                ", questions=" + questions +
                ", correctAnswer=" + correctAnswer +
                '}';
    }


}
