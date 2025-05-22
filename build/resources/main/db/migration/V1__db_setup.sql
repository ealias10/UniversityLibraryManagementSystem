CREATE TABLE author (
  id UUID NOT NULL,
   name VARCHAR(255),
   biography VARCHAR(255),
   birth_date BIGINT,
   CONSTRAINT pk_author PRIMARY KEY (id)
);

ALTER TABLE author ADD CONSTRAINT uc_author_name UNIQUE (name);

CREATE TABLE books (
  id UUID NOT NULL,
   isbn VARCHAR(255),
   title VARCHAR(255),
   genre VARCHAR(255),
   publication_year BIGINT,
   publisher VARCHAR(255),
   total_copies INTEGER,
   auther_id UUID,
   CONSTRAINT pk_books PRIMARY KEY (id)
);

ALTER TABLE books ADD CONSTRAINT FK_BOOKS_ON_AUTHER FOREIGN KEY (auther_id) REFERENCES author (id);

CREATE TABLE library_member (
  id UUID NOT NULL,
   member_id VARCHAR(255),
   fist_name VARCHAR(255),
   last_name VARCHAR(255),
   email VARCHAR(255),
   membership_date BIGINT,
   status VARCHAR(255),
   CONSTRAINT pk_librarymember PRIMARY KEY (id)
);

ALTER TABLE library_member ADD CONSTRAINT uc_librarymember_email UNIQUE (email);

ALTER TABLE library_member ADD CONSTRAINT uc_librarymember_fist_name UNIQUE (fist_name);

ALTER TABLE library_member ADD CONSTRAINT uc_librarymember_last_name UNIQUE (last_name);

ALTER TABLE library_member ADD CONSTRAINT uc_librarymember_member UNIQUE (member_id);

CREATE TABLE book_loan (
  id UUID NOT NULL,
   book_id UUID,
   member_id UUID,
   loan_date BIGINT,
   due_date BIGINT,
   return_date BIGINT,
   genre VARCHAR(255),
   CONSTRAINT pk_bookloan PRIMARY KEY (id)
);

ALTER TABLE book_loan ADD CONSTRAINT FK_BOOKLOAN_ON_BOOK FOREIGN KEY (book_id) REFERENCES books (id);

ALTER TABLE book_loan ADD CONSTRAINT FK_BOOKLOAN_ON_MEMBER FOREIGN KEY (member_id) REFERENCES library_member (id);


CREATE TABLE reservation (
  id UUID NOT NULL,
   book_id UUID,
   member_id UUID,
   reservation_date BIGINT,
   status VARCHAR(255),
   pickup_expiry_date BIGINT,
   CONSTRAINT pk_reservation PRIMARY KEY (id)
);

ALTER TABLE reservation ADD CONSTRAINT FK_RESERVATION_ON_BOOK FOREIGN KEY (book_id) REFERENCES books (id);

ALTER TABLE reservation ADD CONSTRAINT FK_RESERVATION_ON_MEMBER FOREIGN KEY (member_id) REFERENCES library_member (id);





