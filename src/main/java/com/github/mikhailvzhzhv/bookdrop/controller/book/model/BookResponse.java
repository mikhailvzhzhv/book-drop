package com.github.mikhailvzhzhv.bookdrop.controller.book.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {
    private long id;

    private String title;

    private String author;

    private String isbn;
}
