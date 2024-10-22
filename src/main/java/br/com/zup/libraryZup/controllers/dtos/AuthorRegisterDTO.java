package br.com.zup.libraryZup.controllers.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;


public class AuthorRegisterDTO {

    @NotBlank
    @Size(min = 3, max = 20)
    private String firstName;

    @NotBlank
    @Size(min = 3, max = 20)
    private String lastName;


    private int yearOfBirth;

    private int yearOfDeath;


    private List<Long> bookIds;

    public AuthorRegisterDTO() {}

    public @NotBlank @Size(min = 3, max = 20) String getFirstName() {return firstName;}

    public void setFirstName(@NotBlank @Size(min = 3, max = 20) String firstName) {this.firstName = firstName;}

    public @NotBlank @Size(min = 3, max = 20) String getLastName() {return lastName;}

    public void setLastName(@NotBlank @Size(min = 3, max = 20) String lastName) {this.lastName = lastName;}


    public int getYearOfBirth() {return yearOfBirth;}

    public void setYearOfBirth( int yearOfBirth) {this.yearOfBirth = yearOfBirth;}

    public int getYearOfDeath() {return yearOfDeath;}

    public void setYearOfDeath(int yearOfDeath) {this.yearOfDeath = yearOfDeath;}

    public  List<Long> getBookIds() {return bookIds;}

    public void setBookIds( List<Long> bookIds) {this.bookIds = bookIds;}
}
