package ru.artemaa.topjavagraduate.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Artem Areshko
 *         15.06.2017
 */
@RestController
@RequestMapping(value = AdminRestController.REST_URL)
public class AdminRestController {
    static final String REST_URL = "/rest/admin";
    static final String USERS = "/users";
    static final String RESTAURANTS = "/restaurants";
    static final String DISHES = RESTAURANTS + "/{id}/dishes";

    //public AdminRestController()

}
