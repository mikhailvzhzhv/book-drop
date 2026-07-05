package com.github.mikhailvzhzhv.bookdrop.controller.book_rental.model;

import com.github.mikhailvzhzhv.bookdrop.controller.book.model.BookResponse;
import com.github.mikhailvzhzhv.bookdrop.controller.client.model.ClientResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRentalResponse {
    private BookResponse book;

    private ClientResponse client;

    private LocalDateTime rentalDate;
}
