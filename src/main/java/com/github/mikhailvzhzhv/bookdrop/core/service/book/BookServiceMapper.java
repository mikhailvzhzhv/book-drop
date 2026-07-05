package com.github.mikhailvzhzhv.bookdrop.core.service.book;

import com.github.mikhailvzhzhv.bookdrop.core.repository.entity.BookEntity;
import com.github.mikhailvzhzhv.bookdrop.core.service.book.domain.Book;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper
public interface BookServiceMapper {

    BookEntity toEntity(Book book);

    default Page<Book> toDomain(Page<BookEntity> all) {
        return all.map(this::toDomain);
    }

    Book toDomain(BookEntity book);
}
