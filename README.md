# JDBC Database Management System

A Java application that demonstrates database connectivity and operations using JDBC (Java Database Connectivity) to manage a product inventory system.

## Course Project

This project was developed as part of the **Introduction to Database Systems** course.

The project implements a command-line interface for managing a product database with features to insert, display, and update product information based on sales performance metrics.

## Features

- **Insert Products**: Add new products with ProductID, Name, Price, and Sales information
- **View Inventory**: Display all products currently in the database
- **Dynamic Price Adjustment**: Automatically update prices based on sales goals using conditional logic
- **Database Operations**: Perform CREATE, READ, and UPDATE operations (CRUD)

## Technologies & Tools

- **Language**: Java
- **Database**: MariaDB
- **API**: JDBC (Java Database Connectivity)
- **Build**: Standard Java compilation
- **Database Driver**: MariaDB JDBC Driver

## Key Concepts Demonstrated

- **Database Connectivity**: Establishing and managing connections using DriverManager
- **SQL Operations**: INSERT, SELECT, and UPDATE queries with dynamic parameters
- **Prepared Data**: Handling user input and converting to database operations
- **ResultSet Processing**: Iterating through query results and displaying data
- **Exception Handling**: SQL exception management and error handling
- **Control Flow**: Menu-driven application with switch statements and loops

## Database Schema

The project uses a `products` table with the following structure:

| Column    | Type        | Description           |
|-----------|-------------|----------------------|
| ProductID | INT         | Unique product identifier |
| Name      | VARCHAR     | Product name          |
| Price     | DOUBLE      | Current product price |
| Sales     | DOUBLE      | Sales performance metric |

## Price Adjustment Logic

The application implements intelligent price updates:
- **If Sales ≥ Goal**: Increase price by 5%
- **If Sales < Goal**: Decrease price by 10%

## How to Use

1. Configure database connection details in `Main.java` (URL, username, password)
2. Compile: `javac Main.java`
3. Run: `java Main`
4. Select from menu options:
   - Insert new products
   - View all products
   - Adjust prices based on sales performance
   - Exit application

## Learning Outcomes

This project demonstrates proficiency in:
- JDBC API for database programming
- SQL query execution and result handling
- User interface design with command-line menus
- Database connection management
- Real-world application of relational databases in Java applications
