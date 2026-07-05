package com.github.mikhailvzhzhv.bookdrop.controller.book_rental;

import com.github.mikhailvzhzhv.bookdrop.controller.book_rental.model.BookRentalRequest;
import com.github.mikhailvzhzhv.bookdrop.controller.book_rental.model.BookRentalResponse;
import com.github.mikhailvzhzhv.bookdrop.controller.book_rental.model.PageRequest;
import com.github.mikhailvzhzhv.bookdrop.core.service.book_rental.BookRentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller("/rent")
@RequiredArgsConstructor
public class BookRentalController {

    private final BookRentalControllerMapper mapper;
    private final BookRentalService bookRentalService;

    @PostMapping
    public void rentBook(@Valid BookRentalRequest request) {
        bookRentalService.rentBook(mapper.toDomain(request));
    }

    @GetMapping
    public Page<BookRentalResponse> getBookRentals(@Valid PageRequest request) {
        return mapper.toModel(bookRentalService.getAll(mapper.toDomain(request)));
    }
}
