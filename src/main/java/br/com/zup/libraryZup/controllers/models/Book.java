package br.com.zup.libraryZup.controllers.models;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @ManyToMany(mappedBy = "books")
    private List<Author> authors;

    public Book(){}

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public List<Author> getAuthors() {return authors;}

    public void setAuthors(List<Author> authors) {this.authors = authors;}

}