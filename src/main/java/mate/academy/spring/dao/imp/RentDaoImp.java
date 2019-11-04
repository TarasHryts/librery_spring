package mate.academy.spring.dao.imp;

import java.util.List;
import javax.persistence.TypedQuery;
import mate.academy.spring.dao.RentDao;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
        TypedQuery<Rent> query = sessionFactory
                .getCurrentSession()
                .createQuery("FROM Rent", Rent.class);
        return query.getResultList();
    }

    @Override
    public Rent returnBook(User user, Book book) {
        TypedQuery<Rent> query = sessionFactory
                .getCurrentSession()
                .createQuery("FROM Rent WHERE user=:user AND book=:book AND active=:active",
                        Rent.class);
        query.setParameter("user", user);
        query.setParameter("book", book);
        query.setParameter("active", true);
        Rent rent = query.getResultList().stream().findFirst().get();
        rent.setActive(false);
        sessionFactory.getCurrentSession().update(rent);
        return rent;
    }

    @Override
    public List<Book> getBooksByUser(User user) {
        Query<Book> query = sessionFactory
                .getCurrentSession()
                .createQuery("SELECT rent.book FROM Rent rent "
                        + "WHERE rent.user=:user and rent.active=:active", Book.class);
        query.setParameter("user", user);
        query.setParameter("active", true);
        List<Book> books = query.getResultList();
        return books;
    }
}
