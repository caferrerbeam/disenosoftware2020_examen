package co.edu.eam.disenosoftware.biblioteca.model.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "libro")
public class Book implements Serializable {

  @Id
  @Column(name = "codigo_libro")
  private String code;

  @Column(name = "nombreLibro")
  private String name;

  @Column(name = "isbn_libro")
  private String isbn;

  @OneToMany(mappedBy = "book")
  @JsonManagedReference
  private List<BookAuthor> authors;

  @ManyToOne
  @JoinColumn(name = "id_editorial", referencedColumnName = "codigo_editorial")
  private Publisher publisher;

  public Book() {
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public List<BookAuthor> getAuthors() {
    return authors;
  }

  public void setAuthors(List<BookAuthor> authors) {
    this.authors = authors;
  }

  public Publisher getPublisher() {
    return publisher;
  }

  public void setPublisher(Publisher publisher) {
    this.publisher = publisher;
  }
}
