package mate.academy.spring.dao.imp;

import java.util.List;
import javax.persistence.TypedQuery;
import mate.academy.spring.dao.AuthorDao;
import mate.academy.spring.entity.Author;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorDaoImp implements AuthorDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Author author) {
        sessionFactory.getCurrentSession().save(author);
    }

    @Override
    public List<Author> listAuthor() {
        TypedQuery<Author> query = sessionFactory
                .getCurrentSession().createQuery("FROM Author", Author.class);
        return query.getResultList();
    }

    @Override
    public List<Author> findByName(String name) {
        TypedQuery<Author> query = sessionFactory
                .getCurrentSession()
                .createQuery("FROM Author WHERE name LIKE CONCAT ('%', :name,'%')", Author.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List<Author> findByNameAndSurname(String name, String surname) {
        TypedQuery<Author> query = sessionFactory
                .getCurrentSession()
                .createQuery("FROM Author WHERE name LIKE CONCAT ('%', :name,'%') "
                        + "AND surname LIKE CONCAT ('%', :surname,'%')", Author.class);
        query.setParameter("name", name);
        query.setParameter("surname", surname);
        return query.getResultList();
    }
}
