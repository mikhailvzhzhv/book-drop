package com.github.mikhailvzhzhv.bookdrop.core.repository;

import com.github.mikhailvzhzhv.bookdrop.core.repository.entity.Book;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Modifying
    @Query(value = "UPDATE books SET " +
            "title = COALESCE(:title, title), " +
            "author = COALESCE(:author, author), " +
            "isbn = COALESCE(:isbn, isbn) " +
            "WHERE id = :id",
            nativeQuery = true)
    int update(@Param("id") Long id,
               @Param("title") String title,
               @Param("author") String author,
               @Param("isbn") String isbn);
}
