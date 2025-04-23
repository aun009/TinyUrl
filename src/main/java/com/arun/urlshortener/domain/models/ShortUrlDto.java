package com.arun.urlshortener.domain.models;

import com.arun.urlshortener.domain.entities.ShortUrl;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link ShortUrl}
 */
public record ShortUrlDto(Long id, String shortKey, String originalUrl,
                          Boolean isPrivate, Instant expiresAt,
                          UserDto createdBy, Long clickCount,
                          Instant createdAt) implements Serializable {
}