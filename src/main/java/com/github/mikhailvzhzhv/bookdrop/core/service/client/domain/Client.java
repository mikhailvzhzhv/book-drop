package com.github.mikhailvzhzhv.bookdrop.core.service.client.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private long id;

    private String firstName;

    private String middleName;

    private String lastName;

    private LocalDate birthDate;

    private String email;
}
