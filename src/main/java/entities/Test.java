package entities;

public class Test {
    private int testId;
    private String testTitle;
    private Course course;
    private List<Question> questions;

    // Конструктор без параметров
    public Test() {
    }

    // Конструктор с параметрами
    public Test(int testId, String testTitle, Course course, List<Question> questions) {
        this.testId = testId;
        this.testTitle = testTitle;
        this.course = course;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
    @Override
    public String toString() {
        return "entities.Test{" +
                "testId=" + testId +
                ", testTitle='" + testTitle + '\'' +
                ", course=" + course +
                ", questions=" + questions +
                '}';
    }
}
