package dto;

public class TestResultRequest {
    private int testId;
    private int studentId;
    private double result;

    public TestResultRequest(int testId, int studentId, double result) {
        this.testId = testId;
        this.studentId = studentId;
        this.result = result;
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
}
