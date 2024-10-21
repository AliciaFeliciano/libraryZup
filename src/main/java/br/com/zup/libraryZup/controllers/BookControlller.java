package br.com.zup.libraryZup.controllers;

import br.com.zup.libraryZup.controllers.dtos.BookRegisterDTO;
import br.com.zup.libraryZup.controllers.dtos.BookUpdateDTO;
import br.com.zup.libraryZup.controllers.models.Book;
import br.com.zup.libraryZup.services.BookService;
import br.com.zup.libraryZup.services.mappers.BookMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookControlller {

    @Autowired
    private BookService bookService;
    private BookMapper bookMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book BookRegister(@RequestBody @Valid BookRegisterDTO bookRegisterDTO) {
        Book book= BookMapper.fromBookRegisterDTO(bookRegisterDTO);
        return bookService.save(book);
    }

    @GetMapping
    public List<Book> BookList() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book findBookById(@PathVariable Long id) {
        return bookService.findBook(id);
    }

    @PutMapping("/{id}")
    public Book updateJogador(@PathVariable Long id, @RequestBody @Valid BookUpdateDTO bookUpdateDTO) {
        return bookService.updateBook(BookMapper.fromBookUpdate(bookUpdateDTO));
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

}
