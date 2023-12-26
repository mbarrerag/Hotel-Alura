
# Hotel Alura - Java Application with Hibernate ORM

Hotel Alura is a simple Java application designed for managing hotel-related information using Hibernate as an Object-Relational Mapping (ORM) tool. This application allows you to perform CRUD (Create, Read, Update, Delete) operations on hotel entities, utilizing the power of Hibernate to interact with the underlying relational database.

## Requirements

- Java Development Kit (JDK) 8 or later
- Hibernate ORM
- Database (e.g., MySQL, PostgreSQL) and corresponding JDBC driver
- Build tool (e.g., Maven or Gradle)

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
