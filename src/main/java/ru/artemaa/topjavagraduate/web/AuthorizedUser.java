package ru.artemaa.topjavagraduate.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.artemaa.topjavagraduate.model.User;
import ru.artemaa.topjavagraduate.to.UserTo;

import static java.util.Objects.requireNonNull;
import static ru.artemaa.topjavagraduate.util.ModelUtil.asTo;

/**
 * MrArtemAA
 * 19.06.2017
 */
public class AuthorizedUser extends org.springframework.security.core.userdetails.User {
    private UserTo userTo;

    public AuthorizedUser(User user) {
        super(user.getEmail(), user.getPassword(), user.isEnabled(), true, true, true, user.getRoles());
        userTo = asTo(user);
    }

    private static AuthorizedUser safeGet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        Object principal = auth.getPrincipal();
        return (principal instanceof AuthorizedUser) ? (AuthorizedUser) principal : null;
    }

    public static AuthorizedUser get() {
        AuthorizedUser user = safeGet();
        requireNonNull(user, "No authorized user found");
        return user;
    }

    public int getId() {
        return userTo.getId();
    }

    public static int id() {
        return get().userTo.getId();
    }

}
