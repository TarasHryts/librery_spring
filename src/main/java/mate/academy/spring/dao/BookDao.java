package mate.academy.spring.dao;

import java.util.List;
import mate.academy.spring.entity.Book;

public interface BookDao {
    void add(Book book);

    List<Book> listBooks();
}
