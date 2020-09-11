package co.edu.eam.disenosoftware.biblioteca.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class User {

  @Id
  @Column(name = "user_identification")
  private String identification;

  @Column(name = "nombre_usuario")
  private String name;

  @Column(name = "apellido_usuario")
  private String lastName;

}
