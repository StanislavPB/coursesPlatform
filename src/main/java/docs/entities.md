
==================ENTITY
Course
    int courseId;
    String courseTitle;
    String courseDescription;
    List<String> courseContent;
    List<Student> students;

Student
    int studentId;
    String name;
    String email;

Test
    int testId;
    String testTitle;
    Course course;
    List<Question> questions;

Question
    int questionId;
    String questionText;
    Map<Integer (answerId), String (answerText)> questions;
    int correctAnswer;
    

TestResult
    int resutltId;
    int testId;
    Student student;
    double result;