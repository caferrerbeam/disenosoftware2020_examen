package co.edu.eam.disenosoftware.biblioteca.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "fechaPrestamo")
  private Date dateTime;

  @ManyToOne
  @JoinColumn(name = "id_libro", referencedColumnName = "codigo_libro")
  private Book book;

  @ManyToOne
  @JoinColumn(name = "id_usuario", referencedColumnName = "user_identification")
  private User user;

  public Borrow(Date dateTime, Book book, User user) {
    this.dateTime = dateTime;
    this.book = book;
    this.user = user;
  }

  public Borrow() {
    dateTime = new Date();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getDateTime() {
    return dateTime;
  }

  public void setDateTime(Date dateTime) {
    this.dateTime = dateTime;
  }

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
