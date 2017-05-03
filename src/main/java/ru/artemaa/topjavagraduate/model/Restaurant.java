package ru.artemaa.topjavagraduate.model;

/**
 * MrArtemAA
 * 24.04.2017
 */
public class Restaurant extends NamedEntity {

    public Restaurant() {
    }

    public Restaurant(Restaurant r) {
        super(r.getId(), r.getName());
    }

    public Restaurant(Integer id, String name) {
        super(id, name);
    }
}
