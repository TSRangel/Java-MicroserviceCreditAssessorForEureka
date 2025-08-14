package io.github.tsrangel.mscreditassessor.application.services.impl;

import feign.FeignException;
import io.github.tsrangel.mscreditassessor.application.dtos.assessor.responses.ClientCardDTO;
import io.github.tsrangel.mscreditassessor.application.dtos.assessor.responses.ClientDataDTO;
import io.github.tsrangel.mscreditassessor.application.dtos.assessor.responses.ClientStatusResponseDTO;
import io.github.tsrangel.mscreditassessor.application.dtos.cards.resourceResponse.CardResponseDTO;
import io.github.tsrangel.mscreditassessor.application.dtos.clients.resourceResponse.ClientResponseDTO;
import io.github.tsrangel.mscreditassessor.application.mappers.ClientCardMapper;
import io.github.tsrangel.mscreditassessor.application.mappers.ClientDataMapper;
import io.github.tsrangel.mscreditassessor.application.services.AssessorService;
import io.github.tsrangel.mscreditassessor.application.services.exceptions.ClientDataNotFoundException;
import io.github.tsrangel.mscreditassessor.application.services.exceptions.FeignClientConnectionError;
import io.github.tsrangel.mscreditassessor.infra.clients.MsClientsResourceClient;
import io.github.tsrangel.mscreditassessor.infra.clients.MsCreditCardResourceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AssessorServiceImpl implements AssessorService {
    private final MsClientsResourceClient msClientsResourceClient;
    private final MsCreditCardResourceClient msCreditCardResourceClient;
    private final ClientDataMapper clientDataMapper;
    private final ClientCardMapper clientCardMapper;

    @Override
    public ClientStatusResponseDTO getClientStatus(String cpf) throws ClientDataNotFoundException, FeignClientConnectionError {
        try {
            ResponseEntity<ClientResponseDTO> msClientResponse = msClientsResourceClient.findClientByCpf(cpf);
            ResponseEntity<Set<CardResponseDTO>> msCardResponse = msCreditCardResourceClient.findCardsByClientCpf(cpf);
            ClientDataDTO clientData = clientDataMapper.toClientDataDTO(msClientResponse.getBody());
            Set<ClientCardDTO> clientCardDTOs = msCardResponse.getBody()
                    .stream().map(clientCardMapper::toClientCardDTO).collect(Collectors.toSet());
            return new ClientStatusResponseDTO(clientData, clientCardDTOs);
        } catch (FeignException.FeignClientException e) {
            if(HttpStatus.NOT_FOUND.value() == e.status()) {
                throw new ClientDataNotFoundException("Não foram encontrados dados de cliente com o cpf informado.");
            }

            throw new FeignClientConnectionError(e.getMessage(), e.status());
        }
    }
}
