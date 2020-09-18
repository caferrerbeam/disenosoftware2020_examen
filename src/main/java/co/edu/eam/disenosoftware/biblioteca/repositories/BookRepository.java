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
    String queryStr = "SELECT b FROM Book b where b.publisher.code = :coPublisher";
    Query query = em.createQuery(queryStr);
    query.setParameter("coPublisher", codePublisher);

    return query.getResultList();
  }

  /**
   * Consulta 3: Libros de un autor
   *
   * @param authId
   * @return
   */
  public List<Book> getBooksByAuthorId(Long authId) {
    String queryStr = "SELECT b FROM BookAuthor b where b.author.id = :coAuthor";
    Query query = em.createQuery(queryStr);
    query.setParameter("coAuthor", authId);

    return query.getResultList();
  }

}
