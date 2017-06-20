package ru.artemaa.topjavagraduate;

/**
 * @author Artem Areshko
 *         19.06.2017
 */
public interface HasId {

    Integer getId();

    void setId(Integer id);

    default boolean isNew() {
        return (getId() == null);
    }

}
