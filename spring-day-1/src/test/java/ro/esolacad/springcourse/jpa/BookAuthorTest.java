package ro.esolacad.springcourse.jpa;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import ro.esolacad.springcourse.jpa.manyTomany.*;

@SpringBootTest
public class BookAuthorTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookAuthorService bookAuthorService;

//    @Autowired
//    private BookAuthorRepository bookAuthorRepository;
//
//    @Test
//    public void testSaveAuthorAndBook() {
//        Book book = new Book(null, "War and Peace");
//
//        Book savedBook = bookRepository.save(book);
//
//        Author author = new Author(null, "Tolstoy");
//        Author author2 = new Author(null, "Kafka");
//
////        authorRepository.saveAll(Arrays.asList(author, author2));
//
//        Author savedAuthor = authorRepository.save(author);
//        Author savedAuthor2 = authorRepository.save(author2);
//
//
//        BookAuthor bookAuthor = new BookAuthor(null, savedBook, savedAuthor);
//        BookAuthor bookAuthor2 = new BookAuthor(null, savedBook, savedAuthor2);
//
//        bookAuthorRepository.save(bookAuthor);
//        bookAuthorRepository.save(bookAuthor2);
//
//        System.out.println(bookAuthorRepository.findAll());
//    }

    @Test
    @Disabled
    public void testManyToManyAnnotation() {
        Author author = new Author(null, "Tolstoy");
        Author author2 = new Author(null, "Kafka");

        List<Author> authors = authorRepository.saveAll(Arrays.asList(author, author2));

        Book book = new Book(null, "War and Peace", new HashSet<>(authors));

        Book save = bookRepository.save(book);

        Optional<Book> byId = bookRepository.findById(save.getId());

        System.out.println(byId);
    }

    @Test
    public void testManyToManyAnnotationFromService() {
        try {
            bookAuthorService.testManyToManyAnnotation();
        } catch(RuntimeException re) {
            re.printStackTrace();
        }

        System.out.println(authorRepository.findAll());
    }
}












