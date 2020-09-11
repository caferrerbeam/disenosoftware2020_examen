package co.edu.eam.disenosoftware.biblioteca.repositories;

import co.edu.eam.disenosoftware.biblioteca.model.entities.Author;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@SpringBootTest
public class AuthorRepositoryTest {

  @Autowired
  private AuthorRepository authorRepository;

  @PersistenceContext
  private EntityManager em;

  @Test
  @Sql({"/testdata/getBookAuthorsTest.sql"})
  public void getBookAuthorsTest() {
    List<Author> authors = authorRepository.getBookAuthors("1");
    Assertions.assertEquals(2, authors.size());
  }
}
