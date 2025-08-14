package io.github.tsrangel.mscreditassessor.application.controllers;

import io.github.tsrangel.mscreditassessor.application.dtos.assessor.responses.ClientStatusResponseDTO;
import io.github.tsrangel.mscreditassessor.application.services.AssessorService;
import io.github.tsrangel.mscreditassessor.application.services.exceptions.ClientDataNotFoundException;
import io.github.tsrangel.mscreditassessor.application.services.exceptions.FeignClientConnectionError;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("assessor")
@RequiredArgsConstructor
public class CreditAssessorController {
    private final AssessorService assessorService;

    @GetMapping(params = "cpf")
    public ResponseEntity<ClientStatusResponseDTO> findClientByCpf(String cpf)
            throws ClientDataNotFoundException, FeignClientConnectionError {
        ClientStatusResponseDTO clientData = assessorService.getClientStatus(cpf);
        return ResponseEntity.ok(clientData);
    }
}
