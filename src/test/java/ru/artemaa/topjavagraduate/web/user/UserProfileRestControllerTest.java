package ru.artemaa.topjavagraduate.web.user;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.artemaa.topjavagraduate.model.User;
import ru.artemaa.topjavagraduate.service.UserService;
import ru.artemaa.topjavagraduate.to.UserTo;
import ru.artemaa.topjavagraduate.util.JsonUtil;
import ru.artemaa.topjavagraduate.util.ModelUtil;
import ru.artemaa.topjavagraduate.web.AbstractRestControllerTest;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.artemaa.topjavagraduate.TestUtil.userHttpBasic;
import static ru.artemaa.topjavagraduate.UserTestData.*;

/**
 * @author Artem Areshko
 */
public class UserProfileRestControllerTest extends AbstractRestControllerTest {

    private static final String REST_URL = UserProfileRestController.REST_URL + '/';

    @Autowired
    private UserService service;

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get(REST_URL)
                .with(userHttpBasic(USER)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MATCHER.contentMatcher(USER));
    }

    @Test
    public void testUnauthorized() throws Exception {
        mockMvc.perform(get(REST_URL))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete(REST_URL)
                .with(userHttpBasic(USER)))
                .andDo(print())
                .andExpect(status().isOk());
        MATCHER.assertCollectionEquals(Collections.singletonList(ADMIN), service.getAll());
    }

    @Test
    public void testUpdate() throws Exception {
        UserTo updatedTo = getUpdatedTo();

        mockMvc.perform(put(REST_URL).contentType(MediaType.APPLICATION_JSON)
                .with(userHttpBasic(USER))
                .content(JsonUtil.writeValue(updatedTo)))
                .andDo(print())
                .andExpect(status().isOk());

        MATCHER.assertEquals(ModelUtil.updateFromTo(new User(USER), updatedTo), service.getByEmail("updateduser@world.org"));
    }

    @Test
    public void testUpdateInvalid() throws Exception {
        UserTo updatedTo = new UserTo(null, null, "user@world.org", "password");

        mockMvc.perform(put(REST_URL).contentType(MediaType.APPLICATION_JSON)
                .with(userHttpBasic(USER))
                .content(JsonUtil.writeValue(updatedTo)))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(content().json("{'cause':'ValidationException'}"))
                .andDo(print());
    }

    @Test
    @Transactional(propagation = Propagation.NEVER)
    public void testDuplicate() throws Exception {
        UserTo updatedTo = new UserTo(null, "newName", "admin@world.org", "newPassword");

        mockMvc.perform(put(REST_URL).contentType(MediaType.APPLICATION_JSON)
                .with(userHttpBasic(USER))
                .content(JsonUtil.writeValue(updatedTo)))
                .andExpect(status().isConflict())
                .andDo(print());
    }

}