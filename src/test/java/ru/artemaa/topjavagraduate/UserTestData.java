package ru.artemaa.topjavagraduate;

import ru.artemaa.topjavagraduate.matcher.ModelMatcher;
import ru.artemaa.topjavagraduate.model.Role;
import ru.artemaa.topjavagraduate.model.User;
import ru.artemaa.topjavagraduate.to.UserTo;

import java.util.Objects;

import static ru.artemaa.topjavagraduate.model.BaseEntity.START_SEQ;

/**
 * MrArtemAA
 * 03.05.2017
 */
public class UserTestData {
    public static final int USER_ID = START_SEQ;
    public static final int ADMIN_ID = START_SEQ + 1;

    public static final User USER = new User(USER_ID, "User", "user@world.org", "user", Role.USER);
    public static final User ADMIN = new User(ADMIN_ID, "Admin", "admin@world.org", "admin", Role.ADMIN, Role.USER);

    public static final ModelMatcher<User> MATCHER = ModelMatcher.of(User.class,
            (expected, actual) -> expected == actual ||
                    (Objects.equals(expected.getPassword(), actual.getPassword())
                            && Objects.equals(expected.getId(), actual.getId())
                            && Objects.equals(expected.getName(), actual.getName())
                            && Objects.equals(expected.getEmail(), actual.getEmail())
                            && Objects.equals(expected.isEnabled(), actual.isEnabled())
                            && Objects.equals(expected.getRoles(), actual.getRoles())
                    )
    );

    public static User getNew() {
        return new User(null, "New User", "newuser@world.org", "newuser", Role.USER);
    }
    public static User getUpdated() {
        return new User(START_SEQ, "Updated User", "user@world.org", "user", Role.USER);
    }
    public static UserTo getUpdatedTo() {
        return new UserTo(START_SEQ, "Updated User", "user@world.org", "user");
    }

}
