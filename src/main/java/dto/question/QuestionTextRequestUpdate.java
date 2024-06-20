package dto.question;

public class QuestionTextRequestUpdate {
    private Integer questionId;
    private String newQuestionText;

    public QuestionTextRequestUpdate(Integer questionId, String newQuestionText) {
        this.questionId = questionId;
        this.newQuestionText = newQuestionText;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getNewQuestionText() {
        return newQuestionText;
    }

    public void setNewQuestionText(String newQuestionText) {
        this.newQuestionText = newQuestionText;
    }

    public String getQuestionText() {
        return null;
    }
}
