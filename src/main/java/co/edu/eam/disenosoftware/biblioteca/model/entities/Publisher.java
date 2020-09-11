package co.edu.eam.disenosoftware.biblioteca.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "editorial")
public class Publisher implements Serializable {

  @Id
  private Long codigo_Editorial;

  private String nombre_Editorial;


  public Publisher() {
  }
}
