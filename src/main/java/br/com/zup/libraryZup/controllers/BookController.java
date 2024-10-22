package br.com.zup.libraryZup.controllers;

import br.com.zup.libraryZup.controllers.dtos.BookRegisterDTO;
import br.com.zup.libraryZup.controllers.dtos.BookUpdateDTO;
import br.com.zup.libraryZup.controllers.models.Book;
import br.com.zup.libraryZup.repository.AuthorRepository;
import br.com.zup.libraryZup.services.BookService;
import br.com.zup.libraryZup.services.mappers.BookMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookController(BookService bookService, AuthorRepository authorRepository) {
        this.bookService = bookService;
        this.authorRepository = authorRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book registerBook(@RequestBody @Valid BookRegisterDTO bookRegisterDTO) {
        Book book = BookMapper.fromBookRegister(bookRegisterDTO, authorRepository);
        return bookService.save(book);
    }

    @GetMapping
    public List<Book> listBooks() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book findBookById(@PathVariable Long id) {
        return bookService.findBook(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody @Valid BookUpdateDTO bookUpdateDTO) {
        bookUpdateDTO.setId(id);
        Book updatedBook = BookMapper.fromBookUpdate(bookUpdateDTO, authorRepository);
        return bookService.updateBook(updatedBook);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
