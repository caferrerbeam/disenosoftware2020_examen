package co.edu.eam.disenosoftware.biblioteca.repositories;

import co.edu.eam.disenosoftware.biblioteca.model.entities.Book;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class BookRepository {

  @PersistenceContext
  private EntityManager em;

  /**
   * Consulta 1: libros por una editorial
   * @param codePublisher
   * @return
   */
  public List<Book> getBooksByEditorialId(Long codePublisher) {
    String queryStr = "SELECT b FROM Book b WHERE b.publisher.code = :code";

    return em.createQuery(queryStr).setParameter("code", codePublisher)
            .getResultList();
  }

  /**
   * Consulta 3: Libros de un autor
   * @param authId
   * @return
   */
  public List<Book> getBooksByAuthorId(Long authId) {
    String queryStr = "SELECT ba.book FROM BookAuthor ba WHERE ba.author.id = :authId";

    return em.createQuery(queryStr).setParameter("authId", authId)
            .getResultList();
  }

}
