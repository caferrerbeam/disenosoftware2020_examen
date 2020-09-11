package co.edu.eam.disenosoftware.biblioteca.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "prestamo")
public class Borrow implements Serializable {

  @Id
  private Long id;

  @Column(name = "fecha_prestamo")
  private Date dateTime;

  @ManyToOne
  @JoinColumn(name = "id_libro", referencedColumnName = "id")
  private Book book;

  @ManyToOne
  @JoinColumn(name = "id_usuario", referencedColumnName = "id")
  private User user;

  public Borrow() {
  }
}
