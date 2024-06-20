package entity;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    @Test
    void testConstructor() {
        Map<Integer, String> questions = new HashMap<>();
        questions.put(1, "Вариант 1");
        questions.put(2, "Вариант 2");

        Map<Integer, String> answers = new HashMap<>();
        answers.put(1, "Ответ 1");
        answers.put(2, "Ответ 2");

        Question question = new Question(1, "Какой язык программирования вы изучаете?", questions, answers, 1);
        assertEquals(1, question.getQuestionId());
        assertEquals("Какой язык программирования вы изучаете?", question.getQuestionText());
        assertEquals(questions, question.getQuestions());
        assertEquals(answers, question.getAnswers());
        assertEquals(1, question.getCorrectAnswer());
    }
    @Test
    public void testGettersAndSetters() {
        Map<Integer, String> questions = new HashMap<>();
        questions.put(1, "Вариант 1");
        questions.put(2, "Вариант 2");

        Map<Integer, String> answers = new HashMap<>();
        answers.put(1, "Ответ 1");
        answers.put(2, "Ответ 2");

        Question question = new Question(1, "Какой язык программирования вы изучаете?", questions, answers, 1);

        question.setQuestionId(2);
        assertEquals(2, question.getQuestionId());

        question.setQuestionText("Какой язык программировавния является строго типизированным?");
        assertEquals("Какой язык программировавния является строго типизированным?", question.getQuestionText());

        Map<Integer, String> newQuestions = new HashMap<>();
        newQuestions.put(1, "Java");
        newQuestions.put(2, "Python");
        question.setQuestions(newQuestions);
        assertEquals(newQuestions, question.getQuestions());

        Map<Integer, String> newAnswers = new HashMap<>();
        newAnswers.put(1, "Java");
        newAnswers.put(2, "Python");
        question.setAnswers(newAnswers);
        assertEquals(newAnswers, question.getAnswers());

        question.setCorrectAnswer(1);
        assertEquals(1, question.getCorrectAnswer());
    }

    @Test
    public void testToString() {
        Map<Integer, String> questions = new HashMap<>();
        questions.put(1, "Вариант 1");
        questions.put(2, "Вариант 2");

        Map<Integer, String> answers = new HashMap<>();
        answers.put(1, "Ответ 1");
        answers.put(2, "Ответ 2");

        Question question = new Question(1, "Какой язык программирования вы изучаете?", questions, answers, 1);
        String expected = "Question{questionId=1, questionText='Какой язык программирования вы изучаете?', questions={1=Вариант 1, 2=Вариант 2}, answers={1=Ответ 1, 2=Ответ 2}, correctAnswer=1}";
        assertEquals(expected, question.toString());
    }


}