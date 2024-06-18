package service;

import dto.*;
import entity.TestResult;
import repository.StudentStudentRepository;
import repository.TestRepository;
import repository.TestResultRepository;
import service.util.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestResultService {
    private TestResultRepository testResultRepository;
    private TestRepository testRepository;
    private StudentStudentRepository studentRepository;
    private Validation validation;

    public TestResultService(TestResultRepository testResultRepository, TestRepository testRepository, StudentStudentRepository studentRepository, Validation validation) {
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

    public TestResultSearchItemResponse findTestResultByResultId (int testResultId){
        Optional<TestResult> testResultOptional = testResultRepository.findByResultId(testResultId);
        List<String> errors = new ArrayList<>();

        if (testResultOptional.isPresent()){
            TestResult testResultById = testResultOptional.get();

            TestResultClientResponse testResultClientResponse = createTestResultClientResponceDTO(testResultById);

            return new TestResultSearchItemResponse(testResultClientResponse, errors);
        }else {
            errors.add("Entity Test Result with ID: " + testResultId + " not found");
            TestResultClientResponse testResultClientResponse = new TestResultClientResponse("", "", 0);

            return new TestResultSearchItemResponse(testResultClientResponse, errors);
        }

    }

    public TestResultSearchListResponse findTestResultByTestId (int testId){
        List<TestResult> testResultByTestId = testResultRepository.findByTestId(testId);
        List<String> errors = new ArrayList<>();

        List<TestResultClientResponse> findTestResultsByTestId = new ArrayList<>();

        if (!testResultByTestId.isEmpty()){
            for (TestResult result : testResultByTestId){
                findTestResultsByTestId.add(createTestResultClientResponceDTO(result));
            }
            return new TestResultSearchListResponse(findTestResultsByTestId, errors);
        }else {
            errors.add("Test results of test with ID: " + testId + " not found");
            return new TestResultSearchListResponse(findTestResultsByTestId, errors);
        }
    }

    public TestResultSearchListResponse findTestResultByStudentId (int studentId){
        List<TestResult> testResultByStudentId = testResultRepository.findByStudentId(studentId);
        List<String> errors = new ArrayList<>();

        List<TestResultClientResponse> findTestResultsByStudentId = new ArrayList<>();

        if (!testResultByStudentId.isEmpty()){
            for (TestResult result : testResultByStudentId){
                findTestResultsByStudentId.add(createTestResultClientResponceDTO(result));
            }
            return new TestResultSearchListResponse(findTestResultsByStudentId, errors);
        }else {
            errors.add("Test results of test with ID: " + studentId + " not found");
            return new TestResultSearchListResponse(findTestResultsByStudentId, errors);
        }
    }

    public TestResultClientResponse createTestResultClientResponceDTO (TestResult testResult){
        String testTitle = testRepository.findById(testResult.getTestId()).get().getTestTitle();
        String studentName = studentRepository.findById(testResult.getStudentId()).get().getName();
        double result = testResult.getResult();
        return new TestResultClientResponse(testTitle, studentName, result);
    }


}
