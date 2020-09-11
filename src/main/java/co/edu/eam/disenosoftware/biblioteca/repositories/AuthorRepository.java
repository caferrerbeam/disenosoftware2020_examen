package co.edu.eam.disenosoftware.biblioteca.repositories;

import co.edu.eam.disenosoftware.biblioteca.model.entities.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class AuthorRepository {

  @PersistenceContext
  private EntityManager em;

  public List<Author> getBookAuthors(String bookCode){

    String queryStr = "SELECT auth.author FROM BookAuthor auth WHERE auth.book.code = :bookId";

    return em.createQuery(queryStr).setParameter("bookId", bookCode)
            .getResultList();

  }
}
