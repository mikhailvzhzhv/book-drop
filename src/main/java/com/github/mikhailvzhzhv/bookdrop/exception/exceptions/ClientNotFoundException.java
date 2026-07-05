package com.github.mikhailvzhzhv.bookdrop.exception.exceptions;

public class ClientNotFoundException extends NotFoundException {
    public ClientNotFoundException(Long id) {
        super(String.format("Client with id=%d not found", id));
    }

    public ClientNotFoundException(String email) {
        super(String.format("Client with email=%s not found", email));
    }
}
