package co.edu.eam.disenosoftware.biblioteca.repositories;

import co.edu.eam.disenosoftware.biblioteca.model.entities.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@SpringBootTest
public class BookRepositoryTest {

  @Autowired
  private BookRepository bookRepository;

  @PersistenceContext
  private EntityManager em;

  //@Test
  @Sql({"/testdata/getBooksByEditorialIdTest.sql"})
  public void getBooksByEditorialIdTest() {
    List<Book> books = bookRepository.getBooksByEditorialId(1L);
    Assertions.assertEquals(3, books.size());
  }

  //@Test
  @Sql({"/testdata/getBooksByAuthorIdTest.sql"})
  public void getBooksByAuthorIdTest() {
    List<Book> books = bookRepository.getBooksByAuthorId(1L);
    Assertions.assertEquals(3, books.size());
  }
}
