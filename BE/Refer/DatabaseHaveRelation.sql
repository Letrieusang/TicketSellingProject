CREATE TABLE IF NOT EXISTS roles(
    role_id SERIAL PRIMARY KEY,
    role_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS users(
    user_id SERIAL PRIMARY KEY,
    role_id INTEGER REFERENCES roles(role_id),
    username VARCHAR(50) NOT NULL,
    passWord VARCHAR(255) NOT NULL,
    blocked BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS categories(
    category_id SERIAL PRIMARY KEY,
    category_name VARCHAR(50) NOT NULL --book, CD, LP, or DVD, ...
);

CREATE TABLE IF NOT EXISTS products(
    product_id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    category_id INTEGER REFERENCES categories(category_id),
    value NUMERIC(10,2) NOT NULL,
    current_price NUMERIC(10,2) NOT NULL,
    barcode VARCHAR(255) NOT NULL,
    description TEXT NOT NULL, --new, used, primary color, condition for return
    quantity INTEGER NOT NULL,
    warehouse_entry_date DATE NOT NULL,
    dimensions VARCHAR(50) NOT NULL,
    weight NUMERIC(10, 2) NOT NULL,
    rush_order_support BOOLEAN NOT NULL,
    image VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS authors(
    author_id SERIAL PRIMARY KEY,
    author_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS publishers(
    publisher_id SERIAL PRIMARY KEY,
    publisher_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS books(
    product_id INTEGER REFERENCES products(product_id),
    author_id INTEGER REFERENCES authors(author_id),
    covertype VARCHAR(50), --paperback or hardcover
    publisher_id INTEGER REFERENCES publishers(publisher_id),
    publication_date DATE NOT NULL,
    number_of_pages INTEGER,
    lang VARCHAR(50), --language
    genre VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS artists(
    artist_id SERIAL PRIMARY KEY,
    artist_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS record_labels(
    record_label_id SERIAL PRIMARY KEY,
    record_label_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS CDs(
    product_id  INTEGER REFERENCES products(product_id),
    artist_id INTEGER REFERENCES artists(artist_id),
    record_label_id INTEGER REFERENCES record_labels(record_label_id),
    tracklist TEXT NOT NULL,
    release_date DATE
);

CREATE TABLE IF NOT EXISTS LPs(
    product_id  INTEGER REFERENCES products(product_id),
    artist_id INTEGER REFERENCES artists(artist_id),
    record_label_id INTEGER REFERENCES record_labels(record_label_id),
    tracklist TEXT NOT NULL,
    release_date DATE
);

CREATE TABLE IF NOT EXISTS studios(
    studio_id SERIAL PRIMARY KEY,
    studio_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS directors(
    director_id SERIAL PRIMARY KEY,
    director_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS DVDs (
    product_id INTEGER REFERENCES products(product_id),
    disc_type VARCHAR(50) NOT NULL, -- Blu-ray, HD-DVD, etc.
    director_id INTEGER REFERENCES directors(director_id),
    runtime VARCHAR(10) NOT NULL, -- Duration of the movie
    studio_id INTEGER REFERENCES studios(studio_id),
    lang VARCHAR(50) NOT NULL,
    subtitles TEXT NOT NULL,
    release_date DATE,
    genre VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS carts(
    cart_id SERIAL PRIMARY KEY,
    total_weight NUMERIC(10, 2) NOT NULL,
    total_price NUMERIC(10, 2) -- excluding VAT
);

CREATE TABLE IF NOT EXISTS cart_items(
    cart_item_id SERIAL PRIMARY KEY,
    cart_id INTEGER REFERENCES carts(cart_id),
    product_id INTEGER REFERENCES products(product_id),
    quantity INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS provinces(
    province_id SERIAL PRIMARY KEY,
    province_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS delivery_informations(
    delivery_id SERIAL PRIMARY KEY,
    recipient_name INTEGER NOT NULL,
    email VARCHAR(50) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    province_id INTEGER REFERENCES provinces(province_id),
    address VARCHAR(255) NOT NULL,
    is_rush_order BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS invoices(
    invoice_id SERIAL PRIMARY KEY,
    delivery_id INTEGER REFERENCES delivery_informations(delivery_id), --determine who order
    cart_id INTEGER REFERENCES carts(cart_id), -- can find list of products in the cart, 
    --quantity, product prices, total product price excluding VAT
    total_amount NUMERIC(10, 2) NOT NULL, -- total price incluce VAT
    shipping_fee NUMERIC(10, 2) NOT NULL--base on province shipping fee, weight shipping fee and order type
);

CREATE TABLE IF NOT EXISTS payment_transactions(
    payment_transaction_id SERIAL PRIMARY KEY, -- check it again
    transaction_content VARCHAR(255) NOT NULL,
    transaction_date DATE NOT NULL,
    transaction_status VARCHAR(20) NOT NULL

);

CREATE TABLE IF NOT EXISTS orders(
    order_id SERIAL PRIMARY KEY,
    delivery_id INTEGER REFERENCES delivery_informations(delivery_id), -- customer name, phone number, shipping address, province
    invoice_id INTEGER REFERENCES invoices(invoice_id), --total amount
    payment_transaction_id INTEGER REFERENCES payment_transactions(payment_transaction_id),
    create_at DATE NOT NULL,
    error_code VARCHAR(255),
    transaction_content VARCHAR(255),
    order_state VARCHAR(50) --pending, Confirmed
);




