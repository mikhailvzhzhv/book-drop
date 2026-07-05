package com.github.mikhailvzhzhv.bookdrop.controller.client;

import com.github.mikhailvzhzhv.bookdrop.controller.client.model.ClientRequest;
import com.github.mikhailvzhzhv.bookdrop.controller.client.model.ClientResponse;
import com.github.mikhailvzhzhv.bookdrop.controller.client.model.ClientUpdateRequest;
import com.github.mikhailvzhzhv.bookdrop.controller.client.model.PageRequest;
import com.github.mikhailvzhzhv.bookdrop.core.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientControllerMapper mapper;
    private final ClientService clientService;

    @PostMapping
    public void createClient(@Valid ClientRequest request) {
        clientService.addClient(mapper.toDomain(request));
    }

    @PatchMapping("/{id}")
    public void updateBook(@PathVariable("id") Long id, @Valid ClientUpdateRequest request) {
        clientService.updateClientInfo(id, mapper.toDomain(request));
    }

    public Page<ClientResponse> getAll(@Valid PageRequest request) {
        return mapper.toModel(clientService.getAll(mapper.toDomain(request)));
    }
}
