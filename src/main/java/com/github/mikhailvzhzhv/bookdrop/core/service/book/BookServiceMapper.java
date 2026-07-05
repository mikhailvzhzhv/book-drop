package com.github.mikhailvzhzhv.bookdrop.core.service.book;

import com.github.mikhailvzhzhv.bookdrop.core.repository.entity.Book;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper
public interface BookServiceMapper {

    Book toEntity(com.github.mikhailvzhzhv.bookdrop.core.service.book.domain.Book book);

    Page<com.github.mikhailvzhzhv.bookdrop.core.service.book.domain.Book> toDomain(Page<Book> all);
}
