package co.edu.eam.disenosoftware.biblioteca.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "autor")
public class Author implements Serializable {

  @Id
  private Long codigo_Autor;

  private String apellido;

  private String nombre;

  public Author() {
  }
}
