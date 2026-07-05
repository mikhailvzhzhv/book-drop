package com.github.mikhailvzhzhv.bookdrop.controller.client;

import com.github.mikhailvzhzhv.bookdrop.controller.client.model.ClientRequest;
import com.github.mikhailvzhzhv.bookdrop.controller.client.model.ClientResponse;
import com.github.mikhailvzhzhv.bookdrop.controller.client.model.ClientUpdateRequest;
import com.github.mikhailvzhzhv.bookdrop.controller.client.model.PageRequest;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientControllerMapper mapper;
    private final ClientService clientService;

    @PostMapping
    public ClientResponse createClient(@RequestBody @Valid ClientRequest request) {
        return mapper.toModel(clientService.addClient(mapper.toDomain(request)));
    }

    @PatchMapping("/{id}")
    public ClientResponse updateClient(@PathVariable("id") Long id, @RequestBody @Valid ClientUpdateRequest request) {
        return mapper.toModel(clientService.updateClientInfo(id, mapper.toDomain(request)));
    }

    @GetMapping
    public Page<ClientResponse> getAllClients(@ModelAttribute @Valid PageRequest request) {
        return mapper.toModel(clientService.getAll(mapper.toDomain(request)));
    }

    @GetMapping("/search")
    public ClientResponse findById(@RequestParam String email) {
        return mapper.toModel(clientService.findById(email));
    }
}
