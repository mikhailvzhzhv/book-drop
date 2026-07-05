package com.github.mikhailvzhzhv.bookdrop.core.service.book_rental;

import com.github.mikhailvzhzhv.bookdrop.core.repository.entity.BookRental;
import com.github.mikhailvzhzhv.bookdrop.core.service.book_rental.domain.BookRentalData;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper
public interface BookRentalServiceMapper {
    BookRental toEntity(com.github.mikhailvzhzhv.bookdrop.core.service.book_rental.domain.BookRental bookRental);

    Page<BookRentalData> toDomain(Page<BookRental> all);
}
