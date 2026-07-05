package com.github.mikhailvzhzhv.bookdrop.api.controller.client;

import com.github.mikhailvzhzhv.bookdrop.api.controller.client.model.ClientRequest;
import com.github.mikhailvzhzhv.bookdrop.api.controller.client.model.ClientResponse;
import com.github.mikhailvzhzhv.bookdrop.api.controller.client.model.ClientUpdateRequest;
import com.github.mikhailvzhzhv.bookdrop.api.controller.client.model.PageRequest;
import com.github.mikhailvzhzhv.bookdrop.core.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientControllerMapper mapper;
    private final ClientService clientService;

    @PostMapping
    public void createClient(@RequestBody @Valid ClientRequest request) {
        clientService.addClient(mapper.toDomain(request));
    }

    @PatchMapping("/{id}")
    public void updateClient(@PathVariable("id") Long id, @RequestBody @Valid ClientUpdateRequest request) {
        clientService.updateClientInfo(id, mapper.toDomain(request));
    }

    @GetMapping
    public Page<ClientResponse> getAllClients(@ModelAttribute @Valid PageRequest request) {
        return mapper.toModel(clientService.getAll(mapper.toDomain(request)));
    }
}
