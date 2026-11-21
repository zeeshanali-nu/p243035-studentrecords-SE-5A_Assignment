CREATE DATABASE IF NOT EXISTS scd_records;
USE scd_records;

CREATE TABLE IF NOT EXISTS students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    reg_no VARCHAR(20) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    department VARCHAR(50) NOT NULL,
    cgpa DECIMAL(3,2) NOT NULL
);

INSERT INTO students (reg_no, name, department, cgpa) VALUES
('REG-2026-001', 'Ali Khan', 'CS', 3.45),
('REG-2026-002', 'Zarah Ahmed', 'SE', 3.90),
('REG-2026-003', 'Sameer Shah', 'CS', 2.75),
('REG-2026-004', 'Alia Noor', 'AI', 3.60),
('REG-2026-005', 'Maaz Ali', 'SE', 3.10),
('REG-2026-006', 'Peter John', 'DS', 2.40),
('REG-2026-007', 'Sara Malik', 'CS', 3.75),
('REG-2026-008', 'Hamza Qureshi', 'AI', 2.95);
