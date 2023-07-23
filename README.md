# Institute-Management-using-Java

This project is a institute management system developed using Java and MySQL. It allows users to search, view  and show institue details from a MySQL database.

## Requirements

To run this project, I use the following:

- VS code
- MySQL Server
- MySQL Connector/JDBC driver

## Installation

1. Clone this repository or download the zip file.
2. Install MySQL Server and create a new database.
3. Execute the SQL script `create_database.sql` to create the necessary tables.
4. Update the `DB_URL`, `DB_USER`, and `DB_PASSWORD` constants in the `DBConnection.java` file with your MySQL database information.
5. Add the MySQL Connector/J JAR file to your project's classpath.
6. Compile and run the `login.java` file.

## Usage

When the program starts, you will see login page. 

When the program starts after login, you will see a menu with the following options:
1. View institue details
2. Add a new institue details
3. Search any institue by institue_id
5. Exit



## Database Schema

The database schema for this project consists of a single table named `books`. The table has the following columns:

'Collage_id' int not null
'Name_of_the_college'  varchar(100) not null
'NAAC+Grade' varchar(10)  
'Location'  varchar(100) not null     
