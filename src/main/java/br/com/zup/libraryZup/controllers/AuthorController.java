package br.com.zup.libraryZup.controllers;

import br.com.zup.libraryZup.controllers.dtos.AuthorRegisterDTO;
import br.com.zup.libraryZup.controllers.dtos.AuthorUpdateDTO;
import br.com.zup.libraryZup.controllers.models.Author;
import br.com.zup.libraryZup.services.AuthorService;
import br.com.zup.libraryZup.services.mappers.AuthorMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author registerAuthor(@RequestBody @Valid AuthorRegisterDTO authorRegisterDTO) {
        Author author = AuthorMapper.fromAuthorRegisterDTO(authorRegisterDTO);
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
        return authorService.updateAuthor(AuthorMapper.fromAuthorUpdate(authorUpdateDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }
}

