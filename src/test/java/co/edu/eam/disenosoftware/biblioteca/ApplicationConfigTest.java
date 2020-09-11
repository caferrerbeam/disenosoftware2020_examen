package co.edu.eam.disenosoftware.biblioteca;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApplicationConfigTest {

  @Autowired
  private Flyway flyway;

  @Test
  public void migrate() {
    flyway.migrate();
  }

  @Test
  public void contextLoads() {
  }
}
