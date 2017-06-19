package ru.artemaa.topjavagraduate.web;

import static ru.artemaa.topjavagraduate.model.BaseEntity.START_SEQ;

/**
 * MrArtemAA
 * 19.06.2017
 */
public class AuthorizedUser {

    private static int id = START_SEQ;

    private static void setId(int id) {
        AuthorizedUser.id = id;
    }

    public static int id() {
        return id;
    }

}
