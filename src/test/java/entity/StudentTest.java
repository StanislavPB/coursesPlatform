package entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class StudentTest {

    @Test
    public void testConstructor() {
        Student student = new Student(1, "Alex", "alex@gmail.com");
        assertEquals(1, student.getStudentId());
        assertEquals("Alex", student.getName());
        assertEquals("alex@gmail.com", student.getEmail());
    }

    @Test
    public void testGettersAndSetters() {
        Student student = new Student(5, "Valery", "valery@gmail.com");

        student.setName("Alex");
        assertEquals("Alex", student.getName());

        student.setEmail("alex@gmail.com");
        assertEquals("alex@gmail.com", student.getEmail());
    }

    @Test
    public void testToString() {
        Student student = new Student(2, "Lubov", "lubov@gmail.com");
        String expected = "Student{studentId=2, name='Lubov', email='lubov@gmail.com'}";
        assertEquals(expected, student.toString());
    }
}