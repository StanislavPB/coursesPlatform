package entity;

public class TestResult {

    private int resultId = 0;
    private int testId;
    private Student student;
    private double result;

    public TestResult(int testId, Student student, double result) {
        this.resultId = ++resultId;
        this.testId = testId;
        this.student = student;
        this.result = result;
    }

    public int getResultId() {
        return resultId;
    }

    public int getTestId() {
        return testId;
    }

    public Student getStudent() {
        return student;
    }

    public double getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "resultId=" + resultId +
                ", testId=" + testId +
                ", student=" + student +
                ", result=" + result +
                '}';
    }
}
