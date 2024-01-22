

## Video: https://www.youtube.com/watch?v=caC4aM-6Tdk

![image](https://github.com/mbarrerag/Alura-Hotel/assets/101472701/633d9c37-6eee-4613-aee4-239f2cfb90fc)

![image](https://github.com/mbarrerag/Alura-Hotel/assets/101472701/694ac22c-d69e-4f52-8caa-52aeb925ecb0)

![image](https://github.com/mbarrerag/Alura-Hotel/assets/101472701/25af4306-6a9b-4d87-966a-ea3198ecd68a)

# Hotel Alura - Java Application with Hibernate ORM

Hotel Alura is a simple Java application designed for managing hotel-related information using Hibernate as an Object-Relational Mapping (ORM) tool. This application allows you to perform CRUD (Create, Read, Update, Delete) operations on hotel entities, utilizing the power of Hibernate to interact with the underlying relational database. It has a basic login with the corresponding procedure to save information about reserves and huespeds.
This project follow the DAO pattern and MVC pattern.
<hr>

The package Entities contains the classes that represent the tables in the database.
The package DAO contains the classes that make the connection with the database and the methods to save, update, delete and read the information.
The package Controller contains the classes that make the connection between the view and the model.
The package View contains the classes that show the information to the user and receive the information from the user.

## Features

# User Authentication System

Only hotel members should have access to the system.

# Reservation Management for Clients:

 Create, edit, and delete reservations for clients.

# Comprehensive Database Search:

 Retrieve all information from both clients and reservations stored in the database.

## Guest Data Management:

 Register, edit, and delete guest details.

# Reservation Cost Calculation:

Automatically calculate the reservation cost based on the number of days and a daily rate that can be set by you. For example, if a reservation is for 3 days and the daily rate is $20, the system should calculate and display the total cost (3 days * $20 = $60) before saving the reservation.


## Database Implementation:

Set up a database to store all the required data. Based on the business rules

## Setup

1. **Database Configuration:**
   - Create a database for the application (e.g., `hotel_alura`).
   - Update the `hibernate.cfg.xml` file with your database connection details.

2. **Build the Application:**
   - Build the application using your preferred build tool. For Maven, use the command:
     ```bash
     mvn clean install
     ```

3. **Run the Application:**
   - Run the application using the following command:
     ```bash
     java -jar target/hotel-alura.jar
     ```
   - Ensure that the Hibernate configuration and database connection are correctly set up.

## Usage

The Hotel Alura application provides a simple command-line interface for performing CRUD operations on hotel entities. The application supports the following commands:

- **1. Create a Hotel:**
  - Add a new hotel to the database.
  ```bash
  java -jar target/hotel-alura.jar createHotel "Hotel Name" "City"
  ```

- **2. Read Hotels:**
  - Retrieve a list of all hotels in the database.
  ```bash
  java -jar target/hotel-alura.jar readHotels
  ```

- **3. Update a Hotel:**
  - Update the details of an existing hotel.
  ```bash
  java -jar target/hotel-alura.jar updateHotel hotelId "New Hotel Name" "New City"
  ```

- **4. Delete a Hotel:**
  - Remove a hotel from the database.
  ```bash
  java -jar target/hotel-alura.jar deleteHotel hotelId
  ```

## Contributing

Contributions are welcome! If you have any suggestions, improvements, or bug fixes, feel free to open an issue or submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
