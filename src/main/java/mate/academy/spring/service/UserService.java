package mate.academy.spring.service;

import java.util.List;
import java.util.Optional;
import mate.academy.spring.dto.UserDto;
import mate.academy.spring.entity.User;
import mate.academy.spring.exception.EmailExistsException;

public interface UserService {
    void add(User user);

    Optional<User> getUserById(Long id);

    List<User> listUsers();

    Optional<User> findUserByEmail(String email);

    Optional<User> registerNewUserAccount(UserDto accountDto) throws EmailExistsException;
}
