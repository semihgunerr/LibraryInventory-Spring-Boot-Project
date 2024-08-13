package library.librarymanagement.controller;

import library.librarymanagement.dto.AuthorDetailsRequest;
import library.librarymanagement.entity.Author;
import library.librarymanagement.entity.Book;
import library.librarymanagement.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/addauthor")
    public ResponseEntity<Author> addAuthor(@RequestBody AuthorDetailsRequest authorDetailsRequest) {
        try {
            Author author = authorService.addAuthor(authorDetailsRequest);
            return ResponseEntity.ok(author);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        try {
            Optional<Author> author = authorService.getAuthorById(id);
            if (author.isPresent()) {
                Author a = author.get();
                return ResponseEntity.ok(a);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        try {
            List<Author> authors = authorService.getAllAuthors();
            return ResponseEntity.ok(authors);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody AuthorDetailsRequest authorDetailsRequest) {
        try {
            Optional<Author> author = authorService.getAuthorById(id);
            if (author.isPresent()) {
                Author existingAuthor = author.get();
                existingAuthor.setName(authorDetailsRequest.getName());
                existingAuthor.setDateOfBirth(authorDetailsRequest.getDateOfBirth());
                return ResponseEntity.ok(authorService.saveAuthor(existingAuthor));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        try {
            boolean isDeleted = authorService.deleteAuthor(id);
            return isDeleted ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}/books")
    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable Long id) {
        try {
            Optional<Author> author = authorService.getAuthorById(id);
            if (author.isPresent()) {
                return ResponseEntity.ok(List.copyOf(author.get().getBooks()));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}