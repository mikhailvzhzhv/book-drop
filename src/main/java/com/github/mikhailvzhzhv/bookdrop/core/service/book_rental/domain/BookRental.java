package com.github.mikhailvzhzhv.bookdrop.core.service.book_rental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRental {
    private long bookId;

    private long clientId;
}
