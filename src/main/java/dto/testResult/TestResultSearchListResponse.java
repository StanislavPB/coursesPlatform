package dto.testResult;

import java.util.List;

public class TestResultSearchListResponse {
    private List<TestResultClientResponse> testResultClientListResponse;
    private List<String> errors;

    public TestResultSearchListResponse(List<TestResultClientResponse> testResultClientListResponse, List<String> errors) {
        this.testResultClientListResponse = testResultClientListResponse;
        this.errors = errors;
    }

    public List<TestResultClientResponse> getTestResultClientListResponse() {
        return testResultClientListResponse;
    }

    public List<String> getErrors() {
        return errors;
    }

    @Override
    public String toString() {
        return "TestResultSearchByIdResponse{" +
                "testResultClientResponse=" + testResultClientListResponse +
                ", errors=" + errors +
                '}';
    }
}
