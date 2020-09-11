package co.edu.eam.disenosoftware.biblioteca.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "libro")
public class Book {

  @Id
  private String code;

  private String name;

  private String isbn;

  @ManyToOne
  @JoinColumn(name = "id_editorial", referencedColumnName = "id")
  private Publisher editorial;

}
