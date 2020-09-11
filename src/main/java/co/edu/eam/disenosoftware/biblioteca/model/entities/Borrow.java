package co.edu.eam.disenosoftware.biblioteca.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "prestamo")
public class Borrow {

  @Id
  private Long id;

  private Date dateTime;

  @ManyToOne
  @JoinColumn(name = "id_libro", referencedColumnName = "id")
  private Book libro;

  @ManyToOne
  @JoinColumn(name = "id_usuario", referencedColumnName = "id")
  private User usuario;

}
