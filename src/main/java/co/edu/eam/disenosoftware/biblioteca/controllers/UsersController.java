package co.edu.eam.disenosoftware.biblioteca.controllers;

import co.edu.eam.disenosoftware.biblioteca.model.entities.Borrow;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//el path de este controller esta en Routes.USERS_URL
public class UsersController {

  /**
   * Punto 4: Borrows by user
   * Verb: GET
   * URL: /api/users/{userId}/borrows
   * Params: path = userId
   * Returns: 200 Ok, with list of borrows
   *
   * Qualification: 1 unit test associated with this method in UserControllerTest
   */
  public List<Borrow> getBorrowsByUser() {
    return null;
  }
}
