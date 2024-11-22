package br.com.zup.libraryZup.controllers.Book;

import br.com.zup.libraryZup.controllers.Book.dtos.BookRegisterDTO;
import br.com.zup.libraryZup.controllers.Book.dtos.BookUpdateDTO;
import br.com.zup.libraryZup.controllers.models.Book;
import br.com.zup.libraryZup.repository.AuthorRepository;
import br.com.zup.libraryZup.services.BookService;
import br.com.zup.libraryZup.services.mappers.BookMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public BookRegisterDTO registerBook(@RequestBody @Valid BookRegisterDTO bookRegisterDTO) {
        Book book = BookMapper.fromBookRegister(bookRegisterDTO, authorRepository);
        Book savedBook = bookService.save(book);
        return BookMapper.toRegisterDTO(savedBook);
    }

    @GetMapping
    public List<BookRegisterDTO> listBooks() {
        return bookService.findAll().stream()
                .map(BookMapper::toRegisterDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BookRegisterDTO findBookById(@PathVariable Long id) {
        Book book = bookService.findBook(id);
        return BookMapper.toRegisterDTO(book);
    }

    @PutMapping("/{id}")
    public BookUpdateDTO updateBook(@PathVariable Long id, @RequestBody @Valid BookUpdateDTO bookUpdateDTO) {
        bookUpdateDTO.setId(id);
        Book updatedBook = BookMapper.fromBookUpdate(bookUpdateDTO, authorRepository);
        Book savedBook = bookService.updateBook(updatedBook);
        return BookMapper.toUpdateDTO(savedBook);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
