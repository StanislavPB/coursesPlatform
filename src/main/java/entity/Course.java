package entity;

 import entity.Student;

 import java.util.ArrayList;
import java.util.List;

public class Course {
    private Integer courseId;
    private String courseTitle;
    private String courseDescription;
    private List<String> courseContent;
    private List<Student> students;

    public Course(int courseId, String courseTitle, String courseDescription) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.courseDescription = courseDescription;
        this.courseContent = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public List<String> getCourseContent() {
        return courseContent;
    }

    public void setCourseContent(List<String> courseContent) {
        this.courseContent = courseContent;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseTitle='" + courseTitle + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", courseContent=" + courseContent +
                ", students=" + students +
                '}';
    }
}
