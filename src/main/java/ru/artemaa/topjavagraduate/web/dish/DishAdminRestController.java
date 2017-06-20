package ru.artemaa.topjavagraduate.web.dish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.artemaa.topjavagraduate.model.Dish;
import ru.artemaa.topjavagraduate.service.DishService;

import java.net.URI;

import static ru.artemaa.topjavagraduate.util.ValidationUtil.checkIdConsistent;
import static ru.artemaa.topjavagraduate.util.ValidationUtil.checkNew;

/**
 * MrArtemAA
 * 19.06.2017
 */
@RestController
@RequestMapping(value = DishAdminRestController.REST_URL)
public class DishAdminRestController extends DishRestController {
    static final String REST_URL = "rest/admin/restaurants/{restaurantId}/dishes";

    @Autowired
    public DishAdminRestController(DishService service) {
        super(service);
    }

    /*@GetMapping(MediaType.APPLICATION_JSON_VALUE)
    public List<Dish> getAllForDate(@PathVariable("restaurantId") int restaurantId, ) {
        return service.getAll(restaurantId, LocalDate.now());
    }*/

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Dish get(@PathVariable("id") int id, @PathVariable("restaurantId") int restaurantId) {
        return service.get(id, restaurantId);
    }

    /*@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DishTo> create(@RequestBody DishTo dishTo, @PathVariable("restaurantId") int restaurantId) {
        checkNew(dishTo);
        DishTo created = service.save(dishTo, restaurantId);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }*/

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dish> create(@RequestBody Dish dish, @PathVariable("restaurantId") int restaurantId) {
        checkNew(dish);
        Dish created = service.save(dish, restaurantId);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Dish dish, @PathVariable("id") int id, @PathVariable("restaurantId") int restaurantId) {
        checkIdConsistent(dish, id);
        service.update(dish, restaurantId);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id, @PathVariable("restaurantId") int restaurantId) {
        service.delete(id, restaurantId);
    }

}
