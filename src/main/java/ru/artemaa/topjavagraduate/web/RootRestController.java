package ru.artemaa.topjavagraduate.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.artemaa.topjavagraduate.model.User;
import ru.artemaa.topjavagraduate.service.UserService;
import ru.artemaa.topjavagraduate.to.UserTo;

import java.net.URI;

import static ru.artemaa.topjavagraduate.util.ModelUtil.createFromTo;
import static ru.artemaa.topjavagraduate.util.ValidationUtil.checkNew;
import static ru.artemaa.topjavagraduate.web.user.UserProfileRestController.REST_URL;

/**
 * MrArtemAA
 * 20.06.2017
 */
@RestController
public class RootRestController {

    private final UserService service;

    @Autowired
    public RootRestController(UserService service) {
        this.service = service;
    }

    @RequestMapping()
    public void basicAnswer() {

    }

    @PostMapping(value = "/register")
    public ResponseEntity<User> register(UserTo userTo) {
        checkNew(userTo);
        User created = service.save(createFromTo(userTo));

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

}
