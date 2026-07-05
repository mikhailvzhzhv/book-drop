package com.github.mikhailvzhzhv.bookdrop.api.controller.book_rental;

import com.github.mikhailvzhzhv.bookdrop.api.controller.book_rental.model.BookRentalRequest;
import com.github.mikhailvzhzhv.bookdrop.api.controller.book_rental.model.BookRentalResponse;
import com.github.mikhailvzhzhv.bookdrop.api.controller.book_rental.model.PageRequest;
import com.github.mikhailvzhzhv.bookdrop.core.service.book_rental.domain.BookRental;
import com.github.mikhailvzhzhv.bookdrop.core.service.book_rental.domain.BookRentalData;
import com.github.mikhailvzhzhv.bookdrop.core.service.book_rental.domain.PageData;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper
public interface BookRentalControllerMapper {
    BookRental toDomain(BookRentalRequest request);

    PageData toDomain(PageRequest request);

    default Page<BookRentalResponse> toModel(Page<BookRentalData> all) {
        return all.map(this::toModel);
    }

    BookRentalResponse toModel(BookRentalData bookRentalData);
}
