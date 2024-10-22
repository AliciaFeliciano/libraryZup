package br.com.zup.libraryZup.controllers.dtos;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public class AuthorUpdateDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 20)
    private String firstName;

    @NotBlank
    @Size(min = 3, max = 20)
    private String lastName;

    @NotBlank
    private int yearOfBirth;

    private int yearOfDeath;

    @NotBlank
    private List<Long> bookIds;

    public AuthorUpdateDTO() {}

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public @NotBlank @Size(min = 3, max = 20) String getFirstName() {return firstName;}

    public void setFirstName(@NotBlank @Size(min = 3, max = 20) String firstName) {this.firstName = firstName;}

    public @NotBlank @Size(min = 3, max = 20) String getLastName() {return lastName;}

    public void setLastName(@NotBlank @Size(min = 3, max = 20) String lastName) {this.lastName = lastName;}

    @NotBlank
    public int getYearOfBirth() {return yearOfBirth;}

    public void setYearOfBirth(@NotBlank int yearOfBirth) {this.yearOfBirth = yearOfBirth;}

    public int getYearOfDeath() {return yearOfDeath;}

    public void setYearOfDeath(int yearOfDeath) {this.yearOfDeath = yearOfDeath;}

    public @NotBlank List<Long> getBookIds() {return bookIds;}

    public void setBookIds(@NotBlank List<Long> bookIds) {this.bookIds = bookIds;}
}
