package com.github.mikhailvzhzhv.bookdrop.api.controller.book;

import com.github.mikhailvzhzhv.bookdrop.api.controller.book.model.BookRequest;
import com.github.mikhailvzhzhv.bookdrop.api.controller.book.model.BookResponse;
import com.github.mikhailvzhzhv.bookdrop.api.controller.book.model.BookUpdateRequest;
import com.github.mikhailvzhzhv.bookdrop.api.controller.book.model.PageRequest;
import com.github.mikhailvzhzhv.bookdrop.core.service.book.domain.Book;
import com.github.mikhailvzhzhv.bookdrop.core.service.book.domain.PageData;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper
public interface BookControllerMapper {

    Book toDomain(BookRequest bookRequest);

    Book toDomain(BookUpdateRequest bookRequest);

    PageData toDomain(PageRequest bookRequest);

    default Page<BookResponse> toModel(Page<Book> all) {
        return all.map(this::toModel);
    }

    BookResponse toModel(Book book);
}
