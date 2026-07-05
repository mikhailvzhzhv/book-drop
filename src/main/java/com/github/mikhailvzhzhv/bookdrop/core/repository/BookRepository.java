package com.github.mikhailvzhzhv.bookdrop.core.repository;

import com.github.mikhailvzhzhv.bookdrop.core.repository.entity.BookEntity;
import com.github.mikhailvzhzhv.bookdrop.core.service.book.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

    @Modifying
    @Query("UPDATE BookEntity b SET " +
            "b.title = COALESCE(:title, b.title), " +
            "b.author = COALESCE(:author, b.author), " +
            "b.isbn = COALESCE(:isbn, b.isbn), " +
            "b.updatedAt = :updatedAt " +
            "WHERE b.id = :id")
    int update(@Param("id") Long id,
               @Param("title") String title,
               @Param("author") String author,
               @Param("isbn") String isbn,
               @Param("updatedAt") LocalDateTime updatedAt);

    Optional<BookEntity> findByIsbn(String isbn);
}
