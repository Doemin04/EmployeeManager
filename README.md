# Employee Management System (Console + MySQL + JDBC)

This is a **Console-Based Employee Management System** built with **Java** and **MySQL**.

It allows you to:
- Insert new employees
- Search employees (by Name, SSN, or ID)
- Update employee data
- Update salaries within a range
- View pay history
- Generate reports (pay by division, pay by job title)

✅ MySQL database connection (JDBC)  
✅ Console-based User Interface  
✅ No GUI needed (JavaFX not required)  

---

## 📦 Project Structure
- `Main.java` — Console UI entry point
- `Employee.java` — Abstract class for employee
- `FullTimeEmployee.java` — Employee subclass
- `PayStatement.java` — Salary history per employee
- `EmployeeManager.java` — Manages database operations
- `ReportService.java` — Reporting functions
- `DBConnection.java` — Handles MySQL connection
- `create_employeeDB.sql` — SQL file to create database/table
- `compile_and_run.bat` — Windows batch file to compile and run automatically

---

## ⚙️ Setup Instructions

### 1. Prerequisites
- Java JDK installed (version 8 or higher)
- MySQL server installed and running
- **MySQL Connector/J** `.jar` file downloaded

> 📥 Download MySQL Connector/J from [MySQL Official Site](https://dev.mysql.com/downloads/connector/j/).  
> Extract the ZIP, find the `.jar` file (example: `mysql-connector-java-8.0.33.jar`).

Place the `.jar` somewhere you can easily access (e.g., Desktop or Downloads folder).

### 2. Create Database and Table
1. Open MySQL Workbench or Command Line
2. Run the provided SQL script:
```sql
SOURCE create_employeeDB.sql;
```

It will:
- Create database `employeeDB`
- Create table `employeeData`

### 3. Edit `compile_and_run.bat`

Open `compile_and_run.bat` in a text editor and update the path to your MySQL Connector `.jar` file.

Example:
```
SET JAR_PATH=C:\Users\yourname\Downloads\mysql-connector-java-8.0.33.jar
```

Save the file.

### 4. Compile and Run

Now simply double-click `compile_and_run.bat`, or run it from Command Prompt:

```bash
./compile_and_run.bat
```

This will:
- Compile all `.java` files with the `.jar` included
- Launch the console application automatically

---

## 🔥 Manual Compile and Run (if not using .bat file)

If you prefer doing it manually from command line:

### Windows Command Prompt
```bash
javac -cp ".;path/to/mysql-connector-java-8.0.33.jar" *.java
java -cp ".;path/to/mysql-connector-java-8.0.33.jar" Main
```

### Linux or Mac Terminal
```bash
javac -cp ".:path/to/mysql-connector-java-8.0.33.jar" *.java
java -cp ".:path/to/mysql-connector-java-8.0.33.jar" Main
```

Replace `path/to/` with your actual `.jar` location.

---

## 🎯 Demo Functionalities

| Feature | Description |
|:--------|:------------|
| Add Employee | Add full-time employee |
| Search Employee | By Name, SSN, or Employee ID |
| Update Employee | Update fields like name, phone, email, etc. |
| Update Salary | Increase salary by a % within a salary range |
| View Pay History | Show employee's salary records |
| Reports | Total pay by division, total pay by job title |

---

## 📄 License
For educational use only.

---