package br.com.zup.libraryZup.repository;

import br.com.zup.libraryZup.controllers.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
