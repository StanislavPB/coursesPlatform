package service.util;

import dto.CourseRequest;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class CourseValidation {

    public List<String> validateCourseRequest (CourseRequest courseRequest) {
        List<String> errors = new ArrayList<>();

        if (courseRequest.getCourseTitle() == null || courseRequest.getCourseTitle().trim().isEmpty()) {
            errors.add("Course title must not be empty");
        }

        if (courseRequest.getCourseDescription() == null || courseRequest.getCourseDescription().trim().isEmpty()) {
            errors.add("Course description must not be empty");
        }
        return errors;
    }

    public List<String> validateCourseContent (String content) {
        List<String> errors = new ArrayList<>();

        if (content == null || content.trim().isEmpty()) {
            errors.add("Course content must not be empty");
        }

        return errors;
    }

    public List<String> validateStudent (Student student) {
        List<String> errors = new ArrayList<>();

        if (student == null || student.getName().trim().isEmpty()) {
            errors.add("Student name must not be empty");
        }
        /*
        мои обновления с учетом необходимости коррекции CourseRepository и
        расширившихся требований к сервисам курсов:

        - update CourseRepository;
        - update InterfaceCourseRepository;
        - update CourseServiceInterface;
        - update CourseService;
        - add CourseValidation.

        Завтра наше последнее занятие со Станиславом, поэтому валидацию добавила сегодня,
        чтобы завтра была возможность спокойно смержиться и, возможно, заняться тестами.

        я отправила pull request.

        Всем приятного вечера!)

         */

        return errors;
    }

}
