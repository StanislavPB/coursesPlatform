package repository;

import dto.testResult.TestResultRequest;
import entity.TestResult;
import repository.interfaces.InTestResultRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestResultRepository implements InTestResultRepository {
    private List<TestResult> testResults;
    private Integer idCounter;

    public TestResultRepository() {
        this.testResults = new ArrayList<>();
        this.idCounter = 0;
    }

    public Integer addResult (TestResultRequest result){
        idCounter++;
        testResults.add(new TestResult(idCounter, result.getTestId(), result.getStudentId(), result.getResult()));
        return idCounter;
    }

    public List<TestResult> findAll (){
        return testResults;
    }

    public Optional<TestResult> findByResultId(int testResultId){
        for (TestResult result : testResults){
            if(result.getResultId() == testResultId){
                return Optional.of(result);
            }
        }
        return Optional.empty();
    }

    public List<TestResult> findByTestId(int testId){

        List<TestResult> findedResultsByTestId = new ArrayList<>();

        for (TestResult result : testResults){
            if(result.getTestId() == testId){
                findedResultsByTestId.add(result);
            }
        }
        return findedResultsByTestId;
    }
    public List<TestResult> findByStudentId(int studentId){

        List<TestResult> findedResultsByStudentId = new ArrayList<>();

        for (TestResult result : testResults){
            if(result.getTestId() == studentId){
                findedResultsByStudentId.add(result);
            }
        }
        return findedResultsByStudentId;
    }

}
