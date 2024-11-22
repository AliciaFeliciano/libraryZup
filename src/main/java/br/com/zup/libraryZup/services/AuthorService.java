package br.com.zup.libraryZup.services;

import br.com.zup.libraryZup.controllers.models.Author;
import br.com.zup.libraryZup.repository.AuthorRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import br.com.zup.libraryZup.services.mappers.exceptions.InvalidBookException;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author save(@Valid Author author) {
        return authorRepository.save(author);
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author findAuthor(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException("Autor com ID " + id + " não encontrado."));
    }

    public Author updateAuthor(@Valid Author author) {
        Author existingAuthor = findAuthor(author.getId());

        existingAuthor.setFirstName(author.getFirstName());
        existingAuthor.setLastName(author.getLastName());
        existingAuthor.setYearOfBirth(author.getYearOfBirth());
        existingAuthor.setYearOfDeath(author.getYearOfDeath());
        existingAuthor.setBooks(author.getBooks());

        return authorRepository.save(existingAuthor);
    }

    public void deleteAuthor(Long id) {
        Author author = findAuthor(id);
        authorRepository.delete(author);
    }
}
