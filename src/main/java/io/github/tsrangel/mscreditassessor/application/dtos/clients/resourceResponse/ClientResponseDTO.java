package io.github.tsrangel.mscreditassessor.application.dtos.clients.resourceResponse;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record ClientResponseDTO(
        Long id,
        String cpf,
        String name,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate birthDate
) {
}
