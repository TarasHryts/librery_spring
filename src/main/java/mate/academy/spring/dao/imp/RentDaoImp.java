package mate.academy.spring.dao.imp;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.TypedQuery;
import mate.academy.spring.dao.RentDao;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RentDaoImp implements RentDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Rent add(Rent rent) {
        sessionFactory.getCurrentSession().save(rent);
        return rent;
    }

    @Override
    public List<Rent> listRents() {
        TypedQuery<Rent> query = sessionFactory.getCurrentSession().createQuery("FROM Rent", Rent.class);
        return query.getResultList();
    }

    @Override
    public Rent returnBook(User user, Book book) {
        TypedQuery<Rent> query = sessionFactory
                .getCurrentSession()
                .createQuery("FROM Rent WHERE user LIKE CONCAT ('%', :user,'%') " +
                        "AND book LIKE CONCAT ('%', :book,'%')", Rent.class);
        query.setParameter("user", user);
        query.setParameter("book", book);
        Rent rent = query.getSingleResult();
        rent.setActive(false);
        sessionFactory.getCurrentSession().update(rent);
        return rent;
    }

    @Override
    public List<Book> getBooksByUser(User user) {
        TypedQuery<Rent> query = sessionFactory
                .getCurrentSession()
                .createQuery("FROM Rent WHERE user LIKE CONCAT ('%', :user,'%')", Rent.class);
        query.setParameter("user", user);
        List<Book> books = query.getResultList().stream()
                .map(x -> x.getBook())
                .collect(Collectors.toList());
        return books;
    }
}
