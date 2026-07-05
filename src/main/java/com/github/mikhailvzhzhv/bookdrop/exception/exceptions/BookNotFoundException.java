package com.github.mikhailvzhzhv.bookdrop.exception.exceptions;

public class BookNotFoundException extends NotFoundException {
    public BookNotFoundException(Long id) {
        super(String.format("Book with id=%d not found", id));
    }

    public BookNotFoundException(String isbn) {
        super(String.format("Book with isbn=%d not found", isbn));
    }
}
