package com.github.mikhailvzhzhv.bookdrop.controller.book;

import com.github.mikhailvzhzhv.bookdrop.controller.book.model.BookRequest;
import com.github.mikhailvzhzhv.bookdrop.controller.book.model.BookResponse;
import com.github.mikhailvzhzhv.bookdrop.controller.book.model.BookUpdateRequest;
import com.github.mikhailvzhzhv.bookdrop.controller.book.model.PageRequest;
import com.github.mikhailvzhzhv.bookdrop.core.service.book.domain.Book;
import com.github.mikhailvzhzhv.bookdrop.core.service.book.domain.PageData;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper
public interface BookControllerMapper {

    Book toDomain(BookRequest bookRequest);

    Book toDomain(BookUpdateRequest bookRequest);

    PageData toDomain(PageRequest bookRequest);

    Page<BookResponse> toModel(Page<Book> all);
}
