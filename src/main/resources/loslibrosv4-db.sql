CREATE DATABASE loslibrosv4;
USE loslibrosv4;

CREATE TABLE customer (
        cus_id VARCHAR(5) PRIMARY KEY,
        cus_name VARCHAR(50),
        cus_address VARCHAR(50),
        p_num VARCHAR(15)
);

CREATE TABLE supplier (
        sup_id VARCHAR(4) PRIMARY KEY,
        sup_name VARCHAR(35)
);

CREATE TABLE category (
        cat_id VARCHAR(4) PRIMARY KEY,
        cat_name VARCHAR(20)
);

CREATE TABLE author (
        au_id VARCHAR(4) PRIMARY KEY,
        au_name VARCHAR(50)
);

CREATE TABLE publisher (
        pub_id VARCHAR(4) PRIMARY KEY,
        pub_name VARCHAR(50)
);

CREATE TABLE book (
        b_id VARCHAR(4) PRIMARY KEY,
        b_name VARCHAR(50),
        au_id VARCHAR(4),
        cat_id VARCHAR(4),
        pub_id VARCHAR(4),
        sup_id VARCHAR(4),
        price DECIMAL(10,2),
        qty INT(3),
        FOREIGN KEY (au_id) REFERENCES author(au_id) ON DELETE CASCADE ON UPDATE CASCADE,
        FOREIGN KEY (cat_id) REFERENCES category(cat_id) ON DELETE CASCADE ON UPDATE CASCADE,
        FOREIGN KEY (pub_id) REFERENCES publisher(pub_id) ON DELETE CASCADE ON UPDATE CASCADE,
        FOREIGN KEY (sup_id) REFERENCES supplier(sup_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE employee (
        emp_id VARCHAR(4) PRIMARY KEY,
        emp_name VARCHAR(50),
        emp_role VARCHAR(15),
        emp_salary DECIMAL(10,2),
        emp_add VARCHAR(50),
        emp_num VARCHAR(15),
        emp_mail VARCHAR(30)
);

CREATE TABLE employee_payroll (
        payroll_id VARCHAR(5) PRIMARY KEY,
        emp_id VARCHAR(4),
        payroll_date DATE,
        basic_salary DECIMAL(10,2),
        deductions DECIMAL(10,2),
        bonuses DECIMAL(10,2),
        net_salary DECIMAL(10,2) GENERATED ALWAYS AS (basic_salary - deductions + bonuses) STORED,
        FOREIGN KEY (emp_id) REFERENCES employee(emp_id) ON DELETE CASCADE ON UPDATE CASCADE
);

DELIMITER $$

CREATE TRIGGER update_basic_salary
    AFTER UPDATE ON employee
    FOR EACH ROW
BEGIN
    UPDATE employee_payroll
    SET basic_salary = NEW.emp_salary
    WHERE emp_id = NEW.emp_id;
    END$$

DELIMITER ;

    CREATE TABLE employee_leave (
        leave_id VARCHAR(4) PRIMARY KEY,
        emp_id VARCHAR(4),
        leave_type VARCHAR(15) CHECK (leave_type IN ('Sick', 'Vacation', 'Personal')),
        start_date DATE,
        end_date DATE,
        status VARCHAR(10) CHECK (status IN ('Approved', 'Pending', 'Rejected')),
        FOREIGN KEY (emp_id) REFERENCES employee(emp_id) ON DELETE CASCADE
    );

    CREATE TABLE orders (
    order_id VARCHAR(5) PRIMARY KEY,
    cus_id VARCHAR(5),
    order_date DATE,
    FOREIGN KEY (cus_id) REFERENCES customer(cus_id) ON DELETE CASCADE ON UPDATE CASCADE
    );

    CREATE TABLE order_details (
    order_id VARCHAR(5),
    b_id VARCHAR(4),
    quantity INT(3),
    price DECIMAL(10,2),
    PRIMARY KEY (order_id, b_id),
    FOREIGN KEY (order_id) REFERENCES orders(order_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (b_id) REFERENCES book(b_id) ON DELETE CASCADE ON UPDATE CASCADE
    );

    CREATE TABLE owner (
    id VARCHAR(5) PRIMARY KEY,
    name VARCHAR(50),
    address VARCHAR(50),
    p_num VARCHAR(10)
    );