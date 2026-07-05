CREATE TABLE IF NOT EXISTS books_rental (
    PRIMARY KEY (book_id, client_id),
    book_id BIGINT NOT NULL,
    client_id BIGINT NOT NULL,
    rental_date TIMESTAMP NOT NULL,
    return_date TIMESTAMP,
    FOREIGN KEY (book_id) REFERENCES books(id) ON DELETE CASCADE,
    FOREIGN KEY (client_id) REFERENCES clients(id) ON DELETE CASCADE
);