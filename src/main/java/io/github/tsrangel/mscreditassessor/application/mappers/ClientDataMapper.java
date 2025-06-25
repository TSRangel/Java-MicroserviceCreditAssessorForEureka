package io.github.tsrangel.mscreditassessor.application.mappers;

import io.github.tsrangel.mscreditassessor.application.dtos.assessor.responses.ClientDataDTO;
import io.github.tsrangel.mscreditassessor.application.dtos.clients.msCientResponse.ClientResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientDataMapper {
    ClientDataDTO toClientDataDTO(ClientResponseDTO dto);
}
