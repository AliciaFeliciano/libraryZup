package br.com.zup.libraryZup.services;

import br.com.zup.libraryZup.controllers.models.Author;
import br.com.zup.libraryZup.repository.AuthorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author findAuthor(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Author not found"));
    }

    public Author updateAuthor(Author author) {
        Author authorDB = findAuthor(author.getId());

        if (!authorDB.getId().equals(author.getId())) {
            if(authorRepository.existsById(author.getId())) {
                throw new IllegalArgumentException("An author with this ID already exists");
            }
            authorDB.setId(author.getId());
        }

        authorDB.setFirstName(author.getFirstName());
        authorDB.setLastName(author.getLastName());
        authorDB.setYearOfBirth(author.getYearOfBirth());
        authorDB.setYearOfDeath(author.getYearOfDeath());

        return authorRepository.save(authorDB);
    }

    public void deleteAuthor(Long id) {
        Author author = findAuthor(id);
        authorRepository.deleteById(author.getId());
    }
}
