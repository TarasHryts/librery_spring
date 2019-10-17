package mate.academy.spring.service;

import java.util.List;
import mate.academy.spring.entity.Author;

public interface AuthorService {
    void add(Author author);

    List<Author> listAuthor();

    List<Author> findByName(String name);

    List<Author> findByNameAndSurname(String name, String surname);
}
