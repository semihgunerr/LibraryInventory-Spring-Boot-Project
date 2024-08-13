package library.librarymanagement.service;

import library.librarymanagement.dto.BookDetailsRequest;
import library.librarymanagement.entity.Author;
import library.librarymanagement.entity.Book;
import library.librarymanagement.repository.AuthorRepository;
import library.librarymanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Book addBook(BookDetailsRequest request) {
        Optional<Author> author = authorRepository.findById(request.getAuthorId());
        if (author.isEmpty()) {
            throw new RuntimeException("Author not found");
        }
        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setPublishedYear(request.getPublishedYear());
        book.setAuthor(author.get());

        return bookRepository.save(book);
    }

    public boolean deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Book> getBook(Long id) {
        return bookRepository.findById(id);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book updateBook(Long id, BookDetailsRequest request) {
        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            Book book = existingBook.get();
            book.setTitle(request.getTitle());
            book.setPublishedYear(request.getPublishedYear());

            Optional<Author> author = authorRepository.findById(request.getAuthorId());
            author.ifPresent(book::setAuthor);

            return bookRepository.save(book);
        }
        throw new RuntimeException("Book not found");
    }
}