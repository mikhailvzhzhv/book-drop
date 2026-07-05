package com.github.mikhailvzhzhv.bookdrop.core.service.book;

import com.github.mikhailvzhzhv.bookdrop.core.repository.BookRepository;
import com.github.mikhailvzhzhv.bookdrop.core.service.book.domain.Book;
import com.github.mikhailvzhzhv.bookdrop.core.service.book.domain.PageData;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookServiceMapper mapper;
    private final BookRepository bookRepository;

    public void createBook(Book book) {
        bookRepository.save(mapper.toEntity(book));
    }

    public void updateBookInfo(Long bookId, Book book) {
        int updatedRows = bookRepository.update(bookId, book.getTitle(), book.getAuthor(), book.getIsbn());
        if (updatedRows == 0) {
            throw new RuntimeException("Book with id=" + bookId + " not found");
        }
    }

    public Page<Book> getAll(PageData pageData) {
        Pageable pageRequest = PageRequest.of(pageData.getPageNumber(), pageData.getPageSize());
        return mapper.toDomain(bookRepository.findAll(pageRequest));
    }
}
