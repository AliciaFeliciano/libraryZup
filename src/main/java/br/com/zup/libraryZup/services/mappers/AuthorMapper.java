package br.com.zup.libraryZup.services.mappers;

import br.com.zup.libraryZup.controllers.dtos.AuthorRegisterDTO;
import br.com.zup.libraryZup.controllers.dtos.AuthorUpdateDTO;
import br.com.zup.libraryZup.controllers.models.Author;

public class AuthorMapper {
    public static Author fromAuthorRegisterDTO(AuthorRegisterDTO authorRegisterDTO) {
        Author author = new Author();
        author.setFirstName(authorRegisterDTO.getFirstName());
        author.setLastName(authorRegisterDTO.getLastName());
        author.setYearOfBirth(authorRegisterDTO.getYearOfBirth());
        author.setYearOfDeath(authorRegisterDTO.getYearOfDeath());
        return author;
    }

    public static Author fromAuthorUpdate(AuthorUpdateDTO authorUpdateDTO) {
        Author author = new Author();
        author.setId(authorUpdateDTO.getId());
        author.setFirstName(authorUpdateDTO.getFirstName());
        author.setLastName(authorUpdateDTO.getLastName());
        author.setYearOfBirth(authorUpdateDTO.getYearOfBirth());
        author.setYearOfDeath(authorUpdateDTO.getYearOfDeath());
        return author;
    }
}
