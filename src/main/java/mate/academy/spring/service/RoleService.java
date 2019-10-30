package mate.academy.spring.service;

import java.util.Optional;
import mate.academy.spring.entity.Role;

public interface RoleService {
    void add(Role role);

    Optional<Role> getRoleById(Long roleId);
}
