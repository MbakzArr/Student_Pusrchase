Here's a sample `README.md` file for your GitHub repository, incorporating the details of your project and code functionalities:

---

# Merch and Student Management API

This project is a Spring Boot application that manages merchandise items and student data. It includes a fully implemented REST API that allows users to perform various CRUD operations (Create, Read, Update, Delete) on both merch items and student information.

## Features Implemented

### Merch Item Management
- **Create Merch Item:** Add a new merch item to the database. (Due: 30 Sep 2024)
- **Get All Merch Items:** Retrieve a list of all available merch items. (Due: 30 Sep 2024)
- **Get Merch Items by Category:** Retrieve all merch items belonging to a specific category (e.g., T-Shirts, Track Pants, Socks). (Due: 30 Sep 2024)
- **Update Merch Item Price:** Update the price of a merch item using its ID.
- **Update Merch Item Quantity:** Update the quantity of a merch item using its ID.
- **Delete Merch Item by ID:** Remove a merch item from the database using its ID.
- **Delete All Merch Items in Category (SOCKS):** Remove all merch items categorized as "SOCKS."

### Student Management
- **Register Student:** Add a new student to the system with an encoded (hashed) password.
- **Get All Students:** Retrieve a list of all registered students.
- **Update Student Name:** Update the name of a student using their ID.
- **Update Student Surname:** Update the surname of a student using their ID.
- **Update Student Password:** Update a student's password using their ID (password is stored as an encoded hash).

## Tools and Technologies

- **Spring Boot 3.3.4** for the backend API.
- **PostgreSQL** for database management.
- **Postman** for API testing.

## Endpoints

### Merch Item Endpoints

| Method | Endpoint                       | Description                                           |
|--------|--------------------------------|-------------------------------------------------------|
| POST   | `/api/merchitems`              | Add a new merch item.                                 |
| GET    | `/api/merchitems`              | Get all merch items.                                  |
| GET    | `/api/merchitems/{id}`         | Get a single merch item by ID.                        |
| GET    | `/api/merchitems/category/{category}` | Get all merch items by category.                |
| PUT    | `/api/merchitems/{id}/price`   | Update price of a merch item by ID.                   |
| PUT    | `/api/merchitems/{id}/quantity`| Update quantity of a merch item by ID.                |
| DELETE | `/api/merchitems/{id}`         | Delete a merch item by ID.                            |
| DELETE | `/api/merchitems/category/socks`| Delete all merch items in the SOCKS category.         |

### Student Endpoints

| Method | Endpoint                       | Description                                           |
|--------|--------------------------------|-------------------------------------------------------|
| POST   | `/api/students/register`       | Register a new student with encoded password.         |
| GET    | `/api/students`                | Get all students.                                     |
| PUT    | `/api/students/{id}/name`      | Update student's name.                                |
| PUT    | `/api/students/{id}/surname`   | Update student's surname.                             |
| PUT    | `/api/students/{id}/password`  | Update student's password (hashed).                   |

## How to Test the API

1. **Install PostgreSQL:**
   Ensure that PostgreSQL is installed and running on your system. Update the database connection details in the `application.properties` or `application.yml` file.

2. **Run the Spring Boot Application:**
   ```
   mvn spring-boot:run
   ```

3. **Test Using Postman:**
   Import the following endpoints into Postman to test the API functionality:
   
   - **Create Merch Item:**
     - Method: `POST`
     - URL: `/api/merchitems`
     - Body (JSON):
       ```json
       {
         "name": "T-Shirt",
         "category": "T_SHIRTS",
         "price": 25.99,
         "quantity": 50
       }
       ```

   - **Update Merch Item Price:**
     - Method: `PUT`
     - URL: `/api/merchitems/{id}/price`
     - Body (JSON):
       ```json
       {
         "price": 19.99
       }
       ```

   - **Update Student Password:**
     - Method: `PUT`
     - URL: `/api/students/{id}/password`
     - Body (JSON):
       ```json
       {
         "newPassword": "newpassword123"
       }
       ```

4. **Testing Deadlines:**
   - Complete testing of endpoints to get all merch items and get merch items by category by **30 Sep 2024** using Postman.

## Project Structure

- `DemoApplication.java`: Entry point for the Spring Boot application.
- `service/`: Contains service layer logic for both merch item and student management.
- `entity/`: Defines entity classes `MerchItem` and `Student`.
- `repository/`: Interfaces for interacting with the PostgreSQL database.
- `controller/`: REST controllers to handle API requests.
- `resources/`: Contains configuration files, such as `application.properties` for setting up the database.

## Installation

1. Clone the repository:
   ```
   git clone https://github.com/yourusername/merch-student-api.git
   ```
2. Navigate into the project directory:
   ```
   cd merch-student-api
   ```
3. Install dependencies:
   ```
   mvn clean install
   ```
4. Set up your PostgreSQL database and update your `application.properties` file with the database URL, username, and password.

## Future Improvements

- Add comprehensive error handling and validation for all endpoints.
- Implement pagination for retrieving merch items and students.
- Add more detailed logging for better traceability.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
