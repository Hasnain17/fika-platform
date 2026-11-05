INSERT INTO categories (name) VALUES
                                  ('Coffee'), ('Tea'), ('Bakery');

INSERT INTO users (email, password_hash, full_name, role) VALUES
                                                              ('anna@example.com',  'hash1', 'Anna Svensson',   'CUSTOMER'),
                                                              ('erik@example.com',  'hash2', 'Erik Lindqvist',  'CUSTOMER'),
                                                              ('maja@example.com',  'hash3', 'Maja Staff',      'STAFF'),
                                                              ('lars@example.com',  'hash4', 'Lars Johansson',  'CUSTOMER');

INSERT INTO products (category_id, name, price, stock) VALUES
                                                           (1, 'Espresso',      30, 100),
                                                           (1, 'Latte',         45,  80),
                                                           (1, 'Cappuccino',    42,  60),
                                                           (1, 'Cold Brew',     48,   8),
                                                           (2, 'Chai',          40,  20),
                                                           (2, 'Green Tea',     32,   0),
                                                           (3, 'Cinnamon Bun',  35,   5),
                                                           (3, 'Croissant',     38,  12),
                                                           (3, 'Cardamom Bun',  36,  25),
                                                           (3, 'Chocolate Ball',28,  30);

INSERT INTO orders (user_id, status, total, created_at) VALUES
                                                            (1, 'COMPLETED', 125, '2026-08-12 09:15'),
                                                            (1, 'COMPLETED',  68, '2026-09-03 08:40'),
                                                            (2, 'COMPLETED', 152, '2026-09-10 12:30'),
                                                            (2, 'READY',     120, '2026-10-01 07:55'),
                                                            (3, 'NEW',        90, '2026-10-15 14:20');

INSERT INTO order_items (order_id, product_id, quantity, unit_price) VALUES
                                                                         (1, 2, 2, 45), (1, 7, 1, 35),
                                                                         (2, 1, 1, 30), (2, 8, 1, 38),
                                                                         (3, 5, 1, 40), (3, 3, 2, 42), (3, 10, 1, 28),
                                                                         (4, 4, 1, 48), (4, 9, 2, 36),
                                                                         (5, 1, 3, 30);