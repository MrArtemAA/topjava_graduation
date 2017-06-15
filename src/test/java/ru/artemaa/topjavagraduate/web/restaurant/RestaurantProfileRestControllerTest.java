package ru.artemaa.topjavagraduate.web.restaurant;

import org.junit.Test;
import org.springframework.http.MediaType;
import ru.artemaa.topjavagraduate.web.AbstractRestControllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.artemaa.topjavagraduate.RestaurantTestData.REST1_ID;

/**
 * @author Artem Areshko
 *         15.06.2017
 */
public class RestaurantProfileRestControllerTest extends AbstractRestControllerTest {

    private static final String REST_URL = RestaurantProfileRestController.REST_URL + "/";

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get(REST_URL))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get(REST_URL + REST1_ID))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetNotFound() throws Exception {
        mockMvc.perform(get(REST_URL + 1))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    /*@Test
    public void testCreateForbidden()*/

}