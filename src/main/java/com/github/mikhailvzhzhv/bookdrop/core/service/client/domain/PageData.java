package com.github.mikhailvzhzhv.bookdrop.core.service.client.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageData {
    @NotNull
    private Integer pageNumber;

    @NotNull
    private Integer pageSize;
}
