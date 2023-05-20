CREATE TABLE users
(
    id         BIGSERIAL PRIMARY KEY,
    user_name  VARCHAR(40) NOT NULL,
    first_name VARCHAR(40) NOT NULL,
    last_name  VARCHAR(40) NOT NULL,
    email      VARCHAR(50) UNIQUE,
    password   VARCHAR(255),
    phone      VARCHAR(255),
    roles      VARCHAR(50) NOT NULL

);
INSERT INTO users(user_name, first_name, last_name, email, password, phone, roles)
VALUES ('buy', 'buyer', 'Smith', 'tom@gmail.com', '$2a$10$990Y2d0f.sQa8BM245dFK.IQ2XYdUxjgi.jSbTpeLVWWmm/l9VgAK', '+996 955 300 555', 'USER_BUYER');
INSERT INTO users(user_name, first_name, last_name, email, password, phone, roles)
VALUES ('sell', 'seller', 'Smith', 'max@gmail.com', '$2a$10$LWpYbA49fEsIfNsa5Y918OZ58rRB4GfQwoX0C5JSQSV5ThqPB.vwS', '+996 995 555 444', 'ADMIN_SELLER');


CREATE TABLE orders
(
    id         BIGSERIAL PRIMARY KEY,
    ship_date  DATE NOT NULL,
    created_at DATE,
    complete   BOOLEAN,
    status     VARCHAR(50)
);
INSERT INTO orders(ship_date, created_at, complete, status)
VALUES ('1980-12-17', '1980-12-17', true, 'PLACED');


CREATE TABLE users_orders
(
    user_id  BIGINT NOT NULL,
    order_id INT    NOT NULL,
    PRIMARY KEY (user_id, order_id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (order_id) REFERENCES orders (id)
);
INSERT INTO users_orders(user_id, order_id)
VALUES (1, 1);


CREATE TABLE products
(
    id          BIGSERIAL PRIMARY KEY,
    name        VARCHAR(40) NOT NULL,
    price       INT         NOT NULL,
    quantity    INT         NOT NULL,
    category_id INT         NOT NULL
);
INSERT INTO products(name, price, quantity, category_id)
VALUES ('Dress', '2000', '1', '1');


CREATE TABLE categories
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(40) NOT NULL
);
INSERT INTO categories(name)
VALUES ('Dress');


CREATE TABLE vendors
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);
INSERT INTO vendors(name)
VALUES ('LOUIS VUITTON');


CREATE TABLE orders_products
(
    order_id   BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    PRIMARY KEY (order_id, product_id),
    FOREIGN KEY (order_id) REFERENCES orders (id),
    FOREIGN KEY (product_id) REFERENCES products (id)
);
INSERT INTO orders_products(order_id, product_id)
VALUES (1, 1);



CREATE TABLE categories_products
(
    category_id BIGINT NOT NULL,
    product_id  BIGINT NOT NULL,
    PRIMARY KEY (category_id, product_id),
    FOREIGN KEY (category_id) REFERENCES categories (id),
    FOREIGN KEY (product_id) REFERENCES products (id)
);
INSERT INTO categories_products(category_id, product_id)
VALUES (1, 1);

CREATE TABLE vendors_products
(
    vendor_id  BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    PRIMARY KEY (vendor_id, product_id),
    FOREIGN KEY (vendor_id) REFERENCES vendors (id),
    FOREIGN KEY (product_id) REFERENCES products (id)
);
INSERT INTO vendors_products(vendor_id, product_id)
VALUES (1, 1);

CREATE TABLE roles
(
    id   SERIAL PRIMARY KEY ,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE users_roles
(
    user_id BIGINT NOT NULL,
    role_id INT    NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id)
);
INSERT INTO roles(name)
VALUES ('USER_BUYER'),
       ('ADMIN_SELLER');
INSERT INTO users_roles(user_id, role_id) VALUES (1,1);
INSERT INTO users_roles(user_id, role_id) VALUES (2,2);