

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
    CREATE:
        - создается экземпляр класса
        - генерируется уникальный ID
        - получаем на вход courseTitle;
        - получаем на вход courseDescription;
        - создается пустая коллекция courseContent
        - создается пустая коллекция students

    find all (aka PrintAll) => список всех курсов (вся коллекция)
    find by ID => объект курс
    find by courseTitle => объект курс
    updateCourseContent => заменить лист courseContent на обновленный лист, получив его на входе
    updateStudents => заменить лист students на обновленный лист, получив его на входе
    deleteCourse => boolean 

StudentRepository
    CREATE:
    - создается экземпляр класса
    - генерируется уникальный ID
    - получаем на вход name;
    - получаем на вход email;

    find all (aka PrintAll) => список всех курсов (вся коллекция)
    find by ID => объект курс
    find by courseTitle => объект курс
    updateName => DTO result
    updateEmail => DTO result
    deleteStudent => boolean


TestRepository
CRUD

QuestionRepository
CRUD

TestResultRepository
CRUD






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