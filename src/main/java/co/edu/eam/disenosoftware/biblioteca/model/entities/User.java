package co.edu.eam.disenosoftware.biblioteca.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "usuarios")
public class User implements Serializable {

  @Id
  private String user_Identification;

  private String nombre_Usuario;

  private String apellido_Usuario;

  public User() {
  }
}
