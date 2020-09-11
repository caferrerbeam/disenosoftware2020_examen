package co.edu.eam.disenosoftware.biblioteca.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "autores")
public class Author implements Serializable {

  @Id
  @Column(name = "codigo_autor")
  private Long id;

  @Column(name = "apellido")
  private String lastName;

  @Column(name = "nombre")
  private String name;

  public Author() {
  }
}
