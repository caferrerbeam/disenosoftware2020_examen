package co.edu.eam.disenosoftware.biblioteca.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Prestamos")
public class Borrow implements Serializable {

  @Id
  private Long id;

  private Date fecha_Prestamo;

  @ManyToOne
  @JoinColumn(name="id_User", referencedColumnName = "user_identification")
  private User user;

  @ManyToOne
  @JoinColumn(name="id_Book", referencedColumnName = "codigo_Libro")
  private Book book;

  public Borrow() {
  }
}
