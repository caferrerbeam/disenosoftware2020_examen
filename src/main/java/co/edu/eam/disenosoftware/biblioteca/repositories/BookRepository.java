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
   * @return
   */
  public List<Book> getBooksByEditorialId(Long codePublisher) {
    String quertyStr = "SEELECT book FROM Book book WHERE book.publisher.code = :value";
    Query query = em.createQuery(quertyStr);
    query.setParameter("value", codePublisher);
    return query.getResultList();
  }

  /**
   * Consulta 3: Libros de un autor
   *
   * @param authId
   * @return
   */
  public List<Book> getBooksByAuthorId(Long authId) {
    //tengo duda
    String quertyStr = "SELECT bookAuthor FROM BookAuthor bookAuthor WHERE bookAuthor.author.id = :value";
    Query query = em.createQuery(quertyStr);
    query.setParameter("value", authId);
    return query.getResultList();
  }

}
