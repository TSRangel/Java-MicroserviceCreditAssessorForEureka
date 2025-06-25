package io.github.tsrangel.mscreditassessor.application.mappers;

import io.github.tsrangel.mscreditassessor.application.dtos.assessor.responses.ClientCardDTO;
import io.github.tsrangel.mscreditassessor.application.dtos.assessor.responses.ClientDataDTO;
import io.github.tsrangel.mscreditassessor.application.dtos.assessor.responses.ClientStatusResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {ClientCardMapper.class, ClientDataMapper.class})
public interface AssessorMapper {
    ClientStatusResponseDTO toDTO(ClientCardDTO card, ClientDataDTO client);
}
