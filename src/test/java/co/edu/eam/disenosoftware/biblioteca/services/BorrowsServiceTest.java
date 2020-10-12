package co.edu.eam.disenosoftware.biblioteca.services;

import co.edu.eam.disenosoftware.biblioteca.exceptions.BusinessException;
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

@SpringBootTest
@Transactional
public class BorrowsServiceTest {

  @Autowired
  private BorrowService borrowService;

  @PersistenceContext
  private EntityManager em;

  @Test
  @Sql({"/testdata/borrowBookOkTest.sql"})
  public void testBorrowBookOk() throws Exception {
    borrowService.borrowBook("1", "1");

    List<Borrow> borrows = em.createQuery("SELECT p FROM Borrow p where p.user.identification = :coUser")
            .setParameter("coUser", "1")
            .getResultList();

    Assertions.assertEquals(1, borrows.size());
    Assertions.assertEquals("1", borrows.get(0).getBook().getCode());
  }

  @Test
  @Sql({"/testdata/borrowRepeatedBookTest.sql"})
  public void borrowRepeatedBookTest() throws Exception {
    BusinessException exc = Assertions.assertThrows(BusinessException.class,
            () ->borrowService.borrowBook("1", "1"));

    Assertions.assertEquals("0003",exc.getCode().getCode());
  }

  @Test
  @Sql({"/testdata/borrowsMaximunBooksByUserIdTest.sql"})
  public void borrowsMaximunBooksByUserIdTest() throws Exception {
    BusinessException exc = Assertions.assertThrows(BusinessException.class,
            () ->borrowService.borrowBook("4", "1"));

    Assertions.assertEquals("0004",exc.getCode().getCode());
  }

  @Test
  @Sql({"/testdata/borrowNotFoundUserTest.sql"})
  public void borrowsNotFoundUserTest() throws Exception {
    BusinessException exc = Assertions.assertThrows(BusinessException.class,
            () ->borrowService.borrowBook("1", "2"));

    Assertions.assertEquals("0001",exc.getCode().getCode());
  }

  @Test
  @Sql({"/testdata/borrowNotFoundBookTest.sql"})
  public void borrowNotFoundBookTest() throws Exception {
    BusinessException exc = Assertions.assertThrows(BusinessException.class,
            () ->borrowService.borrowBook("1", "1"));

    Assertions.assertEquals("0002",exc.getCode().getCode());
  }

  @Test
  @Sql({"/testdata/getBorrowsByUserIdTest.sql"})
  public void getBorrowsByUserIdTest() throws Exception {
    List<Borrow> borrows = borrowService.getBorrrowsByUser("1");
    Assertions.assertEquals(2, borrows.size());
  }

}
