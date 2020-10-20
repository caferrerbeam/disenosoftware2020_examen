package co.edu.eam.disenosoftware.biblioteca.model.requests;

public class BorrowRequest {

  private String bookCode;

  private String userId;

  public String getBookCode() {
    return bookCode;
  }

  public void setBookCode(String bookCode) {
    this.bookCode = bookCode;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


}
