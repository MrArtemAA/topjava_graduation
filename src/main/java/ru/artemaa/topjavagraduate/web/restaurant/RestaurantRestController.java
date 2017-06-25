package ru.artemaa.topjavagraduate.web.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.artemaa.topjavagraduate.AuthorizedUser;
import ru.artemaa.topjavagraduate.model.Restaurant;
import ru.artemaa.topjavagraduate.service.RestaurantService;
import ru.artemaa.topjavagraduate.service.VoteService;
import ru.artemaa.topjavagraduate.util.exception.ErrorInfo;
import ru.artemaa.topjavagraduate.util.exception.LateVoteException;
import ru.artemaa.topjavagraduate.web.GlobalControllerExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Artem Areshko
 *         15.06.2017
 */
@RestController
@RequestMapping(value = RestaurantRestController.REST_URL)
public class RestaurantRestController extends AbstractRestaurantRestController {
    static final String REST_URL = "/api/restaurants";

    private final VoteService voteService;

    private GlobalControllerExceptionHandler exceptionInfoHandler;

    @Autowired
    public RestaurantRestController(RestaurantService service, VoteService voteService) {
        super(service);
        this.voteService = voteService;
    }

    @Autowired
    public void setExceptionInfoHandler(GlobalControllerExceptionHandler exceptionInfoHandler) {
        this.exceptionInfoHandler = exceptionInfoHandler;
    }

    @PostMapping(value = "/{id}/vote")
    public void vote(@PathVariable("id") int id) {
        voteService.vote(AuthorizedUser.id(), id);
    }

    @ExceptionHandler(LateVoteException.class)
    public ResponseEntity<ErrorInfo> lateVoteException(HttpServletRequest req, LateVoteException e) {
        return exceptionInfoHandler.getErrorInfoResponseEntity(req, e, e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Restaurant> getAll() {
        return super.getAll();
    }

    @Override
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant get(@PathVariable("id") int id) {
        return service.getWithDishes(id, LocalDate.now());
    }
}
