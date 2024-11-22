package br.com.zup.libraryZup.repository;

import br.com.zup.libraryZup.controllers.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
