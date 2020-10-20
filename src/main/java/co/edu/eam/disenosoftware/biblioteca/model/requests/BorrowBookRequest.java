package co.edu.eam.disenosoftware.biblioteca.model.requests;

public class BorrowBookRequest {
  private String userId;
  private String bookCode;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getBookCode() {
    return bookCode;
  }

  public void setBookCoode(String bookCoode) {
    this.bookCode = bookCoode;
  }
}
