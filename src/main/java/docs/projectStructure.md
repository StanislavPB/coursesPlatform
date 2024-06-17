

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

==================REPOSITORY
CourseRepository
    List<Corse> courses;

StudentRepository
    List<Student> students;

TestRepository
    List<Test> tests;

QuestionRepository
    List<Question> questions;

TestResultRepository
    List<TestResult> results;


==================METHODS for repo

CourseRepository

StudentRepository

TestRepository

QuestionRepository

TestResultRepository







Создание студента:

Создание курса:

Регистрация на курс:
1. Добавить студента в список курсов CourseStudents

Создание теста:
    Список вопросов
    Список ответов
    Проверка правильности

Проведение теста:

Статистика по тестам:

Статистика по студентам:
______________________________________________________________________
Тест
    Вопрос
        варианты ответа
            индекс ответа (а, б, в...)
            Текст ответа
            правильный? (да/нет)