package io.github.tsrangel.mscreditassessor.application.mappers;

import io.github.tsrangel.mscreditassessor.application.dtos.assessor.responses.ClientCardDTO;
import io.github.tsrangel.mscreditassessor.application.dtos.cards.resourceResponse.CardResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientCardMapper {
    ClientCardDTO toClientCardDTO(CardResponseDTO dto);
}
