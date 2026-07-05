package com.github.mikhailvzhzhv.bookdrop.api.controller.book.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookUpdateRequest {
    private String title;

    private String author;

    private String isbn;
}
