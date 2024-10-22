package br.com.zup.libraryZup.controllers.dtos;

import br.com.zup.libraryZup.controllers.models.Book;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;


public class AuthorRegisterDTO {

    @NotNull
    @Size(min = 3, max = 20)
    private String firstName;

    @NotNull
    @Size(min = 3, max = 20)
    private String lastName;

    @NotNull
    private int yearOfBirth;

    private int yearOfDeath;

    @NotNull
    private List<Long> bookIds;

    public AuthorRegisterDTO() {}

    public @NotNull @Size(min = 3, max = 20) String getFirstName() {return firstName;}

    public void setFirstName(@NotNull @Size(min = 3, max = 20) String firstName) {this.firstName = firstName;}

    public @NotNull @Size(min = 3, max = 20) String getLastName() {return lastName;}

    public void setLastName(@NotNull @Size(min = 3, max = 20) String lastName) {this.lastName = lastName;}

    @NotNull
    public int getYearOfBirth() {return yearOfBirth;}

    public void setYearOfBirth(@NotNull int yearOfBirth) {this.yearOfBirth = yearOfBirth;}

    public int getYearOfDeath() {
        return yearOfDeath;
    }

    public void setYearOfDeath(int yearOfDeath) {this.yearOfDeath = yearOfDeath;}

    public @NotNull List<Long> getBookIds() {return bookIds;}

    public void setBookIds(@NotNull List<Long> bookIds) {this.bookIds = bookIds;}
}

