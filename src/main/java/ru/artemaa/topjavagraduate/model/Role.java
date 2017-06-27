package ru.artemaa.topjavagraduate.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author Artem Areshko
 * 24.04.2017
 */
public enum Role implements GrantedAuthority {
    ADMIN,
    USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
