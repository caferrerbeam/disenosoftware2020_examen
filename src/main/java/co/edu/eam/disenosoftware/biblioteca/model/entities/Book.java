package co.edu.eam.disenosoftware.biblioteca.model.entities;

import ch.qos.logback.classic.db.names.ColumnName;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "libros")
public class Book implements Serializable {

  @Id
  private String codigo_Libro;


  private String nombre;

  @OneToMany(mappedBy = "book")
  private List<BookAuthor> bookAuthor;

  @ManyToOne
  @JoinColumn(name = "id_publisher" , referencedColumnName = "codigo_Editorial")
  private Publisher publisher;

  public Book() {
  }
}
