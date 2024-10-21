package br.com.zup.libraryZup.controllers.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class BookRegisterDTO {
    @NotBlank
    @Size(min = 2)
    private String title;
    @NotBlank
    private String description;

    public BookRegisterDTO(){}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

}
