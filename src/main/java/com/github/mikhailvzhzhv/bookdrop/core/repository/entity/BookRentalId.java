package com.github.mikhailvzhzhv.bookdrop.core.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRentalId implements Serializable {

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "client_id")
    private Long clientId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BookRentalId that = (BookRentalId) o;
        return Objects.equals(bookId, that.bookId) &&
                Objects.equals(clientId, that.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, clientId);
    }
}