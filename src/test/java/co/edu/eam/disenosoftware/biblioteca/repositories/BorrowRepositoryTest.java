package co.edu.eam.disenosoftware.biblioteca.repositories;

import co.edu.eam.disenosoftware.biblioteca.model.entities.Borrow;
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
public class BorrowRepositoryTest {

  @Autowired
  private BorrowRepository borrowRepository;

  @PersistenceContext
  private EntityManager em;

  //@Test
  @Sql({"/testdata/getBorrowsByUserIdTest.sql"})
  public void getBorrowsByUserIdTest() {
    List<Borrow> borrows = borrowRepository.getBorrowsByUserId("1");
    Assertions.assertEquals(2, borrows.size());
  }

  //@Test
  @Sql({"/testdata/getBorrowsByBookIdTest.sql"})
  public void getBorrowsByBookIdTest() {
    List<Borrow> borrows = borrowRepository.getBorrowsByBookId("1");
    Assertions.assertEquals(2, borrows.size());
  }
}
