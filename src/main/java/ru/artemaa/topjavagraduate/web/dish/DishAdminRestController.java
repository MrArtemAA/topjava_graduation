package ru.artemaa.topjavagraduate.web.dish;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.artemaa.topjavagraduate.model.Dish;
import ru.artemaa.topjavagraduate.service.DishService;
import ru.artemaa.topjavagraduate.to.DishTo;
import ru.artemaa.topjavagraduate.util.exception.ErrorInfo;
import ru.artemaa.topjavagraduate.web.GlobalControllerExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;

import static ru.artemaa.topjavagraduate.util.ModelUtil.createFromTo;
import static ru.artemaa.topjavagraduate.util.ValidationUtil.checkIdConsistent;
import static ru.artemaa.topjavagraduate.util.ValidationUtil.checkNew;

/**
 * @author Artem Areshko
 * 19.06.2017
 */
@RestController
@RequestMapping(value = DishAdminRestController.REST_URL)
public class DishAdminRestController extends DishRestController {
    private static final Logger LOG = LoggerFactory.getLogger(DishAdminRestController.class);

    static final String REST_URL = "/api/admin/restaurants/{restaurantId}/dishes";

    private static final String EXCEPTION_DUPLICATE_DISH = "Dish at this restaurant with this name and date already exists";

    private GlobalControllerExceptionHandler exceptionInfoHandler;

    @Autowired
    public DishAdminRestController(DishService service) {
        super(service);
    }

    @Autowired
    public void setExceptionInfoHandler(GlobalControllerExceptionHandler exceptionInfoHandler) {
        this.exceptionInfoHandler = exceptionInfoHandler;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Dish get(@PathVariable("id") int id, @PathVariable("restaurantId") int restaurantId) {
        LOG.info("Get today Dish {} for Restaurant {}", id, restaurantId);
        return service.get(id, restaurantId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dish> create(@Valid @RequestBody DishTo dishTo, @PathVariable("restaurantId") int restaurantId) {
        LOG.info("Create {} for Restaurant {}", dishTo, restaurantId);
        checkNew(dishTo);
        Dish created = service.save(createFromTo(dishTo), restaurantId);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(restaurantId, created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@Valid @RequestBody DishTo dishTo, @PathVariable("id") int id, @PathVariable("restaurantId") int restaurantId) {
        LOG.info("Update {} with id {} for Restaurant {}", dishTo, id, restaurantId);
        checkIdConsistent(dishTo, id);
        service.update(dishTo, restaurantId);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id, @PathVariable("restaurantId") int restaurantId) {
        LOG.info("Delete Dish {} for Restaurant {}", id, restaurantId);
        service.delete(id, restaurantId);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorInfo> duplicateEmailException(HttpServletRequest req, DataIntegrityViolationException e) {
        return exceptionInfoHandler.getErrorInfoResponseEntity(req, e, EXCEPTION_DUPLICATE_DISH, HttpStatus.CONFLICT);
    }

}
