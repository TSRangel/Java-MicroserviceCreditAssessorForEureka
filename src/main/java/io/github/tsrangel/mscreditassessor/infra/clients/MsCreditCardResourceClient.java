package io.github.tsrangel.mscreditassessor.infra.clients;

import io.github.tsrangel.mscreditassessor.application.dtos.assessor.responses.ClientCardDTO;
import io.github.tsrangel.mscreditassessor.application.dtos.cards.resourceResponse.CardResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@FeignClient(value = "mscreditcard", path = "/cards")
public interface MsCreditCardResourceClient {
    @GetMapping(params = "cpf")
    ResponseEntity<Set<CardResponseDTO>> findCardsByClientCpf(@RequestParam String cpf);
}
