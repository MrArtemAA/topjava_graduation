package ru.artemaa.topjavagraduate.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.artemaa.topjavagraduate.AuthorizedUser;
import ru.artemaa.topjavagraduate.model.User;
import ru.artemaa.topjavagraduate.service.UserService;
import ru.artemaa.topjavagraduate.to.UserTo;

import javax.validation.Valid;

@RestController
@RequestMapping(UserProfileRestController.REST_URL)
public class UserProfileRestController extends AbstractUserRestController {
    public static final String REST_URL = "/api/profile";

    @Autowired
    public UserProfileRestController(UserService service) {
        super(service);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public User get() {
    //public User get(@AuthenticationPrincipal AuthorizedUser authorizedUser) {
        //return super.get(authorizedUser.getId());
        return super.get(AuthorizedUser.id());
    }

    @DeleteMapping
    public void delete() {
    //public void delete(@AuthenticationPrincipal AuthorizedUser authorizedUser) {
        //super.delete(authorizedUser.getId());
        super.delete(AuthorizedUser.id());
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@Valid @RequestBody UserTo userTo) {
    //public void update(@Valid @RequestBody UserTo userTo, @AuthenticationPrincipal AuthorizedUser authorizedUser) {
        //super.update(userTo, authorizedUser.getId());
        super.update(userTo, AuthorizedUser.id());
    }

}