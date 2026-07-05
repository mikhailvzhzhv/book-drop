package com.github.mikhailvzhzhv.bookdrop.api.controller.book;

import com.github.mikhailvzhzhv.bookdrop.api.controller.book.model.BookRequest;
import com.github.mikhailvzhzhv.bookdrop.api.controller.book.model.BookResponse;
import com.github.mikhailvzhzhv.bookdrop.api.controller.book.model.BookUpdateRequest;
import com.github.mikhailvzhzhv.bookdrop.api.controller.book.model.PageRequest;
import com.github.mikhailvzhzhv.bookdrop.core.service.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookControllerMapper mapper;
    private final BookService bookService;

    @PostMapping
    public void createBook(@RequestBody @Valid BookRequest request) {
        bookService.createBook(mapper.toDomain(request));
    }

    @PatchMapping("/{id}")
    public void updateBook(@PathVariable("id") Long id, @RequestBody @Valid BookUpdateRequest request) {
        bookService.updateBookInfo(id, mapper.toDomain(request));
    }

    @GetMapping
    public Page<BookResponse> getAllBooks(@ModelAttribute @Valid PageRequest request) {
        return mapper.toModel(bookService.getAll(mapper.toDomain(request)));
    }
}
