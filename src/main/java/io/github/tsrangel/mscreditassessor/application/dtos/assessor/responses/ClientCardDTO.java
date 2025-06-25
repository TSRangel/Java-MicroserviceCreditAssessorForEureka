package io.github.tsrangel.mscreditassessor.application.dtos.assessor.responses;

import java.math.BigDecimal;

public record ClientCardDTO(
        String name,
        String banner,
        BigDecimal availableLimit
) {
}
