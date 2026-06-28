# PrayerTracker API

A secure REST API for tracking pending daily prayers, built with **Spring Boot**, **Firebase Authentication**, **Spring Security**, and **PostgreSQL**. The API authenticates users using Firebase ID Tokens and securely stores prayer data in a PostgreSQL database hosted on Neon.

---

## Features

- 🔐 Firebase Authentication using Firebase ID Tokens
- 🛡️ Spring Security with Bearer Token authentication
- ➕ Add pending prayers
- 📋 Retrieve authenticated user's pending prayers
- ❌ Delete pending prayers
- ✅ Request validation using Jakarta Validation
- 🚫 Global exception handling with structured error responses
- 📦 Flyway database migrations
- 🗄️ PostgreSQL database hosted on Neon
- 🌱 Enum-based prayer model for type safety

---

## Tech Stack

| Technology | Purpose |
|------------|---------|
| Java 17 | Programming Language |
| Spring Boot | Backend Framework |
| Spring Security | Authentication & Authorization |
| Firebase Admin SDK | Token Verification |
| Spring Data JPA | ORM |
| PostgreSQL | Database |
| Neon | Cloud PostgreSQL Hosting |
| Flyway | Database Migrations |
| Maven | Dependency Management |
| Lombok | Boilerplate Reduction |

---

## Project Structure

```
src
├── main
│   ├── java
│   │   └── com.anas.prayertracker_api
│   │       ├── config
│   │       ├── controller
│   │       ├── dto
│   │       ├── entity
│   │       ├── enums
│   │       ├── exception
│   │       ├── repository
│   │       ├── security
│   │       └── service
│   └── resources
│       ├── db
│       │   └── migration
│       └── application.yml
```

---

## Authentication

This API uses **Firebase Authentication**.

Every protected endpoint requires a Firebase ID Token in the request header.

Example:

```http
Authorization: Bearer <FIREBASE_ID_TOKEN>
```

The backend verifies the token using the Firebase Admin SDK and automatically extracts the authenticated user's Firebase UID.

The client **never sends the Firebase UID** in the request body.

---

## API Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/api/prayers` | Add a pending prayer |
| GET | `/api/prayers` | Get authenticated user's pending prayers |
| DELETE | `/api/prayers` | Delete a pending prayer |
| GET | `/health` | Health check |

---

## Sample Request

### Add Prayer

**POST** `/api/prayers`

Headers

```http
Authorization: Bearer <FIREBASE_ID_TOKEN>
Content-Type: application/json
```

Body

```json
{
  "prayerName": "MAGHRIB",
  "prayerDate": "2026-06-29"
}
```

---

## Sample Response

```json
{
  "id": 9,
  "firebaseUid": "firebase-generated-uid",
  "prayerName": "MAGHRIB",
  "prayerDate": "2026-06-29",
  "createdAt": "2026-06-28T23:03:12.3330063"
}
```

---

## Validation

The API validates incoming requests using Jakarta Bean Validation.

Example validation response:

```json
{
  "timestamp": "2026-06-29T00:46:20.1864906",
  "status": 400,
  "error": "Bad Request",
  "message": "Prayer name is required"
}
```

---

## Database

The application uses **PostgreSQL** hosted on **Neon**.

Database schema changes are managed through **Flyway** migrations.

---

## Running Locally

### Prerequisites

- Java 17+
- Maven
- PostgreSQL (or Neon database)
- Firebase Project
- Firebase Service Account JSON

### Clone the repository

```bash
git clone https://github.com/<your-username>/prayertracker-api.git
cd prayertracker-api
```

### Configure environment variables

```
DB_URL=<your_database_url>
DB_USERNAME=<your_database_username>
DB_PASSWORD=<your_database_password>
```

Place your Firebase service account JSON file in:

```
src/main/resources/firebase/firebase-service-account.json
```

### Run the application

```bash
mvn spring-boot:run
```

The API will start on:

```
http://localhost:8082
```

---

## Security

The following files are intentionally excluded from version control:

- Firebase Service Account JSON
- Environment variables
- IDE configuration
- Build artifacts

---

## Future Improvements

- Swagger / OpenAPI Documentation
- Unit & Integration Tests
- Docker Support
- CI/CD Pipeline
- Deployment to Railway or Render
- Prayer History
- Reminder Notifications
- Analytics Dashboard

---


## Author

**Ibrahim Anas**

Backend Developer | Java | Spring Boot | PostgreSQL

GitHub: https://github.com/anas-ib

LinkedIn: https://linkedin.com/in/ibrahimanas
