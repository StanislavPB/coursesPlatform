package service;

import dto.TestResultClientResponse;
import dto.TestResultResponce;
import dto.TestResultRequest;
import dto.TestResultSearchByIdResponse;
import entity.TestResult;
import repository.StudentRepository;
import repository.TestRepository;
import repository.TestResultRepository;
import service.util.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestResultService {
    private TestResultRepository testResultRepository;
    private TestRepository testRepository;
    private StudentRepository studentRepository;
    private Validation validation;

    public TestResultService(TestResultRepository testResultRepository, TestRepository testRepository, StudentRepository studentRepository, Validation validation) {
        this.testResultRepository = testResultRepository;
        this.testRepository = testRepository;
        this.studentRepository = studentRepository;
        this.validation = validation;
    }

    public TestResultResponce addNewTestResult(TestResultRequest testResultRequest){
        List<String> errors = validation.validateTestResult(testResultRequest);
        Integer newId = 0;

        if (errors.isEmpty()){
            newId = testResultRepository.addResult(testResultRequest);
        }
        return new TestResultResponce(newId, errors);
    }

    public TestResultSearchByIdResponse findTestResultById (int testResultId){
        Optional<TestResult> testResultOptional = testResultRepository.findByResultId(testResultId);
        List<String> errors = new ArrayList<>();

        if (testResultOptional.isPresent()){
            TestResult testResultById = testResultOptional.get();

            String testTitle = testRepository.findById(testResultById.getTestId()).get().getTestTitle();
            String studentName = studentRepository.findById(testResultById.getStudentId()).get().getName();

            TestResultClientResponse testResultClientResponse = new TestResultClientResponse(testTitle, studentName, testResultById.getResult());

            return new TestResultSearchByIdResponse(testResultClientResponse, errors);
        }else {
            errors.add("Entity Test Result with ID: " + testResultId + " not found");
            TestResultClientResponse testResultClientResponse = new TestResultClientResponse("", "", 0);

            return new TestResultSearchByIdResponse(testResultClientResponse, errors);
        }

    }

}
