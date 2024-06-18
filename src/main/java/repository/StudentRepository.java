package repository;

import entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentRepository implements InRepository{
    private int id = 0;

    private List<Student> students;

    @Override
    public Student add(Student student) {
        id++;
        Student newStudent = new Student(id,student.getName(),student.getEmail());
        students.add(newStudent);
        return newStudent;
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public Optional<Student> findById(int id) {
        for (Student student: students){
            if (student.getStudentId() == id) {
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Student> findByName(String name) {
        List<Student> studentListByName = new ArrayList<>();
        for (Student student:students){
            if (student.getName().equals(name)){
                studentListByName.add(student);
            }
        }
        return studentListByName;
    }

    @Override
    public Optional<Student> findByEmail(String email) {
        for (Student student:students){
            if (student.getEmail().equals(email)){
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(int id) {
        Optional<Student> studentById = findById(id);
        if (studentById.isPresent()){
            Student studentForDelete = studentById.get();
            students.remove(studentForDelete);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Student student) {
        return students.remove(student);
    }
}
