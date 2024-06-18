package dto;

import java.util.List;

public class TestResultSearchByIdResponse {
    private TestResultClientResponse testResultClientResponse;
    private List<String> errors;

    public TestResultSearchByIdResponse(TestResultClientResponse testResultClientResponse, List<String> errors) {
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
