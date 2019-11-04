package mate.academy.spring.dao;

import java.util.List;
import java.util.Optional;
import mate.academy.spring.entity.User;

public interface UserDao {
    Optional<User> add(User user);

    Optional<User> getUserById(Long id);

    List<User> listUsers();

    Optional<User> findUserByEmail(String email);

    Optional<User> findByUsername(String username);
}
