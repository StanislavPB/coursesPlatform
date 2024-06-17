
==================ENTITY
Course
    int id;
    String courseTitle;
    String courseDescription;
    List<String> courseContent;
    List<Student> students;

Student
    int id;
    String name;
    String email;

Test
    int id;
    String testTitle;
    Course course;
    List<Question> questions;

Question
    int id;
    String questionText;
    Map<Integer (answerId), String (answerText)> questions;
    int correctAnswer;
    

TestResult
    int testId;
    Student student;
    double result;