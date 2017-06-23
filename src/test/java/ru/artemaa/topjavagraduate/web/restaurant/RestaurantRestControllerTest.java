package ru.artemaa.topjavagraduate.web.restaurant;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.artemaa.topjavagraduate.service.RestaurantService;
import ru.artemaa.topjavagraduate.util.JsonUtil;
import ru.artemaa.topjavagraduate.web.AbstractRestControllerTest;

import java.time.LocalTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.artemaa.topjavagraduate.RestaurantTestData.*;
import static ru.artemaa.topjavagraduate.TestUtil.userHttpBasic;
import static ru.artemaa.topjavagraduate.UserTestData.USER;
import static ru.artemaa.topjavagraduate.service.VoteServiceImpl.VOTE_DEADLINE;

/**
 * @author Artem Areshko
 *         15.06.2017
 */
public class RestaurantRestControllerTest extends AbstractRestControllerTest {

    private static final String REST_URL = RestaurantRestController.REST_URL + "/";

    @Autowired
    private RestaurantService service;

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get(REST_URL)
                .with(userHttpBasic(USER)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MATCHER.contentListMatcher(REST1, REST2));
    }

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get(REST_URL + REST1_ID)
                .with(userHttpBasic(USER)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MATCHER.contentMatcher(REST1));
    }

    @Test
    public void testGetNotFound() throws Exception {
        mockMvc.perform(get(REST_URL + 1)
                .with(userHttpBasic(USER)))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void testUnauthorized() throws Exception {
        mockMvc.perform(get(REST_URL))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void testPostNotAllowed() throws Exception {
        mockMvc.perform(post(REST_URL)
                .with(userHttpBasic(USER))
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(getNew())))
                .andDo(print())
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    public void testPutNotAllowed() throws Exception {
        mockMvc.perform(put(REST_URL + REST1_ID)
                .with(userHttpBasic(USER))
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(getUpdated())))
                .andDo(print())
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    public void testDeleteNotAllowed() throws Exception {
        mockMvc.perform(delete(REST_URL + REST1_ID)
                .with(userHttpBasic(USER)))
                .andDo(print())
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    public void testVote() throws  Exception {
        mockMvc.perform(post(REST_URL + REST1_ID + "/vote")
                .with(userHttpBasic(USER)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Transactional(propagation = Propagation.NEVER)
    public void testVoteChange() throws Exception {
        ResultActions actions = mockMvc.perform(post(REST_URL + REST1_ID + "/vote")
                .with(userHttpBasic(USER)))
                .andDo(print());

        if (LocalTime.now().isAfter(VOTE_DEADLINE)) {
            actions.andExpect(status().isUnprocessableEntity());
        } else {
            actions.andExpect(status().isOk());
        }
    }

}