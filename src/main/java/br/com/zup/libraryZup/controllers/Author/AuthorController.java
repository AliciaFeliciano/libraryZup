package br.com.zup.libraryZup.controllers.Author;

import br.com.zup.libraryZup.controllers.Author.dtos.AuthorRegisterDTO;
import br.com.zup.libraryZup.controllers.Author.dtos.AuthorUpdateDTO;
import br.com.zup.libraryZup.controllers.models.Author;
import br.com.zup.libraryZup.repository.BookRepository;
import br.com.zup.libraryZup.services.AuthorService;
import br.com.zup.libraryZup.services.mappers.AuthorMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public AuthorRegisterDTO registerAuthor(@RequestBody @Valid AuthorRegisterDTO authorRegisterDTO) {
        Author author = AuthorMapper.fromAuthorRegister(authorRegisterDTO, bookRepository);
        Author savedAuthor = authorService.save(author);
        return AuthorMapper.toRegisterDTO(savedAuthor);
    }

    @GetMapping
    public List<AuthorRegisterDTO> listAuthors() {
        return authorService.findAll().stream()
                .map(AuthorMapper::toRegisterDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AuthorRegisterDTO findAuthorById(@PathVariable Long id) {
        Author author = authorService.findAuthor(id);
        return AuthorMapper.toRegisterDTO(author);
    }

    @PutMapping("/{id}")
    public AuthorUpdateDTO updateAuthor(@PathVariable Long id, @RequestBody @Valid AuthorUpdateDTO authorUpdateDTO) {
        authorUpdateDTO.setId(id);
        Author updatedAuthor = AuthorMapper.fromAuthorUpdate(authorUpdateDTO, bookRepository);
        Author savedAuthor = authorService.updateAuthor(updatedAuthor);
        return AuthorMapper.toUpdateDTO(savedAuthor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }
}
