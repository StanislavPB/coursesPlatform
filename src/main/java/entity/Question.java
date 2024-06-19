package entity;

import java.util.Map;

public class Question {
    private Integer questionId;
    private String questionText; // Как называется твой предмет?
    private Map<Integer, String> questions;// 1. Java, 2. Ruby
    private Map<Integer, String> answers;
    private Integer correctAnswer; //1

    public Question(Integer questionId, String questionText, Map<Integer, String> questions, Integer correctAnswer) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.questions = questions;
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

    public Map<Integer, String> getQuestions() {
        return questions;
    }

    public void setQuestions(Map<Integer, String> questions) {
        this.questions = questions;
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
        return "Question{" +
                "questionId=" + questionId +
                ", questionText='" + questionText + '\'' +
                ", questions=" + questions +
                ", answers=" + answers +
                ", correctAnswer=" + correctAnswer +
                '}';
    }
}
