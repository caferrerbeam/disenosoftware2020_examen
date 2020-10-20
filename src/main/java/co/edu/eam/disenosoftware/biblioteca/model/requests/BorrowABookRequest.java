package co.edu.eam.disenosoftware.biblioteca.model.requests;

import co.edu.eam.disenosoftware.biblioteca.model.entities.Book;
import co.edu.eam.disenosoftware.biblioteca.model.entities.User;

import java.util.Date;

public class BorrowABookRequest {

  private  String userId;
  private  String bookCode;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getBookCode() {
    return bookCode;
  }

  public void setBookCode(String bookCode) {
    this.bookCode = bookCode;
  }
}
