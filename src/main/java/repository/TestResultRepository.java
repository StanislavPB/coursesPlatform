package repository;

import entity.TestResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestResultRepository {
    private List<TestResult> testResults;

    public TestResultRepository() {
        this.testResults = new ArrayList<>();
    }

    public boolean addResult (TestResult result){
        return testResults.add(result);
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
