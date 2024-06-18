package dto;

import java.util.List;

public class TestResultSearchItemResponse {
    private TestResultClientResponse testResultClientResponse;
    private List<String> errors;

    public TestResultSearchItemResponse(TestResultClientResponse testResultClientResponse, List<String> errors) {
        this.testResultClientResponse = testResultClientResponse;
        this.errors = errors;
    }

    public TestResultClientResponse getTestResultClientResponse() {
        return testResultClientResponse;
    }

    public List<String> getErrors() {
        return errors;
    }

    @Override
    public String toString() {
        return "TestResultSearchByIdResponse{" +
                "testResultClientResponse=" + testResultClientResponse +
                ", errors=" + errors +
                '}';
    }
}
