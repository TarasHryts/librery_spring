package mate.academy.spring.service.imp;

import java.util.List;
import java.util.Optional;
import mate.academy.spring.dao.UserDao;
import mate.academy.spring.dto.UserDto;
import mate.academy.spring.dto.UserDtoUtil;
import mate.academy.spring.entity.User;
import mate.academy.spring.exception.EmailExistsException;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> findUserByEmail(String email) {
        return userDao.findUserByEmail(email);
    }

    @Transactional
    @Override
    public Optional<User> registerNewUserAccount(UserDto accountDto) throws EmailExistsException {
        if (emailExist(accountDto.getEmail())) {
            throw new EmailExistsException("There is an account with that email address: "
                    + accountDto.getEmail());
        } else {
            User user = UserDtoUtil.creteUserFromDto(accountDto);
            user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
            return userDao.add(user);
        }
    }

    private boolean emailExist(String email) {
        Optional<User> user = findUserByEmail(email);
        return user.isPresent();
    }

}
