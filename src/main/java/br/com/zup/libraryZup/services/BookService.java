package br.com.zup.libraryZup.services;

import br.com.zup.libraryZup.controllers.models.Book;
import br.com.zup.libraryZup.repository.BookRepository;
import br.com.zup.libraryZup.services.mappers.exceptions.BookNotFoundException;
import br.com.zup.libraryZup.services.mappers.exceptions.InvalidBookException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private static final int MAX_AUTHORS = 5;
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public Book save(Book book) {
        validateAuthors(book);
        return bookRepository.save(book);
    }


    public List<Book> findAll() {
        return bookRepository.findAll();
    }


    public Book findBook(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Livro com ID " + id + " não encontrado."));
    }


    public Book updateBook(Book book) {
        // Garante que o livro existe antes de atualizar.
        Book existingBook = findBook(book.getId());
        validateAuthors(book);

        // Atualiza os dados do livro existente.
        existingBook.setTitle(book.getTitle());
        existingBook.setDescription(book.getDescription());
        existingBook.setAuthors(book.getAuthors());

        return bookRepository.save(existingBook);
    }


    public void deleteBook(Long id) {
        Book book = findBook(id);
        bookRepository.delete(book);
    }


    private void validateAuthors(Book book) {
        if (book.getAuthors() != null && book.getAuthors().size() > MAX_AUTHORS) {
            throw new InvalidBookException("Um livro não pode ter mais de " + MAX_AUTHORS + " autores.");
        }
    }
}
