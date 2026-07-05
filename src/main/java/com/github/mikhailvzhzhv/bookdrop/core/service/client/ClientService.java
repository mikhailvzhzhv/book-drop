package com.github.mikhailvzhzhv.bookdrop.core.service.client;

import com.github.mikhailvzhzhv.bookdrop.core.repository.ClientRepository;
import com.github.mikhailvzhzhv.bookdrop.core.repository.entity.ClientEntity;
import com.github.mikhailvzhzhv.bookdrop.core.service.client.domain.Client;
import com.github.mikhailvzhzhv.bookdrop.core.service.client.domain.PageData;
import com.github.mikhailvzhzhv.bookdrop.exception.exceptions.ClientNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientServiceMapper mapper;
    private final ClientRepository clientRepository;

    public Client addClient(Client client) {
        return mapper.toDomain(clientRepository.save(mapper.toEntity(client)));
    }

    @Transactional
    public Client updateClientInfo(Long clientId, Client client) {
        int updatedRows = clientRepository.update(clientId, client.getFirstName(), client.getMiddleName(),
                client.getLastName(), client.getBirthDate(), client.getEmail(), LocalDateTime.now());
        if (updatedRows == 0) {
            throw new ClientNotFoundException(clientId);
        }

        ClientEntity clientEntity = clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientNotFoundException(clientId));

        return mapper.toDomain(clientEntity);
    }

    public Page<Client> getAll(PageData pageData) {
        Pageable pageRequest = PageRequest.of(pageData.getPageNumber(), pageData.getPageSize());
        return mapper.toDomain(clientRepository.findAll(pageRequest));
    }

    public Client findById(String email) {
        ClientEntity clientEntity = clientRepository.findByEmail(email)
                .orElseThrow(() -> new ClientNotFoundException(email));

        return mapper.toDomain(clientEntity);
    }
}
