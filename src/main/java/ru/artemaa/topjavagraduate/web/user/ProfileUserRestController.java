package ru.artemaa.topjavagraduate.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.artemaa.topjavagraduate.model.User;
import ru.artemaa.topjavagraduate.service.UserService;
import ru.artemaa.topjavagraduate.web.AuthorizedUser;

@RestController
@RequestMapping(ProfileUserRestController.REST_URL)
public class ProfileUserRestController extends AbstractUserRestController {
    public static final String REST_URL = "/profile";

    @Autowired
    public ProfileUserRestController(UserService service) {
        super(service);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    //public User get(@AuthenticationPrincipal AuthorizedUser authorizedUser) {
    public User get() {
        return super.get(AuthorizedUser.id());
    }

    @DeleteMapping
    //public void delete(@AuthenticationPrincipal AuthorizedUser authorizedUser) {
    public void delete() {
        super.delete(AuthorizedUser.id());
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    //public void update(@Valid @RequestBody UserTo userTo, @AuthenticationPrincipal AuthorizedUser authorizedUser) {
    public void update(@RequestBody User user) {
        super.update(user, AuthorizedUser.id());
    }

}