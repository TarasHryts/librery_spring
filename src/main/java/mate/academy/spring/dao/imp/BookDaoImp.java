package mate.academy.spring.dao.imp;

import java.util.List;
import javax.persistence.TypedQuery;
import mate.academy.spring.dao.BookDao;
import mate.academy.spring.entity.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BookDaoImp implements BookDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public void add(Book book) {
        sessionFactory.getCurrentSession().save(book);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> listBooks() {
        @SuppressWarnings("unchecked")
        TypedQuery<Book> query = sessionFactory.getCurrentSession().createQuery("from Book");
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> findByTitle(String title) {
        @SuppressWarnings("unchecked")
        TypedQuery<Book> query = sessionFactory
                .getCurrentSession().createQuery("from Book where title=:title");
        query.setParameter("title", title);
        return query.getResultList();
    }
}
