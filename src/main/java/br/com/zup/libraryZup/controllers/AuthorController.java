package br.com.zup.libraryZup.controllers;

import br.com.zup.libraryZup.controllers.dtos.AuthorRegisterDTO;
import br.com.zup.libraryZup.controllers.dtos.AuthorUpdateDTO;
import br.com.zup.libraryZup.controllers.models.Author;
import br.com.zup.libraryZup.repository.BookRepository;
import br.com.zup.libraryZup.services.AuthorService;
import br.com.zup.libraryZup.services.mappers.AuthorMapper;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;
    private final BookRepository bookRepository;

    @Autowired
    public AuthorController(AuthorService authorService, BookRepository bookRepository) {
        this.authorService = authorService;
        this.bookRepository = bookRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author registerAuthor(@RequestBody @Valid AuthorRegisterDTO authorRegisterDTO) {
        Author author = AuthorMapper.fromAuthorRegister(authorRegisterDTO, bookRepository);
        return authorService.save(author);
    }

    @GetMapping
    public List<Author> listAuthors() {
        return authorService.findAll();
    }

    @GetMapping("/{id}")
    public Author findAuthorById(@PathVariable Long id) {
        return authorService.findAuthor(id);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable Long id, @RequestBody @Valid AuthorUpdateDTO authorUpdateDTO) {
        authorUpdateDTO.setId(id);
        Author updatedAuthor = AuthorMapper.fromAuthorUpdate(authorUpdateDTO, bookRepository);
        return authorService.updateAuthor(updatedAuthor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }
}
