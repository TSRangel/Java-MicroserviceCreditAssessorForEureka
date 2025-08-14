package io.github.tsrangel.mscreditassessor.application.services;

import io.github.tsrangel.mscreditassessor.application.dtos.assessor.responses.ClientDataDTO;
import io.github.tsrangel.mscreditassessor.application.dtos.assessor.responses.ClientStatusResponseDTO;
import io.github.tsrangel.mscreditassessor.application.services.exceptions.ClientDataNotFoundException;
import io.github.tsrangel.mscreditassessor.application.services.exceptions.FeignClientConnectionError;
import org.springframework.http.ResponseEntity;

public interface AssessorService {
    ClientStatusResponseDTO getClientStatus(String cpf) throws ClientDataNotFoundException, FeignClientConnectionError;
}
