package dto;

import java.util.List;

public class CourseResponse {
    private String courseTitle;
    private String courseDescription;
    private List<String> courseContent;

    public CourseResponse() {
    }

    public CourseResponse(String courseTitle, String courseDescription, List<String> courseContent) {
        this.courseTitle = courseTitle;
        this.courseDescription = courseDescription;
        this.courseContent = courseContent;
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

    @Override
    public String toString() {
        return "CourseResponse{" +
                "courseTitle='" + courseTitle + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", courseContent=" + courseContent +
                '}';
    }
}
