package com.github.mikhailvzhzhv.bookdrop.core.service.book.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private long id;

    private String title;

    private String author;

    private String isbn;
}