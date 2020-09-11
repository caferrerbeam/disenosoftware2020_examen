package co.edu.eam.disenosoftware.biblioteca.repositories;

import co.edu.eam.disenosoftware.biblioteca.model.entities.Borrow;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
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
    String queryStr = "SELECT p FROM Borrow p where p.user.identification = :coUser";
    Query query = em.createQuery(queryStr);
    query.setParameter("coUser", userIdentification);

    return query.getResultList();
  }

  /**
   * Consutla 4: Préstamos de un libro
   *
   * @param bookCode
   * @return
   */
  public List<Borrow> getBorrowsByBookId(String bookCode) {
    String queryStr = "SELECT p FROM Borrow p where p.book.code = :coBook";
    Query query = em.createQuery(queryStr);
    query.setParameter("coBook", bookCode);

    return query.getResultList();
  }

}
