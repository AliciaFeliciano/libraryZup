package br.com.zup.libraryZup.repository;

import br.com.zup.libraryZup.controllers.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
