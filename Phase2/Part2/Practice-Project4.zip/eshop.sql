CREATE DATABASE eshop;

USE eshop;

CREATE TABLE product (
product_id INT AUTO_INCREMENT PRIMARY KEY,
product_name VARCHAR(255) NOT NULL,
product_description TEXT,
product_price Double(20,2) NOT NULL,
product_quantity INT NOT NULL DEFAULT 0
);

INSERT INTO product (product_name, product_description, product_price, product_quantity)
VALUES
('Laptop', 'High-performance laptop with SSD storage', 54000, 10),
('Smartphone', 'Latest smartphone with advanced features', 25000, 15),
('Headphones', 'Wireless noise-canceling headphones', 250, 20),
('Tablet', 'Portable tablet with long battery life', 10000, 12),
('Camera', 'Digital camera with high-resolution sensor', 54000, 8);

DELIMITER //
CREATE PROCEDURE GetProductByName(IN productName VARCHAR(255))
BEGIN
SELECT * FROM product WHERE product_name = productName;
END;
//
DELIMITER ;
