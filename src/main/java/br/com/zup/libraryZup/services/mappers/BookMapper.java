package br.com.zup.libraryZup.services.mappers;

import br.com.zup.libraryZup.controllers.dtos.BookRegisterDTO;
import br.com.zup.libraryZup.controllers.dtos.BookUpdateDTO;
import br.com.zup.libraryZup.controllers.models.Author;
import br.com.zup.libraryZup.controllers.models.Book;
import br.com.zup.libraryZup.repository.AuthorRepository;

import java.util.List;

public class BookMapper {

    public static Book fromBookRegister(BookRegisterDTO bookRegisterDTO, AuthorRepository authorRepository) {
        Book book = new Book();
        book.setTitle(bookRegisterDTO.getTitle());
        book.setDescription(bookRegisterDTO.getDescription());

        if (bookRegisterDTO.getAuthorIds() != null) {
            List<Author> authors = authorRepository.findAllById(bookRegisterDTO.getAuthorIds());
            book.setAuthors(authors);
        }
        return book;
    }

    public static Book fromBookUpdate(BookUpdateDTO bookUpdateDTO, AuthorRepository authorRepository) {
        Book book = new Book();
        book.setId(bookUpdateDTO.getId());
        book.setTitle(bookUpdateDTO.getTitle());
        book.setDescription(bookUpdateDTO.getDescription());

        if (bookUpdateDTO.getAuthorIds() != null) {
            List<Author> authors = authorRepository.findAllById(bookUpdateDTO.getAuthorIds());
            book.setAuthors(authors);
        }
        return book;
    }
}