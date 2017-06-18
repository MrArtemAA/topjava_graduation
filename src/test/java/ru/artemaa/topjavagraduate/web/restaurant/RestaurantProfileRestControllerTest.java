package ru.artemaa.topjavagraduate.web.restaurant;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import ru.artemaa.topjavagraduate.service.RestaurantService;
import ru.artemaa.topjavagraduate.util.JsonUtil;
import ru.artemaa.topjavagraduate.web.AbstractRestControllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.artemaa.topjavagraduate.RestaurantTestData.*;

/**
 * @author Artem Areshko
 *         15.06.2017
 */
public class RestaurantProfileRestControllerTest extends AbstractRestControllerTest {

    private static final String REST_URL = RestaurantProfileRestController.REST_URL + "/";

    @Autowired
    private RestaurantService service;

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get(REST_URL))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MATCHER.contentListMatcher(REST1, REST2));
    }

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get(REST_URL + REST1_ID))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MATCHER.contentMatcher(REST1));
    }

    @Test
    public void testGetNotFound() throws Exception {
        mockMvc.perform(get(REST_URL + 1))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void testPostNotAllowed() throws Exception {
        mockMvc.perform(post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(getNew())))
                .andDo(print())
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    public void testPutNotAllowed() throws Exception {
        mockMvc.perform(put(REST_URL + REST1_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(getUpdated())))
                .andDo(print())
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    public void testDeleteNotAllowed() throws Exception {
        mockMvc.perform(delete(REST_URL + REST1_ID))
                .andDo(print())
                .andExpect(status().isMethodNotAllowed());
    }

}