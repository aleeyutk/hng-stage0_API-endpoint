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

1. Clone the repository:
```bash
git clone https://github.com/aleeyutk/hng-stage0_API-endpoint.git
cd hng-stage0_API-endpoint/profile-api
