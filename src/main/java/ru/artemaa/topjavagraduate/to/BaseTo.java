package ru.artemaa.topjavagraduate.to;

import ru.artemaa.topjavagraduate.HasId;

/**
 * @author Artem Areshko
 */
abstract public class BaseTo implements HasId {
    protected Integer id;

    public BaseTo() {
    }

    public BaseTo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNew() {
        return (getId() == null);
    }
}
