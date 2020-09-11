package co.edu.eam.disenosoftware.biblioteca.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "libro_autor")
public class BookAuthor {

  @Id
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_autor", referencedColumnName = "id")
  private Author autor;

  @ManyToOne
  @JoinColumn(name = "id_libro", referencedColumnName = "id")
  private Book libro;

}
