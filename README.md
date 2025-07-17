# CabBookingSystem
Oop semester project

PROJECT OVERVIEW:
-----------------
This is a Cab Booking System developed i developed with my fellows as a project for the Object-Oriented Programming (OOP) course. 
It uses core OOP principles, file handling for data persistence, and a user-friendly GUI. The system includes 
separate panels for Admin, Driver, and Customer with a complete login and signup mechanism.

FEATURES:
---------
GENERAL:
- Developed using Object-Oriented Programming in Java
- Interactive Graphical User Interface (GUI) using Java Swing
- File handling used to save and retrieve data

USER ROLES:
-----------
1. ADMIN PANEL:
   - View all users (drivers and customers)
   - View and manage bookings
   - Remove drivers

2. DRIVER PANEL:
   - View assigned rides
   - Update availability
   - View ride history

3. CUSTOMER PANEL:
   - Register and log in
   - Book a cab
   - View ride history
   - Rate drivers (optional)

AUTHENTICATION:
---------------
- Signup/Login system for Admin, Driver, and Customer
- Role-based access control
- Duplicate account prevention and basic input validation

FILE HANDLING:
--------------
- All records saved using text files

TECHNOLOGIES USED:
------------------
- Programming Language: Java
- GUI: Java Swing
- Storage: File Handling (Text Files)
- Concepts: OOP - Inheritance, Polymorphism, Encapsulation, Abstraction

OOP CONCEPTS USED:
------------------
1. CLASS & OBJECT – Classes for User, Driver, Admin, Customer, Cab, Booking
2. INHERITANCE – User class extended by Driver, Admin, and Customer
3. POLYMORPHISM – Overridden methods for different user roles
4. ENCAPSULATION – Private fields with getters and setters
5. ABSTRACTION – Abstract class for common user functionality

HOW TO RUN:
-----------
1. Open the project in any Java IDE like IntelliJ, NetBeans, or Eclipse
2. Compile all `.java` files
3. Run the main file (i.e OopProj.java)
4. Use the GUI for login/signup and begin interacting with the system

AUTHOR:
-------
Name: Alina Raza
Student of Software Engineering
COMSATS University Islamabad

FUTURE IMPROVEMENTS:
--------------------
- Use a database (like MySQL) instead of text files
- Improve GUI with modern design and better navigation
- Add notifications for booking status

LICENSE:
--------
This project is for academic and educational use only.
