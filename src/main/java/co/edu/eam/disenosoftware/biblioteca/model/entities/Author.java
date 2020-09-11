package co.edu.eam.disenosoftware.biblioteca.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "autor")
public class Author {

  @Id
  private Long id;

  private String lastName;

  private String name;

}
