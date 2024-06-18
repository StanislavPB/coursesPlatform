
==================ENTITY
Course (Любовь)
int courseId;
String courseTitle;
String courseDescription;
List<String> courseContent;
List<Student> students;

Student (Валера)
int studentId;
String name;
String email;

Test(Алена)
int testId;
String testTitle;
Course course;
List<Question> questions;

Question(Денис)
int questionId;
String questionText;
Map<Integer (answerId), String (answerText)> questions;
int correctAnswer;


TestResult(Алекс)
int resultId;
int testId;
Student student;
double result;