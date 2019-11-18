package mate.academy.spring.dto;

import java.util.HashSet;
import java.util.Set;
import mate.academy.spring.entity.Role;
import mate.academy.spring.entity.User;

public class UserDtoUtil {
    public static User creteUserFromDto(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        Set<Role> roles = new HashSet<>();
        roles.add(new Role("USER"));
        user.setRoles(roles);
        return user;
    }
}
