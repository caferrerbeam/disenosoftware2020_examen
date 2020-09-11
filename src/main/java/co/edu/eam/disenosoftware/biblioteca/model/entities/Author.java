package co.edu.eam.disenosoftware.biblioteca.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "autor")
public class Author {

  @Id
  @Column(name = "codigo_autor")
  private Long id;

  @Column(name = "apellido")
  private String lastName;

  @Column(name = "nombre")
  private String name;

}
