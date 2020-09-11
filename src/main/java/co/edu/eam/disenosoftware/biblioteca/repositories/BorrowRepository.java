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
   * @return List getBorrowsByUserId
   */
  public List<Borrow> getBorrowsByUserId(String userIdentification) {
    String queryStr = "SELECT p FROM Borrow p WHERE p.usuario.id = :value";
    Query query = em.createQuery(queryStr);
    query.setParameter("value", userIdentification);

    return query.getResultList();
  }

  /**
   * Consutla 4: Préstamos de un libro
   *
   * @param bookCode
   * @return List getBorrowsByBookId
   */
  public List<Borrow> getBorrowsByBookId(String bookCode) {
    String queryStr = "SELECT l FROM Borrow l WHERE l.libro.id = :value";
    Query query = em.createQuery(queryStr);
    query.setParameter("value", bookCode);

    return query.getResultList();
  }

}
