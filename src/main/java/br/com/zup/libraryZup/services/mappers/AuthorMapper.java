package br.com.zup.libraryZup.services.mappers;

import br.com.zup.libraryZup.controllers.dtos.AuthorRegisterDTO;
import br.com.zup.libraryZup.controllers.dtos.AuthorUpdateDTO;
import br.com.zup.libraryZup.controllers.models.Author;
import br.com.zup.libraryZup.controllers.models.Book;
import br.com.zup.libraryZup.repository.BookRepository;

import java.util.List;

public class AuthorMapper {

    public static Author fromAuthorRegister(AuthorRegisterDTO authorRegisterDTO, BookRepository bookRepository) {
        Author author = new Author();
        author.setFirstName(authorRegisterDTO.getFirstName());
        author.setLastName(authorRegisterDTO.getLastName());
        author.setYearOfBirth(authorRegisterDTO.getYearOfBirth());
        author.setYearOfDeath(authorRegisterDTO.getYearOfDeath());

        if (authorRegisterDTO.getBookIds() != null) {
            List<Book> books = bookRepository.findAllById(authorRegisterDTO.getBookIds());
            author.setBooks(books);
        }
        return author;
    }

    public static Author fromAuthorUpdate(AuthorUpdateDTO authorUpdateDTO, BookRepository bookRepository) {
        Author author = new Author();

        author.setId(authorUpdateDTO.getId());
        author.setFirstName(authorUpdateDTO.getFirstName());
        author.setLastName(authorUpdateDTO.getLastName());
        author.setYearOfBirth(authorUpdateDTO.getYearOfBirth());
        author.setYearOfDeath(authorUpdateDTO.getYearOfDeath());

        if (authorUpdateDTO.getBookIds() != null) {
            List<Book> books = bookRepository.findAllById(authorUpdateDTO.getBookIds());
            author.setBooks(books);
        }
        return author;
    }
}



