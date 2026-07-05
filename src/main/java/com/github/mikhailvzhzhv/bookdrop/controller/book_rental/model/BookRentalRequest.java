package com.github.mikhailvzhzhv.bookdrop.controller.book_rental.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRentalRequest {
    @NotNull
    private Long bookId;

    @NotNull
    private Long clientId;
}
