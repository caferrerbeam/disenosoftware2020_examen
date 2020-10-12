package co.edu.eam.disenosoftware.biblioteca.services;

import co.edu.eam.disenosoftware.biblioteca.exceptions.BusinessException;
import co.edu.eam.disenosoftware.biblioteca.exceptions.ErrorCodesEnum;
import co.edu.eam.disenosoftware.biblioteca.model.entities.Book;
import co.edu.eam.disenosoftware.biblioteca.model.entities.Borrow;
import co.edu.eam.disenosoftware.biblioteca.model.entities.User;
import co.edu.eam.disenosoftware.biblioteca.repositories.BookRepository;
import co.edu.eam.disenosoftware.biblioteca.repositories.BorrowRepository;
import co.edu.eam.disenosoftware.biblioteca.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Borrow service
 */
@Service
public class BorrowService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BookRepository bookRepository;

  @Autowired
  private BorrowRepository borrowRepository;

  /**
   * Punto 1: prestar libro
   * para prestar libro se deben seguir las siguientes reglas
   *   1. el usuario debe existir, si no, lanzar la excepcion con codigo 0001 y status NOT_FOUND
   *   2. el libro debe existir, si no lanzar la excepcion con codigo 0002 y status NOT_FOUND
   *   3. el usuario no debe tener este libro ya prestado, si  ya lo tiene lanzar la excepcion con codigo 0003 y status PRECONDITION_FAILED
   *   4. el usuario no debe tener mas de tres libros prestados, si ya los tiene lanzar la excepcion con codigo 0004 y status PRECONDITION_FAILED
   *
   *   Notas:
   *   1. Los ErrorCodeEnum no existen, crearlos.
   *   2. Los metodos del repositorio ya estan creados en BorrowRepository y UserRepository
   *
   *   Qualification: 5 unit tests associated with this method in BorrrowServiceTest
   */
  public void borrowBook(String bookCode, String userIdentification) {

    User user = userRepository.find(userIdentification);

    if(user == null){
      throw  new BusinessException("user not found", ErrorCodesEnum.USER_NOT_FOUND);
    }

    Book book = bookRepository.find(bookCode);

    if(book == null){
      throw  new BusinessException("book not found", ErrorCodesEnum.BOOK_NOT_FOUND);
    }

    List<Borrow> borrowsByUser = getBorrrowsByUser(userIdentification);

    if(borrowsByUser.size() >= 3) {
      throw  new BusinessException("book already borrewed", ErrorCodesEnum.MAX_BORROWS);
    }

    for(Borrow borrow: borrowsByUser) {
      if(borrow.getBook().getCode().equals(bookCode)) {
        throw  new BusinessException("book already borrewed", ErrorCodesEnum.REPEATED_BOOK);
      }
    }

    Borrow borrow = new Borrow();
    borrow.setBook(book);
    borrow.setUser(user);

    borrowRepository.create(borrow);
  }

  /**
   * Punto 2: listar prestamos de un usuario
   * @param userIdentification
   * @return
   *
   * Qualification: 1 unit tests associated with this method in BorrrowServiceTest
   */
  public List<Borrow> getBorrrowsByUser(String userIdentification) {
    return borrowRepository.getBorrowsByUserId(userIdentification);
  }

}
