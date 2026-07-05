package com.github.mikhailvzhzhv.bookdrop.controller.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponse {
    private Long id;

    private String firstName;

    private String middleName;

    private String lastName;

    private LocalDate birthDate;
}
