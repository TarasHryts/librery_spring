package mate.academy.spring.dao;

import java.util.Optional;
import mate.academy.spring.entity.Role;

public interface RoleDao {
    void add(Role role);

    Optional<Role> getRoleById(Long roleId);
}
