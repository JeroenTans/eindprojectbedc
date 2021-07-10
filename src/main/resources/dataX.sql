DELETE FROM users;
DELETE FROM authorities;
INSERT INTO users (username, password, enabled) VALUES ('admin', '$2a$10$CTjBUxyo35L2W.Vl7lHozOBVKOglpXu8oWlzgNi5jZqL2/SR/S6WO', true);
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');