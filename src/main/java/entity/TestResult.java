package entity;

public class TestResult {

    private int resultId;
    private int testId;
    private int studentId;
    private double result;

    public TestResult(int resultId, int testId, int studentId, double result) {
        this.resultId = resultId;
        this.testId = testId;
        this.studentId = studentId;
        this.result = result;
    }

    public int getResultId() {
        return resultId;
    }

    public int getTestId() {
        return testId;
    }

    public int getStudentId() {
        return studentId;
    }

    public double getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "resultId=" + resultId +
                ", testId=" + testId +
                ", studentId=" + studentId +
                ", result=" + result +
                '}';
    }
}
