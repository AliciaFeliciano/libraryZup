package br.com.zup.libraryZup.controllers.dtos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public class BookUpdateDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2)
    private String title;
    @NotBlank
    private String description;
    @NotBlank
    private List<Long> authorIds;

    public BookUpdateDTO() {}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public @NotBlank List<Long> getAuthorIds() {return authorIds;}

    public void setAuthorIds(@NotBlank List<Long> authorIds) {this.authorIds = authorIds;}
}
