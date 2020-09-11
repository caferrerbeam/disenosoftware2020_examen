package co.edu.eam.disenosoftware.biblioteca.model.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class User {

  @Id
  private String identification;

  private String name;

  private String lastName;

}
