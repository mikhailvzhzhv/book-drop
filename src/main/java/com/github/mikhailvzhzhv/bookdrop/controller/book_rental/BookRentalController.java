package com.github.mikhailvzhzhv.bookdrop.api.controller.book_rental;

import com.github.mikhailvzhzhv.bookdrop.api.controller.book_rental.model.BookRentalRequest;
import com.github.mikhailvzhzhv.bookdrop.api.controller.book_rental.model.BookRentalResponse;
import com.github.mikhailvzhzhv.bookdrop.api.controller.book_rental.model.PageRequest;
import com.github.mikhailvzhzhv.bookdrop.core.service.book_rental.BookRentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/rent")
@RequiredArgsConstructor
public class BookRentalController {

    private final BookRentalControllerMapper mapper;
    private final BookRentalService bookRentalService;

    @PostMapping
    public void rentBook(@RequestBody @Valid BookRentalRequest request) {
        bookRentalService.rentBook(mapper.toDomain(request));
    }

    @GetMapping
    public Page<BookRentalResponse> getBookRentals(@ModelAttribute @Valid PageRequest request) {
        return mapper.toModel(bookRentalService.getAll(mapper.toDomain(request)));
    }
}
