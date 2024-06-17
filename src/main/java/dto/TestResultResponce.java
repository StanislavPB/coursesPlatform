package dto;

import java.util.List;

public class TestResultResponce {
    private int testId;
    private List<String> errors;

    public TestResultResponce(int testId, List<String> errors) {
        this.testId = testId;
        this.errors = errors;
    }

    public int getTestId() {
        return testId;
    }

    public List<String> getErrors() {
        return errors;
    }
}
