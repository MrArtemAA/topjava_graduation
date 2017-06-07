package ru.artemaa.topjavagraduate.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * MrArtemAA
 * 24.04.2017
 */
@Entity
@Table(name = "dishes", uniqueConstraints = @UniqueConstraint(columnNames = {"restaurant_id", "name", "date"}, name = "dishes_unique_rest_name_date_idx"))
public class Dish extends NamedEntity {

    @Column(name = "price", nullable = false)
    @NotNull
    @Range(min = 1, max = 2000)
    private Float price;

    @Column(name = "date", nullable = false, columnDefinition = "datetime default now()")
    @NotNull
    private LocalDate date = LocalDate.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @NotNull
    private Restaurant restaurant;

    public Dish() {
    }

    public Dish(Dish d) {
        this(d.getId(), d.getName(), d.getRestaurant(), d.getDate(), d.getPrice());
    }

    public Dish(Integer id, String name, Restaurant restaurant, float price) {
        super(id, name);
        this.restaurant = restaurant;
        this.price = price;
    }

    public Dish(Integer id, String name, Restaurant restaurant, LocalDate date, float price) {
        super(id, name);
        this.restaurant = restaurant;
        this.date = date;
        this.price = price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + getId() +
                ", name=" + name +
                ", price=" + price +
                ", date=" + date +
                '}';
    }

}
