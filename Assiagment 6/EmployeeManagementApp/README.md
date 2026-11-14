# EmployeeManagementApp – Java Swing with JDBC

This project implements the **CSIT751 Core Java, Module VI** practical assignment.

## Features

- Java Swing desktop form to enter Employee ID, Name, Department and Salary.
- Saves employee records to MySQL using JDBC and `PreparedStatement`.
- Displays all employee records in a `JTable` inside the Swing window.
- Validates form input and reports database errors.

## Technologies

- Java 8 or later
- Java Swing
- JDBC
- MySQL 8+
- Maven
- MySQL Connector/J

## Project structure

```text
EmployeeManagementApp/
├── pom.xml
├── README.md
├── .gitignore
├── database/
│   └── schema.sql
└── src/
    └── main/
        └── java/
            └── com/
                └── employeemanagement/
                    ├── DatabaseConnection.java
                    └── EmployeeManagementApp.java
```

## 1. Create the database

Start MySQL, then run the SQL script in MySQL Workbench or the MySQL command line:

```sql
CREATE DATABASE IF NOT EXISTS company_db;
USE company_db;

CREATE TABLE IF NOT EXISTS employees (
    emp_id INT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(50),
    salary DECIMAL(10,2)
);
```

The same SQL is available in `database/schema.sql`.

## 2. Configure the database login

The default connection settings are:

- URL: `jdbc:mysql://localhost:3306/company_db`
- Username: `root`
- Password: empty

If your MySQL username or password is different, configure it using environment variables before running.

**Windows PowerShell:**

```powershell
$env:DB_USER="root"
$env:DB_PASSWORD="your_mysql_password"
```

Or pass Java system properties:

```bash
java -Ddb.user=root -Ddb.password=your_mysql_password -jar target/EmployeeManagementApp-1.0.0.jar
```

Do not commit real database passwords to GitHub.

## 3. Build and run

Install JDK 8+ and Maven. Open a terminal in the project folder and run:

```bash
mvn clean package
```

Then run:

```bash
java -jar target/EmployeeManagementApp-1.0.0.jar
```

You can also import the folder as an existing Maven project in Eclipse or IntelliJ IDEA and run `EmployeeManagementApp.java`.

## 4. Use the application

1. Enter a unique Employee ID (integer).
2. Enter the employee Name.
3. Enter the Department.
4. Enter Salary as a decimal value, for example `35000.50`.
5. Click **Submit** to insert the record into MySQL.
6. Click **View All Employees** to retrieve and display all records in the table.

## Upload to GitHub

Create an empty GitHub repository, then run these commands from this project folder:

```bash
git init
git add .
git commit -m "Add Employee Management Swing JDBC application"
git branch -M main
git remote add origin https://github.com/YOUR-USERNAME/EmployeeManagementApp.git
git push -u origin main
```

Replace `YOUR-USERNAME` with your GitHub username.

## Assignment requirement checklist

- [x] Swing form with Employee ID, Name, Department and Salary.
- [x] Submit button to save employee data.
- [x] View All Employees button.
- [x] MySQL database named `company_db`.
- [x] Table named `employees` with the specified columns and types.
- [x] JDBC database connection.
- [x] Insert records on form submission.
- [x] Retrieve and display all records in a Swing table.

## Notes

- Employee records are stored in MySQL; they are not just held in application memory.
- Employee ID is the primary key and must be unique.
- Run the SQL setup before launching the application.
