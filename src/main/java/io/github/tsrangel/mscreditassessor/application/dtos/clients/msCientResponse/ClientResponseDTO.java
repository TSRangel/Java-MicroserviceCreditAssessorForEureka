package io.github.tsrangel.mscreditassessor.application.dtos.clients.msCientResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ClientResponseDTO(
        Long id,
        String cpf,
        String name,
        LocalDate birthDate,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
