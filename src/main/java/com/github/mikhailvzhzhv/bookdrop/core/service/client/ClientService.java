package com.github.mikhailvzhzhv.bookdrop.core.service.client;

import com.github.mikhailvzhzhv.bookdrop.core.repository.ClientRepository;
import com.github.mikhailvzhzhv.bookdrop.core.service.client.domain.Client;
import com.github.mikhailvzhzhv.bookdrop.core.service.client.domain.PageData;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientServiceMapper mapper;
    private final ClientRepository clientRepository;

    public void addClient(Client client) {
        clientRepository.save(mapper.toEntity(client));
    }

    public void updateClientInfo(Long clientId, Client client) {
        int updatedRows = clientRepository.update(
                clientId, client.getFirstName(), client.getMiddleName(), client.getLastName(), client.getBirthDate());
        if (updatedRows == 0) {
            throw new RuntimeException("Client with id=" + clientId + " not found");
        }
    }

    public Page<Client> getAll(PageData pageData) {
        Pageable pageRequest = PageRequest.of(pageData.getPageNumber(), pageData.getPageSize());
        return mapper.toDomain(clientRepository.findAll(pageRequest));
    }
}
