package co.edu.eam.disenosoftware.biblioteca.repositories;

import co.edu.eam.disenosoftware.biblioteca.model.entities.Author;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
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

    String queryStr = "SELECT a FROM BookAuthor a WHERE a.book.code = :bookCode ";
    Query query = em.createQuery(queryStr);
    query.setParameter("bookCode", bookCode);

    return query.getResultList();
  }
}
