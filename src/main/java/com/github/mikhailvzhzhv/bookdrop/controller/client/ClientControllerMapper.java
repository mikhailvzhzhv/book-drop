package com.github.mikhailvzhzhv.bookdrop.api.controller.client;

import com.github.mikhailvzhzhv.bookdrop.api.controller.client.model.ClientRequest;
import com.github.mikhailvzhzhv.bookdrop.api.controller.client.model.ClientResponse;
import com.github.mikhailvzhzhv.bookdrop.api.controller.client.model.ClientUpdateRequest;
import com.github.mikhailvzhzhv.bookdrop.api.controller.client.model.PageRequest;
import com.github.mikhailvzhzhv.bookdrop.core.service.client.domain.Client;
import com.github.mikhailvzhzhv.bookdrop.core.service.client.domain.PageData;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper
public interface ClientControllerMapper {

    Client toDomain(ClientRequest request);

    Client toDomain(ClientUpdateRequest request);

    PageData toDomain(PageRequest request);

    default Page<ClientResponse> toModel(Page<Client> all) {
        return all.map(this::toModel);
    }

    ClientResponse toModel(Client client);
}
