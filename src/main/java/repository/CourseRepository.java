package repository;

import entity.Course;
import repository.interfaces.InterfaceCourseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class CourseRepository implements InterfaceCourseRepository {
    private List<Course> courses;

    public CourseRepository(List<Course> courses) {
        this.courses = new ArrayList<>();
    }

    @Override
    public List<Course> addCourse (String courseTitle, String courseDescription){
        int courseId = courses.isEmpty() ? 1 : courses.stream()
                                              .mapToInt(Course::getCourseId)
                                              .max()
                                              .orElse(0) + 1;
        Course newCourse = new Course(courseId, courseTitle, courseDescription, new ArrayList<>(), new ArrayList<>());
        courses.add(newCourse);

        return courses;
    }

    @Override
    public Optional <Course> findById(Integer courseId) {
        return courses.stream()
                .filter(course ->course.getCourseId().equals(courseId))
                .findFirst();
            }

    @Override
    public List<Course> findAll(){
        return courses;
    }
    @Override
    public Optional <Course> findByCourseTitle(String courseTitle) {
        return courses.stream()
                .filter(course -> course.getCourseTitle().equals(courseTitle))
                .findFirst();
            }


    @Override
    public boolean deleteCourse(Course course) {
        return courses.remove(course);
        }

    @Override
    public boolean deleteAllCourses(List<Course> coursesToDelete) {
        return courses.removeAll(coursesToDelete);
    }
}


