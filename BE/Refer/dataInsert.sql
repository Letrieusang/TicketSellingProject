INSERT INTO roles (role_name) VALUES
('admin'),
('manager');

INSERT INTO users (role_id, username, password, blocked) VALUES
(1, 'admin1', 'password1', FALSE),
(1, 'admin2', 'password2', FALSE),
(2, 'manager1', 'password3', FALSE),
(2, 'manager2', 'password4', FALSE);

INSERT INTO categories (category_name)
VALUES
('Book'),
('CD'),
('LP'),
('DVD');


INSERT INTO products (title, category_id, value, current_price, barcode, description, quantity, warehouse_entry_date, dimensions, weight, rush_order_support, image)
VALUES
--9 books
('The Great Gatsby', 1, 10, 14, '1234567890123', 'new', 15, '2023-05-01', '5x8x1 inches', 0.5, false, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSKi5lknrw7SIwZ01RQRqyvtXz2bFxrUsGVpA&s'),
('Harry Potter and the Philosopher''s Stone', 1, 8, 12, '0987654321098', 'new', 20, '2023-06-15', '4.5x7x1.5 inches', 0.75, true, 'https://upload.wikimedia.org/wikipedia/en/6/6b/Harry_Potter_and_the_Philosopher%27s_Stone_Book_Cover.jpg'),
('To Kill a Mockingbird', 1, 7, 11, '5678901234567', 'used', 8, '2023-04-20', '5.5x8.5x1 inches', 0.6, false, 'https://m.media-amazon.com/images/I/81gepf1eMqL._AC_UF1000,1000_QL80_.jpg'),
('1984', 1, 9, 13, '2109876543210', 'new', 12, '2023-07-01', '4.2x6.8x1.1 inches', 0.45, true, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSa7Euavxd7LGAyvckhwilBeeTB9Fm-PZJesA&s'),
('The Catcher in the Rye', 1, 8.50, 12.50, '6543210987654', 'used', 10, '2023-03-15', '5x7.5x0.8 inches', 0.55, false, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRCZhYffocs9dSUjGJHOYAfHXORnKcBxIO3dw&s'),
('Pride and Prejudice', 1, 6, 10, '0123456789012', 'new', 18, '2023-06-01', '4.9x7.2x1 inches', 0.4, true, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ35HIfFXMfo7vjBWr-U42lOAmd0LSxwnIbwA&s'),
('The Hobbit', 1, 9.25, 13.25, '7890123456789', 'new', 14, '2023-05-10', '5x7.7x1.2 inches', 0.65, false, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTcDen7d3gBtxb9c4zwOXG95gUYHaC5sHPtxQ&s'),
('The Lord of the Rings', 1, 14, 19, '2345678901234', 'new', 9, '2023-04-01', '5.2x8.4x2 inches', 1.2, false, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRnqZhQH9TV1Cl4OnySPrsGpWv8q631A3pvjw&s'),
('The Shining', 1, 8.75, 12.75, '6789012345678', 'used', 11, '2023-06-20', '4.8x7.5x1.1 inches', 0.5, false, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT24D5itl_lP99I6ewPwUzUoF7zbHv5LX4IUA&s'),
--5 CDs
('The Great Gatsby', 2, 9, 14, '5432109876543', 'new', 7, '2023-05-15', '5x5x0.5 inches', 0.4, true, 'https://m.media-amazon.com/images/I/81C07NWP6DL._AC_UF894,1000_QL80_.jpg'),
('Adele - 21', 3, 11, 16, '0987612345678', 'new', 20, '2023-04-01', '4.9x4.9x0.3 inches', 0.2, false, 'https://m.media-amazon.com/images/I/71EPudAWJqL._UF1000,1000_QL80_.jpg'),
('Taylor Swift - 1989', 2, 10, 15, '8765432109876', 'new', 15, '2023-06-10', '5x5x0.4 inches', 0.3, true, 'https://images.genius.com/012a999e6c9828acc7720cffcc618d6b.1000x1000x1.jpg'),
('Ed Sheeran - ÷', 2, 12, 17, '7654321098765', 'new', 12, '2023-05-20', '5.1x5.1x0.4 inches', 0.25, false, 'https://i.ytimg.com/vi/te4M8JRWnYA/hqdefault.jpg?sqp=-oaymwEmCOADEOgC8quKqQMa8AEB-AH-CYAC0AWKAgwIABABGA8gZShhMA8=&rs=AOn4CLDZV7caJyEJWGrVuCxz-kRANWuXXg'),
('Coldplay - A Head Full of Dreams', 2, 13, 18, '6543210987654', 'new', 10, '2023-03-01', '5.2x5.2x0.5 inches', 0.35, false, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQRvN5PD_qhmzdikcsUsBkI8C7Bj5IAO398zQ&s'),
-- 5 LPs
('The Beatles - Abbey Road', 3, 14, 19, '5432109876543', 'new', 8, '2023-04-15', '12x12x0.3 inches', 0.6, true, 'https://images.musicstore.de/images/1280/hal-leonard-the-beatles-abbey-road_1_NOT0012999-000.jpg'),
('Pink Floyd - The Dark Side of the Moon', 2, 16, 21, '4321098765432', 'new', 6, '2023-06-01', '12x12x0.4 inches', 0.7, true, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQMn3nJcTdJ4t697SZk4E6PxbOJu9X_8l6e0w&s'),
('Queen - A Night at the Opera', 3, 15, 20, '3210987654321', 'new', 9, '2023-05-01', '12x12x0.3 inches', 0.65, false, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNC39GjBjL8pI--M6iRhnG4BVq2kEDYBSc6Q&s'),
('Led Zeppelin IV', 3, 17, 22, '2109876543210', 'new', 7, '2023-03-20', '12x12x0.4 inches', 0.75, true, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3ELYCPbbc3lO-Pni9X9qge_V-0hLXUMvI8A&s'),
('Michael Jackson - Thriller', 3, 13, 18, '1098765432109', 'new', 11, '2023-06-15', '12x12x0.3 inches', 0.55, true, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVLJKOg4CL7q4roxVxRF0ck2HhT4VltFDTqg&s'),
--4 DVDs
('Titanic (2-Disc Special Collector''s Edition)', 4, 19, 24, '0987654321098', 'new', 5, '2023-04-01', '7.5x5.5x1 inches', 1.1, true, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQSvb2cz_uPEsJJgdlEsaziJAqQKmgeWSkkIQ&s'),
('The Lord of the Rings: The Fellowship of the Ring (Extended Edition)', 4, 21, 26, '9876543210987', 'new', 8, '2023-05-10', '7.8x5.4x1.2 inches', 1.3, true, 'https://play-lh.googleusercontent.com/sfiEMfZowCbQrIUXWZAtHIiQPrcJNahWDuTAjPEf-8LboPO58c5iekdmB1W48xfc4gSw'),
('The Shawshank Redemption', 4, 16, 21, '8765432109876', 'new', 10, '2023-06-20', '7.2x5.4x0.8 inches', 0.9, false, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSHRtBdBsDtt1intuBMeIRV-ci9STtlsdZxPg&s'),
('Jurassic Park (25th Anniversary Edition)', 4, 18, 23, '7654321098765', 'new', 6, '2023-03-01', '7.5x5.5x0.9 inches', 1.0, true, 'https://i5.walmartimages.com/seo/Jurassic-Park-25th-Anniversary-Collection-Blu-ray-HD-Digital-4-Movies_a23bec19-696b-4f1c-b168-0ce5441376ca.b3f99aea70f4aa40e6b3a6f98c2e4d70.jpeg?odnHeight=768&odnWidth=768&odnBg=FFFFFF');

-- của books
INSERT INTO authors (author_name)
VALUES
('F. Scott Fitzgerald'),
('J.K. Rowling'),
('Harper Lee'),
('George Orwell'),
('J.D. Salinger'),
('Jane Austen'),
('J.R.R. Tolkien'),
('Stephen King'),
('Adele'),
('Taylor Swift'),
('Ed Sheeran'),
('Chris Martin'),
('Michael Jackson'),
('James Cameron'),
('Frank Darabont'),
('Steven Spielberg');

-- của books
INSERT INTO publishers (publisher_name)
VALUES
('Scribner'),
('Bloomsbury'),
('Harper Perennial'),
('Signet Classics'),
('Little, Brown and Company'),
('Penguin Classics'),
('Houghton Mifflin Harcourt'),
('Knopf'),
('Capitol Records'),
('Republic Records'),
('Atco Records');

INSERT INTO books (product_id, author_id, covertype, publisher_id, publication_date, number_of_pages, lang, genre)
VALUES
(1, 1, 'paperback', 1, '1925-04-10', 180, 'English', 'Fiction'),
(2, 2, 'hardcover', 2, '1997-09-01', 309, 'English', 'Fantasy'),
(3, 3, 'paperback', 3, '1960-07-11', 281, 'English', 'Fiction'),
(4, 4, 'paperback', 4, '1949-06-08', 328, 'English', 'Dystopian'),
(5, 5, 'paperback', 5, '1951-07-16', 277, 'English', 'Fiction'),
(6, 6, 'paperback', 6, '1813-01-28', 345, 'English', 'Romance'),
(7, 7, 'paperback', 7, '1937-09-21', 310, 'English', 'Fantasy'),
(8, 7, 'hardcover', 7, '1954-07-29', 1178, 'English', 'Fantasy'),
(9, 8, 'paperback', 8, '1977-01-28', 447, 'English', 'Horror');


-- của CDs và LPs
INSERT INTO artists (artist_name)
VALUES
('The Great Gatsby'),
('Adele'),
('Taylor Swift'),
('Ed Sheeran'),
('Coldplay'),
('The Beatles'),
('Pink Floyd'),
('Queen'),
('Led Zeppelin'),
('Michael Jackson');;

--của CDs và LPs
INSERT INTO record_labels (record_label_name)
VALUES
('Universal Music Group'),
('Sony Music Entertainment'),
('Warner Music Group'),
('EMI Music'),
('RCA Records');

INSERT INTO CDs (product_id, artist_id, record_label_id, tracklist, release_date)
VALUES
(10, 1, 3, 'Shape of You, Castle on the Hill, Galway Girl', '2017-03-03'),
(12, 2, 2, '25, Hello, Rolling in the Deep', '2015-11-20'),
(13, 3, 1, 'You belong with me, FortNight', '2014-10-27'),
(14, 4, 5, 'Just the Way You Are, Grenade, Locked Out of Heaven', '2010-10-04'),
(16, 5, 2, '7 Rings, Thank U, Next, Positions', '2019-11-22');

INSERT INTO LPs (product_id, artist_id, record_label_id, tracklist, release_date)
VALUES
(11, 1, 2, 'Divide, ÷, Supermarket Flowers', '2017-03-03'),
(15, 2, 4, '21, Chasing Pavements, Rolling in the Deep', '2011-01-24'),
(17, 1, 3, '1989, Shake It Off, Blank Space', '2014-10-27'),
(18, 4, 4, 'Doo-Wops & Hooligans, Just the Way You Are, Grenade', '2010-10-04'),
(19, 3, 1, '25, Hello, Someone Like You', '2015-11-20');


-- của DVDs
INSERT INTO studios (studio_name)
VALUES
('Warner Bros. Studios'),
('Paramount Pictures'),
('Universal Studios'),
('Disney Studios'),
('20th Century Studios'),
('Sony Pictures Studios'),
('DreamWorks Animation'),
('Lionsgate'),
('Pixar Animation Studios'),
('Legendary Entertainment');

-- của DVDs
INSERT INTO directors (director_name)
VALUES
('Christopher Nolan'),
('Steven Spielberg'),
('Martin Scorsese'),
('Quentin Tarantino'),
('Greta Gerwig'),
('Denis Villeneuve'),
('Wes Anderson');

INSERT INTO DVDs (product_id, disc_type, director_id, runtime, studio_id, lang, subtitles, release_date, genre)
VALUES
(20, 'Blu-ray', 4, '02:22:00', 3, 'English', 'English, French, Spanish', '2020-07-17', 'Action, Sci-Fi'),
(21, 'Blu-ray', 2, '02:32:00', 5, 'English', 'English, German, Japanese', '2018-06-22', 'Drama, Adventure'),
(22, 'HD-DVD', 3, '02:49:00', 1, 'English', 'English, Italian, Mandarin', '2019-09-25', 'Crime, Drama'),
(23, '4K Ultra HD', 6, '01:58:00', 7, 'English', 'English, French, Russian', '2021-03-19', 'Comedy, Romance');

INSERT INTO provinces (province_name)
VALUES
  ('Ha Noi'),
  ('Ho Chi Minh City'),
  ('An Giang'),
  ('Bac Giang'),
  ('Bac Kan'),
  ('Bac Lieu'),
  ('Bac Ninh'),
  ('Ben Tre'),
  ('Binh Dinh'),
  ('Binh Duong'),
  ('Binh Phuoc'),
  ('Binh Thuan'),
  ('Ca Mau'),
  ('Cao Bang'),
  ('Dak Lak'),
  ('Dak Nong'),
  ('Dien Bien'),
  ('Dong Nai'),
  ('Dong Thap'),
  ('Gia Lai'),
  ('Ha Giang'),
  ('Ha Nam'),
  ('Ha Tinh'),
  ('Hai Duong'),
  ('Hai Phong'),
  ('Hau Giang'),
  ('Hoa Binh'),
  ('Hung Yen'),
  ('Khanh Hoa'),
  ('Kien Giang'),
  ('Kon Tum'),
  ('Lai Chau'),
  ('Lam Dong'),
  ('Lang Son'),
  ('Lao Cai'),
  ('Long An'),
  ('Nam Dinh'),
  ('Nghe An'),
  ('Ninh Binh'),
  ('Ninh Thuan'),
  ('Phu Tho'),
  ('Phu Yen'),
  ('Quang Binh'),
  ('Quang Nam'),
  ('Quang Ngai'),
  ('Quang Ninh'),
  ('Quang Tri'),
  ('Soc Trang'),
  ('Son La'),
  ('Tay Ninh'),
  ('Thai Binh'),
  ('Thai Nguyen'),
  ('Thanh Hoa'),
  ('Thua Thien Hue'),
  ('Tien Giang'),
  ('Tra Vinh'),
  ('Tuyen Quang'),
  ('Vinh Long'),
  ('Vinh Phuc'),
  ('Yen Bai');




















