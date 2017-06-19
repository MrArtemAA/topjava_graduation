package ru.artemaa.topjavagraduate.web.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = RestaurantRestController.REST_URL)
public class RestaurantRestController {//extends AbstractRestaurantRestController {
    static final String REST_URL = "/rest/restaurants";

    protected final RestaurantService service;

    @Autowired
    public RestaurantRestController(RestaurantService service) {
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
