package mate.academy.spring.dao.imp;

import java.util.Optional;
import mate.academy.spring.dao.RoleDao;
import mate.academy.spring.entity.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImp implements RoleDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Role role) {
        sessionFactory.getCurrentSession().save(role);
    }

    @Override
    public Optional<Role> getRoleById(Long roleId) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().get(Role.class, roleId));
    }
}
