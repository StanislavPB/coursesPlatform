package entity;

import java.util.List;

public class Test {
    private int testId;
    private String testTitle;
    private int courseId;
    private List<Question> questions;

    // Конструктор без параметров
    public Test() {
    }

    // Конструктор с параметрами

//    public Test(int testId, String testTitle, Course course, List<Question> questions) {
//        this.testId = testId;
//        this.testTitle = testTitle;
//        this.course = course;
//        this.questions = questions;
//    }


    public Test(int testId, String testTitle, int courseId, List<Question> questions) {
        this.testId = testId;
        this.testTitle = testTitle;
        this.courseId = courseId;
        this.questions = questions;
    }

    // Геттеры и сеттеры
    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getTestTitle() {
        return testTitle;
    }

    public void setTestTitle(String testTitle) {
        this.testTitle = testTitle;
    }



    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Test{" +
                "testId=" + testId +
                ", testTitle='" + testTitle + '\'' +
                ", courseId=" + courseId +
                ", questions=" + questions +
                '}';
    }
}