package com.github.mikhailvzhzhv.bookdrop.controller.book_rental.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageRequest {
    @NotNull
    private Integer pageNumber;

    @NotNull
    @Min(1)
    private Integer pageSize;
}
