package co.edu.eam.disenosoftware.biblioteca.controllers;

import co.edu.eam.disenosoftware.biblioteca.model.entities.Borrow;
import co.edu.eam.disenosoftware.biblioteca.repositories.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

  /**
   * Punto 4: Borrows by user
   * Verb: GET
   * URL: /api/users/{userId}/borrows
   * Params: path = userId
   * Returns: 200 Ok, with list of borrows
   * <p>
   * Qualification: 1 unit test associated with this method in UserControllerTest
   */
  @Autowired
  BorrowRepository borrowRepository;

  @GetMapping("{userId}/borrows")
  public List<Borrow> getBorrowsByUser(@PathVariable String userId)
  {
  return borrowRepository.getBorrowsByUserId(userId);
  }

}
