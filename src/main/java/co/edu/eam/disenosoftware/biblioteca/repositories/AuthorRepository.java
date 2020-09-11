package co.edu.eam.disenosoftware.biblioteca.repositories;

import co.edu.eam.disenosoftware.biblioteca.model.entities.Author;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class AuthorRepository {

  @PersistenceContext
  private EntityManager em;

  /**
   * Consulta 5: Autores de un libro
   *
   * @param bookCode
   * @return
   */
  public List<Author> getBookAuthors(String bookCode) {
    String quertyStr = "SELECT bookAuthor FROM BookAuthor bookAuthor WHERE bookAuthor.book.code = :value";
    Query query = em.createQuery(quertyStr);
    query.setParameter("value", bookCode);
    return query.getResultList();
  }
}
