package dto.question;

import java.util.Map;

public class AnswersRequestUpdate {
    private Integer questionId;
    private Map<Integer, String> newAnswers;

    public AnswersRequestUpdate(Integer questionId, Map<Integer, String> newAnswers) {
        this.questionId = questionId;
        this.newAnswers = newAnswers;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Map<Integer, String> getNewAnswers() {
        return newAnswers;
    }

    public void setNewAnswers(Map<Integer, String> newAnswers) {
        this.newAnswers = newAnswers;
    }

    public Map<Integer, String> getAnswers() {return newAnswers;
    }
}
