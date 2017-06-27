package ru.artemaa.topjavagraduate.to;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Artem Areshko
 * 19.06.2017
 */
public class DishTo extends BaseTo implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank
    private String name;

    @NotNull
    @Range(min = 1, max = 2000)
    private Integer price;

    public DishTo() {}

    public DishTo(Integer id, String name, Integer price) {
        super(id);
        this.name = name;
        this.price = price;
    }

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

    @Override
    public String toString() {
        return "DishTo{" +
                "id=" + getId() +
                ", name=" + name +
                ", price=" + price +
                '}';
    }
}
