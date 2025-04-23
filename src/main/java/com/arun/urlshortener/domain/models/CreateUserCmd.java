package com.arun.urlshortener.domain.models;

public record CreateUserCmd(
        String email,
        String password,
        String name,
        Role role) {
}
