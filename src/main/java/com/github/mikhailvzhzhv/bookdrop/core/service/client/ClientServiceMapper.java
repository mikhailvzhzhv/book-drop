package com.github.mikhailvzhzhv.bookdrop.core.service.client;

import com.github.mikhailvzhzhv.bookdrop.core.repository.entity.ClientEntity;
import com.github.mikhailvzhzhv.bookdrop.core.service.client.domain.Client;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper
public interface ClientServiceMapper {
    ClientEntity toEntity(Client client);

    default Page<Client> toDomain(Page<ClientEntity> all) {
        return all.map(this::toDomain);
    }

    Client toDomain(ClientEntity client);
}
