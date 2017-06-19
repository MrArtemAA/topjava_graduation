package ru.artemaa.topjavagraduate.to;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * MrArtemAA
 * 19.06.2017
 */
public class DishTo extends BaseTo {

    @NotBlank
    private String name;

    @NotNull
    @Range(min = 1, max = 2000)
    private Integer price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
