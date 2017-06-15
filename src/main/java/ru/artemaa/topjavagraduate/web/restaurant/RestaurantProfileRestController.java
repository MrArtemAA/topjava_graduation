package ru.artemaa.topjavagraduate.web.restaurant;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.artemaa.topjavagraduate.model.Restaurant;
import ru.artemaa.topjavagraduate.service.RestaurantService;

import java.util.List;

/**
 * @author Artem Areshko
 *         15.06.2017
 */
@RestController
@RequestMapping(value = RestaurantProfileRestController.REST_URL)
public class RestaurantProfileRestController {//extends AbstractRestaurantRestController {
    static final String REST_URL = "/rest/profile";

    protected final RestaurantService service;

    public RestaurantProfileRestController(RestaurantService service) {
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Restaurant> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant get(@PathVariable("id") int id) {
        return service.get(id);
    }

}
