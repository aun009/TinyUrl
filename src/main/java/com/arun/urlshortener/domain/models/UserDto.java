package com.arun.urlshortener.domain.models;

import com.arun.urlshortener.domain.entities.User;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
public record UserDto(Long id, String name) implements Serializable {
}