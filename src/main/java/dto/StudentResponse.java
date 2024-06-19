package dto;

public class StudentResponse {
    private String responseName;
    private String responseEmail;

    public StudentResponse(String responseName, String responseEmail) {
        this.responseName = responseName;
        this.responseEmail = responseEmail;
    }

    public String getResponseName() {
        return responseName;
    }

    public String getResponseEmail() {
        return responseEmail;
    }

    @Override
    public String toString() {
        return "StudentResponse{" +
                "responseName='" + responseName + '\'' +
                ", responseEmail='" + responseEmail + '\'' +
                '}';
    }
}
