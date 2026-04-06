INSERT INTO users (first_name, last_name, email, password, phone, role)
SELECT 'Amit', 'Sharma', 'amit.sharma@example.com', 'amit@123', '9876543210', 'ADMIN'
WHERE NOT EXISTS (
    SELECT 1 FROM users WHERE email = 'amit.sharma@example.com'
);

INSERT INTO users (first_name, last_name, email, password, phone, role)
SELECT 'Priya', 'Verma', 'priya.verma@example.com', 'priya@123', '9988776655', 'USER'
WHERE NOT EXISTS (
    SELECT 1 FROM users WHERE email = 'priya.verma@example.com'
);