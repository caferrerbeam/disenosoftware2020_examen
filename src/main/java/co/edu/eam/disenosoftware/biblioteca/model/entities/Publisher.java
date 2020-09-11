package co.edu.eam.disenosoftware.biblioteca.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "editorial")
public class Publisher {

  @Id
  @Column(name = "codigo_editorial")
  private Long code;

  @Column(name = "nombre_editorial")
  private String name;

  public Publisher() {
  }
}
