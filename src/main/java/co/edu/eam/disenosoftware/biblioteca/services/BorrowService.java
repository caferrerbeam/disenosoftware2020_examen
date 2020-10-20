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

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Borrow service
 */
@Service
@Transactional
public class BorrowService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BorrowRepository borrowRepository;

  @Autowired
  private BookRepository bookRepository;
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
      if (user == null) {
        throw new BusinessException("El usuario no existe", ErrorCodesEnum.USER_NOT_FOUND);
      }

      Book book = bookRepository.find(bookCode);
      if (book == null) {
        throw new BusinessException("El usuario no existe", ErrorCodesEnum.BOOK_NOT_FOUND);
      }

      List<Borrow> borrowList = borrowRepository.getBorrowsByUserId(userIdentification);
      for (Borrow borrows:borrowList) {
        if (borrows.getBook().getCode().equals(bookCode)) {
          throw new BusinessException("El el usuario ya tiene este libro presatado", ErrorCodesEnum.BOOK_ALREADY_BORROWED);
        }
      }

      if (borrowList.size()>=3) {
        throw new BusinessException("El el usuario ya tiene este libro presatado", ErrorCodesEnum.QUANTITY_MORE_THAN_THREE);
      }

      Borrow borrow = new Borrow(new Date(),book,user);
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
    List<Borrow> borrowList = borrowRepository.getBorrowsByUserId(userIdentification);
    return borrowList;
  }
}
