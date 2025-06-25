package io.github.tsrangel.mscreditassessor.application.dtos.assessor.responses;

import java.util.Set;

public record ClientStatusResponseDTO(
    ClientDataDTO clientDataDTO,
    Set<ClientCardDTO> clientCards
) {
}
