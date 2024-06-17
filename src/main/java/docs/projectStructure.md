

===ENTITY
Course
    int id;
    String courseTitle;
    String courseDescription;
    List<String> courseContent;

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
    String questionText
    Map<String(answer), boolean (isCorrect)>

TestResult
    Test test;
    Student student;
    double result;

===REPOSITORY
CourseRepository

StudentRepository

TestRepository

QuestionRepository

TestResultRepository

CourseStudents (repo)
    int id;
    Course course;
    List<Student> students;
    start date
    end date





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