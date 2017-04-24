package ru.artemaa.topjavagraduate.model;

/**
 * Created by Areshko-AA on 24.04.2017.
 */
public class Restaurant extends NamedEntity {

    public Restaurant() {
    }

    public Restaurant(Restaurant r) {
        super(r.getId(), r.getName());
    }

}
