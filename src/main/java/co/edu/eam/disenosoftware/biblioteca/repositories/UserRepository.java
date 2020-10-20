package co.edu.eam.disenosoftware.biblioteca.repositories;

import co.edu.eam.disenosoftware.biblioteca.model.entities.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class UserRepository {

  @PersistenceContext
  private EntityManager em;

  public User find(String user) {
    return em.find(User.class, user);
  }
}
