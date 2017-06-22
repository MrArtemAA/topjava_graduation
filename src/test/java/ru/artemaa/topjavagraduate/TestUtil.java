package ru.artemaa.topjavagraduate;

import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import ru.artemaa.topjavagraduate.model.User;

/**
 * @author Artem Areshko
 *         22.06.2017
 */
public class TestUtil {

    private TestUtil() {}

    public static RequestPostProcessor userHttpBasic(User user) {
        return SecurityMockMvcRequestPostProcessors.httpBasic(user.getEmail(), user.getPassword());
    }

}
