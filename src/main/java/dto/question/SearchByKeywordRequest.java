package dto.question;

public class SearchByKeywordRequest {
    private String keyword;

    public SearchByKeywordRequest(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }
}
