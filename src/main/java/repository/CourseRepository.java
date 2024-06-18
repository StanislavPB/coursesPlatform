package repository;

import entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
    private List<Course> courses;

    public CourseRepository(List<Course> courses) {
        this.courses = new ArrayList<>();
    }
    public List<Course> addCourse (String courseTitle, String courseDescription){
        int courseId = courses.isEmpty() ? 1 : courses.stream()
                                              .mapToInt(Course::getCourseId)
                                              .max()
                                              .orElse(0) + 1;
        Course newCourse = new Course(courseId, courseTitle, courseDescription, new ArrayList<>(), new ArrayList<>());
        courses.add(newCourse);

        return courses;
    }
    public Course findById(Integer courseId) {
        for (Course course : courses) {
            if (course.getCourseId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    public List<Course> findAll(){

        return courses;
    }

    public Course findByCourseTitle(String courseTitle) {
        for (Course course : courses) {
            if (course.getCourseTitle().equals(courseTitle)) {
                return course;
            }
        }
        return null;
    }

    public List<Course> updateCourseContent(Integer courseId, Course updatedCourse) {
           Course course = findById(courseId);
                if (course != null) {
                    course.setCourseTitle(updatedCourse.getCourseTitle());
                    course.setCourseDescription(updatedCourse.getCourseDescription());
                    course.setCourseContent(updatedCourse.getCourseContent());
                }
                return courses;
            }

        public boolean deleteCourse(Course course) {
            return courses.remove(course);
        }

    public boolean deleteAllCourses(List<Course> coursesToDelete) {
        return courses.removeAll(coursesToDelete);
    }

}


