package library.librarymanagement.service;


import library.librarymanagement.dto.AuthorDetailsRequest;
import library.librarymanagement.entity.Author;
import library.librarymanagement.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author addAuthor(AuthorDetailsRequest request) {
        Author author = new Author();
        author.setName(request.getName());
        author.setDateOfBirth(request.getDateOfBirth());
        return authorRepository.save(author);
    }

    public boolean deleteAuthor(Long id) {
        if (authorRepository.existsById(id)) {
            authorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author saveAuthor(Author existingAuthor) {
        return authorRepository.save(existingAuthor);
    }
}