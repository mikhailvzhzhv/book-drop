package com.github.mikhailvzhzhv.bookdrop.core.service.book_rental;

import com.github.mikhailvzhzhv.bookdrop.core.repository.BookRentalRepository;
import com.github.mikhailvzhzhv.bookdrop.core.service.book_rental.domain.BookRental;
import com.github.mikhailvzhzhv.bookdrop.core.service.book_rental.domain.BookRentalData;
import com.github.mikhailvzhzhv.bookdrop.core.service.book_rental.domain.PageData;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookRentalService {

    private final BookRentalServiceMapper mapper;
    private final BookRentalRepository bookRentalRepository;

    public void rentBook(BookRental bookRental) {
        bookRentalRepository.save(mapper.toEntity(bookRental));
    }

    public Page<BookRentalData> getAll(PageData pageData) {
        Pageable pageRequest = PageRequest.of(pageData.getPageNumber(), pageData.getPageSize());
        return mapper.toDomain(bookRentalRepository.findAllWithDetails(pageRequest));
    }
}
