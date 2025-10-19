# hng-stage0_API-endpoint
# Profile API with Cat Facts

A Spring Boot REST API that returns profile information along with dynamic cat facts from an external API.

## Features

- RESTful API endpoint `/api/me`
- Integration with Cat Facts API (https://catfact.ninja/fact)
- Dynamic timestamp in ISO 8601 format
- Graceful error handling with fallback cat facts
- Proper JSON response structure
- Health check endpoint

# 🐾 Profile API — Spring Boot Backend

A simple RESTful API that returns my profile information and a dynamic **cat fact** fetched from the [Cat Facts API](https://catfact.ninja/fact).

This project was built as part of an internship backend task to demonstrate:
- Consuming third-party APIs
- Returning structured JSON data
- Using dynamic timestamps
- Handling errors gracefully in Spring Boot

---

## 🚀 Endpoint

**GET** `/me`

Returns your profile information and a fresh cat fact with each request.

### ✅ Example Response
```json
{
  "status": "success",
  "user": {
    "email": "aliyuhaidara@gmail.com",
    "name": "Aliyu Haidara",
    "stack": "Java/Spring Boot"
  },
  "timestamp": "2025-10-19T22:41:01.773Z",
  "fact": "Cats sleep 70% of their lives."
}


## Tech Stack

- Java 17
- Spring Boot 3.1.0
- Maven
- REST Template for external API calls

## Local Development

### Prerequisites

- Java 17 or higher
- Maven 3.6+

### Installation

#1. Clone the repository:
```bash
git clone https://github.com/aleeyutk/hng-stage0_API-endpoint.git
cd hng-stage0_API-endpoint/profile-api

#2. Build the application:
#bash
mvn clean package

3.Run the application:
#bash
mvn spring-boot:run
## The API will be available at http://localhost:8080


