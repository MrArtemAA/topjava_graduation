package ru.artemaa.topjavagraduate.web.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.artemaa.topjavagraduate.model.Restaurant;
import ru.artemaa.topjavagraduate.service.RestaurantService;
import ru.artemaa.topjavagraduate.util.exception.ErrorInfo;
import ru.artemaa.topjavagraduate.web.GlobalControllerExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static ru.artemaa.topjavagraduate.util.ValidationUtil.checkIdConsistent;
import static ru.artemaa.topjavagraduate.util.ValidationUtil.checkNew;

/**
 * @author Artem Areshko
 *         15.06.2017
 */
@RestController
@RequestMapping(RestaurantAdminRestController.REST_URL)
public class RestaurantAdminRestController {
    static final String REST_URL = "/api/admin/restaurants";

    public static final String EXCEPTION_DUPLICATE_RESTAURANT = "Restaurant with this name already exists";

    private final RestaurantService service;
    private GlobalControllerExceptionHandler exceptionInfoHandler;

    @Autowired
    public RestaurantAdminRestController(RestaurantService service) {
        this.service = service;
    }

    @Autowired
    public void setExceptionInfoHandler(GlobalControllerExceptionHandler exceptionInfoHandler) {
        this.exceptionInfoHandler = exceptionInfoHandler;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Restaurant> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant get(@PathVariable("id") int id) {
        return service.get(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> create(@Valid @RequestBody Restaurant restaurant) {
        checkNew(restaurant);
        Restaurant created = service.save(restaurant);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@Valid @RequestBody Restaurant restaurant, @PathVariable("id") int id) {
        checkIdConsistent(restaurant, id);
        service.update(restaurant);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id) {
        service.delete(id);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorInfo> duplicateEmailException(HttpServletRequest req, DataIntegrityViolationException e) {
        return exceptionInfoHandler.getErrorInfoResponseEntity(req, e, EXCEPTION_DUPLICATE_RESTAURANT, HttpStatus.CONFLICT);
    }

}
