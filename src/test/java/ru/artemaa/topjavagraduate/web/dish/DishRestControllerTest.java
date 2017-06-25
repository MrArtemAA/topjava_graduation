package ru.artemaa.topjavagraduate.web.dish;

import org.junit.Test;
import org.springframework.http.MediaType;
import ru.artemaa.topjavagraduate.web.AbstractRestControllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.artemaa.topjavagraduate.DishTestData.MATCHER;
import static ru.artemaa.topjavagraduate.DishTestData.REST1_DISHES;
import static ru.artemaa.topjavagraduate.RestaurantTestData.REST1_ID;
import static ru.artemaa.topjavagraduate.TestUtil.userHttpBasic;
import static ru.artemaa.topjavagraduate.UserTestData.USER;

/**
 * @author Artem Areshko
 *         23.06.2017
 */
public class DishRestControllerTest extends AbstractRestControllerTest {
    private static final String REST_URL = DishRestController.REST_URL.replace("{restaurantId}", String.valueOf(REST1_ID)) + "/";

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get(REST_URL)
                .with(userHttpBasic(USER)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MATCHER.contentListMatcher(REST1_DISHES));
    }

    @Test
    public void testUnauthorized() throws Exception {
        mockMvc.perform(get(REST_URL))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

}