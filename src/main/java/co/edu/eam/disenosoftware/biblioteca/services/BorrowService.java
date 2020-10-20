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
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Borrow service
 */
@Service
@Transactional
public class BorrowService {

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

  @PersistenceContext
  private EntityManager em;
  @Autowired
  UserRepository userRepository;

  @Autowired
  BookRepository bookRepository;

  @Autowired
  BorrowRepository borrowRepository;

  public void borrowBook(String bookCode, String userIdentification) {

    User user = userRepository.find(userIdentification);

    if (user == null){
      throw new BusinessException("No se encontro el usuario", ErrorCodesEnum.USER_NOT_FOUND);
    }

    Book book =bookRepository.find(bookCode);

    if (book == null){
      throw new BusinessException("No se encontro el libro", ErrorCodesEnum.BOOK_NOT_FOUND);
    }

    List<Borrow> borrow = borrowRepository.getBorrowsByUserId(userIdentification);

    for (int i = 0; i < borrow.size(); i++){
      if (borrow.get(i).getBook().getCode() == bookCode){
        throw new BusinessException("El usuario ya tiene prestado este libro", ErrorCodesEnum.BORROW_ALREADY_EXIST);
      }
    }

    if (borrow.size() ==3){
      throw new BusinessException("Limite de prestamos excedido", ErrorCodesEnum.TO_MUCH_BORROWS);
    }

    Borrow newBorrow = new Borrow(new Date(),book,user);
    borrowRepository.create(newBorrow);

  }

  /**
   * Punto 2: listar prestamos de un usuario
   * @param userIdentification
   * @return
   *
   * Qualification: 1 unit tests associated with this method in BorrrowServiceTest
   */
  public List<Borrow> getBorrrowsByUser(String userIdentification) {
    String queryStr = "SELECT p FROM Borrow p where p.user.identification = :userIdentification";
    Query query = em.createQuery(queryStr);
    query.setParameter("userIdentification", userIdentification);

    return query.getResultList();
  }

}
