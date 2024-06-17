# User Fetch and Register API

This project is a Spring Boot application for user registration and fetching user details. It provides RESTful API endpoints to register new users and retrieve user information by username.

## Prerequisites

- Java 17
- Maven

## Getting Started

### Clone the repository

```bash
git clone https://github.com/yourusername/userfetchandregister.git
cd userfetchandregister

### Build the project

```bash
mvn clean install
```

### Run the application

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

## API Endpoints

### Register a new user

- **URL**: `/api/user/register`
- **Method**: `POST`
- **Description**: Register a new user with a username, email, and password.
- **Request Body**:

```json
{
  "username": "john",
  "email": "john@example.com",
  "password": "password",
  "firstName": "John",
  "lastName": "Sanders"
}
```

- **Responses**:
    - `201 Created`: User registered successfully.
    - `500 Internal Server Error`: User registration failed.

### Fetch user details

- **URL**: `/api/user/fetch`
- **Method**: `GET`
- **Description**: Fetch user details by username.
- **Query Parameter**: `username` (required)
- **Responses**:
    - `200 OK`: User found.
    - `404 Not Found`: User not found.

### Sample CURL Commands

#### Register a new user

```bash
curl -X POST http://localhost:8080/api/user/register -H "Content-Type: application/json" -d '{"username":"john","email":"john@example.com","password":"password","firstName":"John","lastName":"Sanders"}'
```

#### Fetch user details

```bash
curl -X GET "http://localhost:8080/api/user/fetch?username=john"
```

## Swagger API Documentation

This project uses Springdoc OpenAPI for API documentation. Once the application is running, you can access the API documentation at:

```
http://localhost:8080/swagger-ui.html
```

## Additional Pages

- **Home Page**: `GET /`
- **API Home Page**: `GET /api`
- **User API Home Page**: `GET /api/user`
- **Register Page**: `GET /register`
- **Fetch Page**: `GET /fetch`

## Exception Handling

The application includes basic exception handling for user registration and fetching. If an exception occurs during registration, a `500 Internal Server Error` response is returned. If the user is not found during the fetch operation, a `404 Not Found` response is returned.

## Running Tests

To run the unit tests for the application, use the following command:

```bash
mvn test
```