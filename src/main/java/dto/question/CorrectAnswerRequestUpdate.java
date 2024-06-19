package dto.question;

public class CorrectAnswerRequestUpdate {
    private Integer id;
    private Integer newCorrectAnswer;

    public CorrectAnswerRequestUpdate(Integer id, Integer newCorrectAnswer) {
        this.id = id;
        this.newCorrectAnswer = newCorrectAnswer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNewCorrectAnswer() {
        return newCorrectAnswer;
    }

    public void setNewCorrectAnswer(Integer newCorrectAnswer) {
        this.newCorrectAnswer = newCorrectAnswer;
    }
}
