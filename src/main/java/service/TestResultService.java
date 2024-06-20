package service;

import dto.testResult.*;
import entity.TestResult;
import repository.StudentRepository;
import repository.TestRepository;
import repository.TestResultRepository;
import service.util.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

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
        List<TestResult> testResultsByStudentId = testResultRepository.findByStudentId(studentId);
        List<String> errors = new ArrayList<>();

        List<TestResultClientResponse> findedTestResultsByStudentId = new ArrayList<>();

        if (!testResultsByStudentId.isEmpty()){
            for (TestResult result : testResultsByStudentId){
                findedTestResultsByStudentId.add(createTestResultClientResponceDTO(result));
            }
            return new TestResultSearchListResponse(findedTestResultsByStudentId, errors);
        }else {
            errors.add("Test results of test with ID: " + studentId + " not found");
            return new TestResultSearchListResponse(findedTestResultsByStudentId, errors);
        }
    }

    public TestResultClientResponse createTestResultClientResponceDTO (TestResult testResult){
        String testTitle = testRepository.findById(testResult.getTestId()).get().getTestTitle();
        String studentName = studentRepository.findById(testResult.getStudentId()).get().getName();
        double result = testResult.getResult();
        return new TestResultClientResponse(testTitle, studentName, result);
    }

    public void printAllTestResultStatistic (){

        int allResultsAmount = testResultRepository.findAll().size();
        double averageResult;

        OptionalDouble average = testResultRepository.findAll().stream()
                .mapToDouble(TestResult :: getResultId)
                .average();
        if(average.isPresent()){
            averageResult = average.getAsDouble();
        } else {
            averageResult = 0.0;
        }

        System.out.printf("Total amount of tests is " + allResultsAmount + ", average result is %.1f%n", + averageResult);
    }

    public void printTestResultStatisticByTestId (int testId){

        TestResultSearchListResponse searchResult = findTestResultByTestId (testId);

        if (searchResult.getErrors().isEmpty()) {

            List<TestResultClientResponse> responseList = searchResult.getTestResultClientListResponse();

            int attempts = responseList.size();
            String testTitle = responseList.getFirst().getTestTitle();

            double averageResult;

            OptionalDouble average = responseList.stream()
                    .mapToDouble(TestResultClientResponse::getResult)
                    .average();
            if (average.isPresent()) {
                averageResult = average.getAsDouble();
            } else {
                averageResult = 0.0;
            }

            System.out.printf("Total amount of test \"" + testTitle + "\" is " + attempts + " , average result is %.1f%n ", + averageResult);

        } else {
            for (String error : searchResult.getErrors()) {
                System.out.println(error);
            }
        }
    }

    public void printTestResultStatisticByStudentId (int studentId) {

        TestResultSearchListResponse searchResult = findTestResultByStudentId(studentId);

        if (searchResult.getErrors().isEmpty()) {

            List<TestResultClientResponse> responseList = searchResult.getTestResultClientListResponse();

            int attempts = responseList.size();
            String studentName = responseList.getFirst().getStudentName();

            double averageResult;

            OptionalDouble average = responseList.stream()
                    .mapToDouble(TestResultClientResponse::getResult)
                    .average();
            if (average.isPresent()) {
                averageResult = average.getAsDouble();
            } else {
                averageResult = 0.0;
            }

            System.out.printf("Student " + studentName + " has passed through " + attempts + "tests , average result is %.1f%n ", +averageResult);

        } else {
            for (String error : searchResult.getErrors()) {
                System.out.println(error);
            }
        }
    }

    public void printAllTestResults(){
        for (TestResult result : testResultRepository.findAll()){
            TestResultClientResponse resultForPrint = createTestResultClientResponceDTO(result);
            System.out.println("====== All Test Results ======");
            System.out.println("Test: " + resultForPrint.getTestTitle());
            System.out.println("Student: " + resultForPrint.getStudentName());
            System.out.println("Result: " + resultForPrint.getResult());
            System.out.println("------");
        }
    }


}
