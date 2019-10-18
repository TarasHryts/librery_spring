package mate.academy.spring.dao;

import java.util.List;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;

public interface RentDao {
    Rent add(Rent rent);

    List<Rent> listRents();

    Rent returnBook(User user, Book book);

    List<Book> getBooksByUser(User user);
}
