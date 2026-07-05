package com.github.mikhailvzhzhv.bookdrop.core.service.client.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageData {
    private Integer pageNumber;

    private Integer pageSize;
}
