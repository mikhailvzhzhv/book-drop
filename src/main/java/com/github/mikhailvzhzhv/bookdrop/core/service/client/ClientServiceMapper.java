package com.github.mikhailvzhzhv.bookdrop.core.service.client;

import com.github.mikhailvzhzhv.bookdrop.core.repository.entity.Client;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper
public interface ClientServiceMapper {
    Client toEntity(com.github.mikhailvzhzhv.bookdrop.core.service.client.domain.Client client);

    Page<com.github.mikhailvzhzhv.bookdrop.core.service.client.domain.Client> toDomain(Page<Client> all);
}
