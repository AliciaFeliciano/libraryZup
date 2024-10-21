package br.com.zup.libraryZup.services.mappers;

import br.com.zup.libraryZup.controllers.dtos.BookRegisterDTO;
import br.com.zup.libraryZup.controllers.dtos.BookUpdateDTO;
import br.com.zup.libraryZup.controllers.models.Book;

public class BookMapper {

    public static Book fromBookRegisterDTO(BookRegisterDTO bookRegisterDTO) {
        Book book = new Book();
        book.setTitle(bookRegisterDTO.getTitle());
        book.setDescription(bookRegisterDTO.getDescription());

        return book;
    }

    public static Book fromBookUpdate(BookUpdateDTO bookUpdateDTO) {
        Book book = new Book();
        book.setTitle(bookUpdateDTO.getTitle());
        book.setDescription(bookUpdateDTO.getDescription());
        return book;
    }
}
