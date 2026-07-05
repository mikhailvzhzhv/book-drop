package com.github.mikhailvzhzhv.bookdrop.core.repository;

import com.github.mikhailvzhzhv.bookdrop.core.repository.entity.BookRental;
import com.github.mikhailvzhzhv.bookdrop.core.repository.entity.BookRentalId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRentalRepository extends JpaRepository<BookRental, BookRentalId> {

    @EntityGraph(attributePaths = {"book", "client"})
    Page<BookRental> findAllWithDetails(Pageable pageable);
}
