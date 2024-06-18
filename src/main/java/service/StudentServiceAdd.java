package service;

import dto.StudentRequest;
import dto.StudentResponse;
import entity.Student;
import repository.interfaces.InStudentRepository;
import service.util.UserInput;
import service.util.Validation;

public class StudentServiceAdd {
    private final InStudentRepository repository;
    private final Validation validation;
    UserInput ui = new UserInput();

    public StudentServiceAdd(InStudentRepository repository, Validation validation) {
        this.repository = repository;
        this.validation = validation;
    }


}
