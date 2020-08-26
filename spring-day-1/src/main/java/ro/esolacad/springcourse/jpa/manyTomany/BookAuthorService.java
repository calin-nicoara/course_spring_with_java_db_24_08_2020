package ro.esolacad.springcourse.jpa.manyTomany;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class BookAuthorService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public void testManyToManyAnnotation() {
        Author author = new Author(null, "Tolstoy");
        Author author2 = new Author(null, "Kafka");

        List<Author> authors = authorRepository.saveAll(Arrays.asList(author, author2));
//
//        if(true) {
//            throw new RuntimeException("Runtime exception!");
//        }

        Book book = new Book(null, "War and Peace", new HashSet<>(authors));

        Book save = bookRepository.save(book);

        Optional<Book> byId = bookRepository.findById(save.getId());

        System.out.println(byId);
    }
}
