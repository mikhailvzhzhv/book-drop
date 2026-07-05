package com.github.mikhailvzhzhv.bookdrop.core.repository;

import com.github.mikhailvzhzhv.bookdrop.core.repository.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Modifying
    @Query(value = "UPDATE clients SET " +
            "firstname = COALESCE(:firstName, firstname), " +
            "middlename = COALESCE(:middleName, middlename), " +
            "lastname = COALESCE(:lastName, lastname) " +
            "birthdate = COALESCE(:birthDate, birthdate) " +
            "WHERE id = :id",
            nativeQuery = true)
    int update(Long id, String firstName, String middleName, String lastName, LocalDate birthDate);
}
