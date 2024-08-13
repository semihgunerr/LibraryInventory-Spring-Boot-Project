package library.librarymanagement.repository;

import library.librarymanagement.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findById(Long id);
}
