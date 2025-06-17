INSERT INTO account (id, account_number, currency_type, balance, created_at) VALUES
  (1, 'ACC1001', 'USD', 1000.00, '2024-01-01'),
  (2, 'ACC1002', 'EUR', 2500.50, '2024-02-01');

INSERT INTO account_holder (id, holder_id_type, holder_id, first_name, last_name, email, phone_number, house_number, street, city, country, zip_code, date_of_birth, created_at) VALUES
  (1, 'NATIONAL_ID', 'ID123456', 'Alice', 'Smith', 'alice@example.com', '1234567890', '12A', 'Main St', 'Springfield', 'USA', '12345', '1990-05-10', '2024-01-01'),
  (2, 'PASSPORT', 'P987654', 'Bob', 'Johnson', 'bob@example.com', '0987654321', '34B', 'Second Ave', 'Shelbyville', 'USA', '54321', '1985-08-20', '2024-02-01');

INSERT INTO account_holder_account (account_holder_id, account_id) VALUES
  (1, 1),
  (2, 2);

ALTER TABLE account_holder ALTER COLUMN id RESTART WITH 3;

ALTER TABLE account ALTER COLUMN id RESTART WITH 3;