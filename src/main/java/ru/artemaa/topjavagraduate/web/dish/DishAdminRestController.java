package ru.artemaa.topjavagraduate.web.dish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.artemaa.topjavagraduate.model.Dish;
import ru.artemaa.topjavagraduate.service.DishService;

import java.time.LocalDate;
import java.util.List;

/**
 * MrArtemAA
 * 19.06.2017
 */
@RestController
@RequestMapping(value = DishAdminRestController.REST_URL)
public class DishAdminRestController extends DishRestController {
    static final String REST_URL = "rest/admin/{restaurantId}/dishes";

    @Autowired
    public DishAdminRestController(DishService service) {
        super(service);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Dish> getAllForDate(@PathVariable("restaurantId") int restaurantId) {
        return service.getAll(restaurantId, LocalDate.now());
    }

    /*@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Dish get(@PathVariable("id") int id, @PathVariable("restaurantId") int restaurantId) {
        return service.get(id, restaurantId);
    }*/

}
