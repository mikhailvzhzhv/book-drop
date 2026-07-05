package com.github.mikhailvzhzhv.bookdrop.core.repository;

import com.github.mikhailvzhzhv.bookdrop.core.repository.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    @Modifying
    @Query("UPDATE ClientEntity c SET " +
            "c.firstName = COALESCE(:firstName, c.firstName), " +
            "c.middleName = COALESCE(:middleName, c.middleName), " +
            "c.lastName = COALESCE(:lastName, c.lastName), " +
            "c.birthDate = COALESCE(:birthDate, c.birthDate), " +
            "c.email = COALESCE(:email, c.email), " +
            "c.updatedAt = :updatedAt " +
            "WHERE c.id = :id")
    int update(@Param("id") Long id,
               @Param("firstName") String firstName,
               @Param("middleName") String middleName,
               @Param("lastName") String lastName,
               @Param("birthDate") LocalDate birthDate,
               @Param("email") String email,
               @Param("updatedAt") LocalDateTime updatedAt);

    Optional<ClientEntity> findByEmail(String email);
}
