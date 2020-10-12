package co.edu.eam.disenosoftware.biblioteca.controllers;

import org.springframework.web.bind.annotation.RestController;

@RestController
//el path de este controller esta en Routes.BORROWS_URL
public class BorrowsController {

  /**
   * Punto 3: Borrow a book
   * Verb: POST
   * URL: /api/borrows
   * Params: body = {user_id: "1" , book_code: "1"}
   * Returns: 200 Ok, 404 if userID or bookId not found, 412 other business errors
   *
   * Qualification: 5 unit test associated with this method in BorrowsControllerTest
   */
  public void borrowBook() {

  }

}
