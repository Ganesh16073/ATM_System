ATM Application
Overview
The ATM Application is a console-based Java project simulating an ATM system. It allows users to perform essential banking operations such as login, balance checking, withdrawals, deposits, and registration of new accounts. The application implements core Java concepts like dynamic polymorphism, exception handling, and modular programming.

Features
User Authentication: Login using an account number and a 4-digit PIN.
Account Management:
Check account balance.
Withdraw money with validation for sufficient funds.
Deposit money with validation for negative values.
View account details.
User Registration: Create a new account with user details like name, account type, Aadhaar number, and PAN number.
Error Handling: Handles incorrect PINs, invalid inputs, and unexpected errors gracefully.
Technologies Used
Programming Language: Java
Database: MySQL (via JDBC)
Architecture: Layered architecture using interfaces and modular design.
Project Structure
The project is divided into the following packages:

ATMControler: Contains the main application logic (ATMApp class).
ATMModel: Defines the data models like LoginUser, AccountsData, and RegisterUser.
atmInterface: Provides interfaces for login and registration functionalities (LoginInterface, RegisterInterface).
Database: Implements database operations (LoginRepo, RegisterRepo) for user authentication and registration.
How to Run
Prerequisites:
Java Development Kit (JDK) 8 or later.
Eclipse IDE or any Java IDE.
MySQL database configured with the required schema and tables.
Steps to Execute:
Clone the Repository:

bash
Copy code
git clone https://github.com/Ganesh16073/ATM-Application.git
cd ATM-Application
Open in Eclipse:

Import the project as an existing Java project.
Configure the MySQL JDBC Driver in the lib folder or via project settings.
Database Setup:

Create the necessary database schema and tables for user accounts, transactions, etc., as per your requirements.
Run the Application:

Execute the ATMApp class from the ATMControler package.
Project Flow
Login/Registration Prompt:
Choose to log in or register a new account.
Login:
Enter account number and PIN.
Perform operations like checking balance, withdrawing, depositing, or viewing account details.
Registration:
Enter user details to register a new account.
Data is saved in the database for future login.
Error Handling
Handles incorrect PIN inputs with retries.
Validates account number and PIN format.
Prevents invalid amounts during deposits and withdrawals.
Future Enhancements
Add support for mini-statements and transaction history.
Introduce multi-factor authentication for enhanced security.
Contributing
Contributions are welcome! Feel free to submit a pull request for any enhancements or bug fixes.


Contact
For any queries or feedback, feel free to contact:

Author: Ganesh Kulkarni
Email:  ganeshkulkarni4237@gmail.com
GitHub: Ganesh16073
