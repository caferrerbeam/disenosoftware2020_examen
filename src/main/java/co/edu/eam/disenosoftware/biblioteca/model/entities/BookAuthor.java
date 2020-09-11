package co.edu.eam.disenosoftware.biblioteca.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "libro_autor")
public class BookAuthor implements Serializable {

  @Id
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_autor" , referencedColumnName = "codigo_autor")
  private Author author;

  @ManyToOne
  @JoinColumn(name = "id_libro" , referencedColumnName = "codigo_libro")
  private Book book;

  public BookAuthor() {
  }
}
