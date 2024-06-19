package repository.interfaces;

import dto.testResult.TestResultRequest;
import entity.TestResult;

import java.util.List;
import java.util.Optional;

public interface InTestResultRepository {
    public Integer addResult (TestResultRequest result);

    public List<TestResult> findAll();

    public Optional<TestResult> findByResultId(int id);
    public List<TestResult> findByTestId(int id);

    public List<TestResult> findByStudentId(int id);


}
