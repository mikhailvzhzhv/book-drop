package com.github.mikhailvzhzhv.bookdrop.core.service.book_rental;

import com.github.mikhailvzhzhv.bookdrop.core.repository.entity.BookRentalEntity;
import com.github.mikhailvzhzhv.bookdrop.core.service.book_rental.domain.BookRental;
import com.github.mikhailvzhzhv.bookdrop.core.service.book_rental.domain.BookRentalData;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper
public interface BookRentalServiceMapper {
    BookRentalEntity toEntity(BookRental bookRental);

    default Page<BookRentalData> toDomain(Page<BookRentalEntity> all) {
        return all.map(this::toDomain);
    }

    BookRentalData toDomain(BookRentalEntity bookRental);
}
