import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class QuestionRepository {
    private Map<Integer, Question> questions = new HashMap<>();
    private Integer currentId = 0;
//

    public Question create(String questionText,Map<Integer, String> answers, Integer correctAnswer){
        int id = currentId++;
        Question question = new Question(id, questionText, answers, correctAnswer);
        questions.put(id, question);
        return question;
    }

    // find all (aka PrintAll) => список всех вопросов (вся коллекция)
    public List<Question> findAll(){
        return new ArrayList<>(questions.values());
    }

    // find by ID => объект вопрос
    public Optional<Question> findById (Integer questionId){
        return Optional.ofNullable(questions.get(questionId));
    }

    // update questionText => DTO result
    public Question updateQuestionText(Integer questionId, String newQuestionText) {
        Question question = questions.get(questionId);
        if (question != null) {
            question.setQuestionText(newQuestionText);
        }
        return question;
    }



    // update Answers => DTO result
    public Question updateAnswers(Integer questionId, Map<Integer, String> newAnswers) {
        Question question = questions.get(questionId);
        if (question != null) {
            question.setAnswers(newAnswers);
        }
        return question;
    }

    // update correctAnswer => DTO result
    public Question updateCorrectAnswer(Integer questionId, Integer newCorrectAnswer) {
        Question question = questions.get(questionId);
        if (question != null) {
            question.setCorrectAnswer(newCorrectAnswer);
        }
        return question;
    }

    // deleteQuestion => boolean
    public boolean deleteQuestion(Integer questionId) {
        return questions.remove(questionId) != null;
    }


}
