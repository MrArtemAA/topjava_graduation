package ru.artemaa.topjavagraduate;

import ru.artemaa.topjavagraduate.model.User;
import ru.artemaa.topjavagraduate.to.UserTo;

import static ru.artemaa.topjavagraduate.util.ModelUtil.asTo;

/**
 * @author Artem Areshko
 * 19.06.2017
 */
public class AuthorizedUser extends org.springframework.security.core.userdetails.User {
    private static final long serialVersionUID = 1L;

    private UserTo userTo;

    public AuthorizedUser(User user) {
        super(user.getEmail(), user.getPassword(), user.isEnabled(), true, true, true, user.getRoles());
        userTo = asTo(user);
    }

    public int getId() {
        return userTo.getId();
    }

    @Override
    public String toString() {
        return userTo.toString();
    }

}
