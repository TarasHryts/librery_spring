package mate.academy.spring.service.imp;

import java.time.LocalDate;
import java.util.List;
import mate.academy.spring.dao.RentDao;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RentServiceImp implements RentService {
    @Autowired
    private RentDao rentDao;

    @Transactional(readOnly = true)
    @Override
    public List<Rent> listRent() {
        return rentDao.listRents();
    }

    @Transactional
    @Override
    public Rent rentBook(User user, Book book) {
        Rent rent = new Rent(LocalDate.now(), user, book, true);
        rentDao.add(rent);
        return rent;
    }

    @Transactional
    @Override
    public Rent returnBook(User user, Book book) {
        return rentDao.returnBook(user, book);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> getBooksRentByUser(User user) {
        return rentDao.getBooksByUser(user);
    }
}
