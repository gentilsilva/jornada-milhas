package br.com.backend.challenge.api.domain.destination;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DestinationFormDTO(
        @NotNull
        String picture,

        @NotNull
        String name,

        @NotNull
        BigDecimal price
) {
}
