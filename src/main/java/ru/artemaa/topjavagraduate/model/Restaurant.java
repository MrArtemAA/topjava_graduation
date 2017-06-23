package ru.artemaa.topjavagraduate.model;

import javax.persistence.*;
import java.util.List;

/**
 * MrArtemAA
 * 24.04.2017
 */
@Entity
@Table(name = "Restaurants", uniqueConstraints = @UniqueConstraint(name = "restaurants_unique_name_idx", columnNames = {"name"}))
public class Restaurant extends NamedEntity {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    @OrderBy("name ASC")
    private List<Dish> dishes;

    public Restaurant() {
    }

    public Restaurant(Restaurant r) {
        super(r.getId(), r.getName());
    }

    public Restaurant(Integer id, String name) {
        super(id, name);
    }

    public List<Dish> getDishes() {
        return dishes;
    }

}
