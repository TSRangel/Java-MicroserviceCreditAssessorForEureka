package io.github.tsrangel.mscreditassessor.infra.clients;

import io.github.tsrangel.mscreditassessor.application.dtos.clients.msCientResponse.ClientResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "msclients", path = "/clients")
public interface MsClientsResourceClient {
    @GetMapping(params = "cpf")
    ResponseEntity<ClientResponseDTO> findClientByCpf(@RequestParam String cpf);
}
