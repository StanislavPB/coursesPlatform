
==================REPOSITORY
CourseRepository
    List<Corse> courses;

StudentRepository
    List<Student> students;

repository.TestRepository
    List<entity.Test> tests;

repository.QuestionRepository
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
    update CourseContent => заменить лист courseContent на обновленный лист, получив его на входе
    update Students => заменить лист students на обновленный лист, получив его на входе
    delete Course => boolean 

StudentRepository
    CREATE:
    - создается экземпляр класса
    - генерируется уникальный ID
    - получаем на вход name;
    - получаем на вход email;

    find all (aka PrintAll) => список всех студентов (вся коллекция)
    find by ID => объект студент
    find by name => объект студент
    find by email => объект студент
    update Name => DTO result
    update Email => DTO result
    deleteStudent => boolean


repository.TestRepository

CREATE:
- создается экземпляр класса
- генерируется уникальный ID
- получаем на вход testTitle;
- получаем на вход Course ;
- создаем пустой лист List<Question> questions;

    find all (aka PrintAll) => список всех тестов (вся коллекция)
    find by ID => объект тест
    find by title => объект тест
    find by course => лист тестов, на вход courseId
    update testTitle => DTO result
    update course => DTO result
    update questions => DTO result
    deleteTest => boolean

repository.QuestionRepository

private Integer questionId;
private String questionText; // Как называется твой предмет?
private Map<Integer, String> questions; // 1. Java, 2. Ruby
private Integer correctAnswer; //1


CREATE:
    - создается экземпляр класса
    - генерируется уникальный ID
    - получаем на вход questionText;
    - получаем на вход Map<Integer (answerId), String (answerText)> questions;
    - получаем на вход int correctAnswer;

    find all (aka PrintAll) => список всех вопросов (вся коллекция)
    find by ID => объект вопрос
    update questionText => DTO result
    update answers => DTO result
    update correctAnswer => DTO result
    deleteQuestion => boolean

TestResultRepository
    int testResultId;
    int testId;
    Student student;
    double result;

CREATE:
- создается экземпляр класса
- генерируется уникальный ID
- получаем на вход testId;
- получаем на вход studentId;
- получаем на вход result;

    find all (aka PrintAll) => список всех результатов (вся коллекция)
    find by resultID => объект результат
    find by testID => лист результатов определенного теста
    find by studentID => лист результатов определенного студента