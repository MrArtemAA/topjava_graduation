package ru.artemaa.topjavagraduate.web.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.artemaa.topjavagraduate.service.RestaurantService;
import ru.artemaa.topjavagraduate.service.VoteService;
import ru.artemaa.topjavagraduate.web.AuthorizedUser;

/**
 * @author Artem Areshko
 *         15.06.2017
 */
@RestController
@RequestMapping(value = RestaurantRestController.REST_URL)
public class RestaurantRestController extends AbstractRestaurantRestController {
    static final String REST_URL = "/rest/restaurants";

    private final VoteService voteService;

    @Autowired
    public RestaurantRestController(RestaurantService service, VoteService voteService) {
        super(service);
        this.voteService = voteService;
    }

    @PostMapping(value = "/{id}/vote")
    public void vote(@PathVariable("id") int id) {
        voteService.vote(AuthorizedUser.id(), id);
    }

}
