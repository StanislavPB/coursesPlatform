package repository.interfaces;

import entity.Student;

import java.util.List;
import java.util.Optional;

public interface InStudentRepository {
    public Student add(Student newStudent);

    public List<Student> findAll();

    public Optional<Student> findById(int id);

    public Optional<Student> findByEmail(String email);

    public List<Student> findByName(String name);

    public boolean delete(int id);

    public boolean delete(Student student);



}
