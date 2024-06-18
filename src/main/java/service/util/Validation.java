package service.util;



import dto.TestResultRequest;
import java.util.ArrayList;
import java.util.List;

public class Validation {

    public List<String> validateTestResult(TestResultRequest testResultRequest){
        /*
        testId < 0
        studentId < 0
        result < 0
         */
        List<String> errors = new ArrayList<>();

        if (testResultRequest.getTestId() < 0) {
            errors.add("entity.Test ID must be greater than 0");
        }

        if (testResultRequest.getStudentId() < 0) {
            errors.add("Student ID must be greater than 0");
        }
        if (testResultRequest.getResult() < 0) {
            errors.add("Result must be greater than 0");
        }

        return errors;
    }
}
