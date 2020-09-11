package co.edu.eam.disenosoftware.biblioteca.model.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "editorial")
public class Publisher {

  @Id
  private Long code;

  private String name;

  public Publisher() {
  }
}
