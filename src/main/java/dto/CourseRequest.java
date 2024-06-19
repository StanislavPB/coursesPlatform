package dto;

public class CourseRequest {
    private String courseTitle;
    private String courseDescription;

    public CourseRequest() {
    }

    public CourseRequest(String courseTitle, String courseDescription) {
        this.courseTitle = courseTitle;
        this.courseDescription = courseDescription;
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

    @Override
    public String toString() {
        return "CourseRequest{" +
                "courseTitle='" + courseTitle + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                '}';
    }
}

