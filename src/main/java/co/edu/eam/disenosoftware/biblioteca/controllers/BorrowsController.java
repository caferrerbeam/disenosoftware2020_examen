package co.edu.eam.disenosoftware.biblioteca.controllers;

import co.edu.eam.disenosoftware.biblioteca.services.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/borrows")
public class BorrowsController {

  @Autowired
  private BorrowService borrowService;

  /**
   * Punto 3: Borrow a book
   * Verb: POST
   * URL: /api/borrows
   * Params: body = {"userId": "1" , "bookCode": "1"}
   * Returns: 200 Ok, 404 if userID or bookId not found, 412 other business errors
   * <p>
   * Qualification: 5 unit test associated with this method in BorrowsControllerTest
   */
  @RequestMapping("/api/borrows")
  @PostMapping
  public void borrowBook() {

  }
}
