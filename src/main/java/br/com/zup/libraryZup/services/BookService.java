package br.com.zup.libraryZup.services;

import br.com.zup.libraryZup.controllers.models.Book;
import br.com.zup.libraryZup.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(Book book) {
       return bookRepository.save(book);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }
    public Book findBook(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado"));
    }

    public Book updateBook(Book book) {
        Book bookDB = findBook(book.getId());

        if (!bookDB.getId().equals(book.getId())) {
            if(bookRepository.existsById(book.getId())){
                throw new IllegalArgumentException("Ja existe um livro com esse id");

            }
            bookDB.setId(book.getId());
        }

        bookDB.setTitle(book.getTitle());
        bookDB.setDescription(book.getDescription());

        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        Book book = findBook(id);
        bookRepository.deleteById(book.getId());
    }
}
