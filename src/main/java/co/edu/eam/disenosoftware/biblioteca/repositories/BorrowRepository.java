package co.edu.eam.disenosoftware.biblioteca.repositories;

import co.edu.eam.disenosoftware.biblioteca.model.entities.Borrow;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class BorrowRepository {

  @PersistenceContext
  private EntityManager em;

  /**
   * Consulta 2: Préstamos de un usuario
   *
   * @param userIdentification
   * @return
   */
  public List<Borrow> getBorrowsByUserId(String userIdentification) {


    String queryStr="SELECT borrow FROM Borrow WHERE Borrow.User.user_Identification =:userIdentification";
    Query query=em.createQuery(queryStr);
    query.setParameter("userIdentification", userIdentification);

    return query.getResultList();

  }



  /**
   * Consutla 4: Préstamos de un libro
   *
   * @param bookCode
   * @return
   */
  public List<Borrow> getBorrowsByBookId(String bookCode) {

    String queryStr="Select borrow FROM Borrow WHERE borrow.Book.codigo_Libro= :bookCode";
    Query query=em.createQuery(queryStr);
    query.setParameter("bookCode", bookCode);

    return query.getResultList();
  }

}
