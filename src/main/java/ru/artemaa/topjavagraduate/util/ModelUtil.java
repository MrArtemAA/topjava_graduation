package ru.artemaa.topjavagraduate.util;

import org.springframework.data.domain.Sort;

/**
 * @author MrArtemAA
 *         14.06.2017
 */
public class ModelUtil {

    private ModelUtil() {
    }

    public static final Sort SORT_BY_NAME = new Sort("name");
    public static final Sort SORT_BY_NAME_EMAIL = new Sort("name", "email");

}
