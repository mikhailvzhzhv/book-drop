package com.github.mikhailvzhzhv.bookdrop.core.service.book_rental.domain;

import com.github.mikhailvzhzhv.bookdrop.core.service.book.domain.Book;
import com.github.mikhailvzhzhv.bookdrop.core.service.client.domain.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRentalData {
    private Book book;

    private Client client;

    private LocalDateTime rentalDate;
}
