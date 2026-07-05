package com.github.mikhailvzhzhv.bookdrop.core.service.book_rental;

import com.github.mikhailvzhzhv.bookdrop.core.repository.BookRentalRepository;
import com.github.mikhailvzhzhv.bookdrop.core.repository.BookRepository;
import com.github.mikhailvzhzhv.bookdrop.core.repository.ClientRepository;
import com.github.mikhailvzhzhv.bookdrop.core.repository.entity.BookEntity;
import com.github.mikhailvzhzhv.bookdrop.core.repository.entity.BookRentalEntity;
import com.github.mikhailvzhzhv.bookdrop.core.repository.entity.BookRentalId;
import com.github.mikhailvzhzhv.bookdrop.core.repository.entity.ClientEntity;
import com.github.mikhailvzhzhv.bookdrop.core.service.book_rental.domain.BookRental;
import com.github.mikhailvzhzhv.bookdrop.core.service.book_rental.domain.BookRentalData;
import com.github.mikhailvzhzhv.bookdrop.core.service.book_rental.domain.PageData;
import com.github.mikhailvzhzhv.bookdrop.exception.exceptions.BookNotFoundException;
import com.github.mikhailvzhzhv.bookdrop.exception.exceptions.ClientNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BookRentalService {

    private final BookRentalServiceMapper mapper;
    private final BookRentalRepository bookRentalRepository;
    private final BookRepository bookRepository;
    private final ClientRepository clientRepository;

    @Transactional
    public BookRentalData rentBook(BookRental bookRental) {
        long bookId = bookRental.getBookId();
        long clientId = bookRental.getClientId();

        BookEntity book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));
        ClientEntity client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientNotFoundException(clientId));

        BookRentalId rentalId = new BookRentalId(bookId, clientId);

        BookRentalEntity rental = createBookRentalEntity(rentalId, book, client);

        return mapper.toDomain(bookRentalRepository.save(rental));
    }

    private BookRentalEntity createBookRentalEntity(BookRentalId rentalId, BookEntity book, ClientEntity client) {
        BookRentalEntity rental = new BookRentalEntity();
        rental.setId(rentalId);
        rental.setBook(book);
        rental.setClient(client);
        rental.setRentalDate(LocalDateTime.now());

        return rental;
    }

    public Page<BookRentalData> getAll(PageData pageData) {
        Pageable pageRequest = PageRequest.of(pageData.getPageNumber(), pageData.getPageSize());
        return mapper.toDomain(bookRentalRepository.findAllWithDetails(pageRequest));
    }
}
