package service;

import entity.Student;
import repository.StudentRepository;

import java.util.List;
import java.util.Optional;

public class StudentService {
    private final StudentRepository studentRepository = new StudentRepository();

    public Student createStudent(String name, String email) {
        return studentRepository.add(new Student(name,email));
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(int id) {
        return studentRepository.findById(id);
    }
    // Вывод на печать всех студентов
    public void printAllStudents() {
        System.out.println(getAllStudents());

    }



}




