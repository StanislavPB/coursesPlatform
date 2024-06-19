package dto.testResult;

public class TestResultClientResponse {
    String testTitle;
    String studentName;
    double result;

    public TestResultClientResponse(String testTitle, String studentName, double result) {
        this.testTitle = testTitle;
        this.studentName = studentName;
        this.result = result;
    }

    public String getTestTitle() {
        return testTitle;
    }

    public String getStudentName() {
        return studentName;
    }

    public double getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "TestResultClientResponse{" +
                "testTitle='" + testTitle + '\'' +
                ", studentName='" + studentName + '\'' +
                ", result=" + result +
                '}';
    }
}
