package com.github.mikhailvzhzhv.bookdrop.core.service.book;

import com.github.mikhailvzhzhv.bookdrop.core.repository.BookRepository;
import com.github.mikhailvzhzhv.bookdrop.core.repository.entity.BookEntity;
import com.github.mikhailvzhzhv.bookdrop.core.service.book.domain.Book;
import com.github.mikhailvzhzhv.bookdrop.core.service.book.domain.PageData;
import com.github.mikhailvzhzhv.bookdrop.exception.exceptions.BookNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookServiceMapper mapper;
    private final BookRepository bookRepository;

    public Book createBook(Book book) {
        return mapper.toDomain(bookRepository.save(mapper.toEntity(book)));
    }

    @Transactional
    public Book updateBookInfo(Long bookId, Book book) {
        int updatedRows = bookRepository.update(
                bookId, book.getTitle(), book.getAuthor(), book.getIsbn(), LocalDateTime.now());
        if (updatedRows == 0) {
            throw new BookNotFoundException(bookId);
        }

        BookEntity bookEntity = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));

        return mapper.toDomain(bookEntity);
    }

    public Page<Book> getAll(PageData pageData) {
        Pageable pageRequest = PageRequest.of(pageData.getPageNumber(), pageData.getPageSize());
        return mapper.toDomain(bookRepository.findAll(pageRequest));
    }

    public Book findByIsbn(String isbn) {
        BookEntity bookEntity = bookRepository.findByIsbn(isbn)
                .orElseThrow(() -> new BookNotFoundException(isbn));

        return mapper.toDomain(bookEntity);
    }
}
