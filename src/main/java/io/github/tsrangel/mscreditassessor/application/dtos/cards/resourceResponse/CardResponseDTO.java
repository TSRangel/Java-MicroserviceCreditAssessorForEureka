package io.github.tsrangel.mscreditassessor.application.dtos.cards.resourceResponse;

import java.math.BigDecimal;

public record CardResponseDTO(
        Long id,
        String name,
        String banner,
        BigDecimal availableLimit
) {
}
