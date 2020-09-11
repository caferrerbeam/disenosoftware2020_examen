package co.edu.eam.disenosoftware.biblioteca.repositories;

import co.edu.eam.disenosoftware.biblioteca.model.entities.Book;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class BookRepository {

  @PersistenceContext
  private EntityManager em;

  /**
   * Consulta 1: libros por una editorial
   *
   * @param codePublisher
   * @return List getBooksByEditorialId
   */
  public List<Book> getBooksByEditorialId(Long codePublisher) {
    String queryStr = "SELECT libro FROM Book libro WHERE libro.editorial.id = :value";
    Query query = em.createQuery(queryStr);
    query.setParameter("value", codePublisher);

    return query.getResultList();
  }

  /**
   * Consulta 3: Libros de un autor
   *
   * @param authId
   * @return List getBooksByAuthorId
   */
  public List<Book> getBooksByAuthorId(Long authId) {
    String queryStr = "SELECT l FROM Book l WHERE l.author.id = :value";
    Query query = em.createQuery(queryStr);
    query.setParameter("value", authId);

    return query.getResultList();
  }

}
