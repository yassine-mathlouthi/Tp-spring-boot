# Tp-Spring-Boot — University Dormitory Management API

A RESTful Spring Boot application for managing university dormitory (foyer) resources, including rooms (chambres), blocks, students, reservations, and universities.

---

## Table of Contents

- [Overview](#overview)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Domain Model](#domain-model)
- [REST API Endpoints](#rest-api-endpoints)
- [Configuration](#configuration)
- [Getting Started](#getting-started)
- [API Documentation (Swagger)](#api-documentation-swagger)
- [Running Tests](#running-tests)

---

## Overview

This project is a TP (practical work) exercise built with Spring Boot 3. It exposes a REST API to perform CRUD operations on dormitory-related entities such as **Chambres** (rooms), **Blocs**, **Foyers**, **Etudiants** (students), **Reservations**, and **Universités**.

---

## Tech Stack

| Technology | Version |
|---|---|
| Java | 17 |
| Spring Boot | 3.4.4 |
| Spring Data JPA | (managed by Spring Boot) |
| Spring Web (REST) | (managed by Spring Boot) |
| MySQL | 8+ |
| Lombok | (managed by Spring Boot) |
| SpringDoc OpenAPI (Swagger UI) | 2.8.6 |
| Maven | 3.x |

---

## Project Structure

```
demo/
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/
│   │   │   ├── DemoApplication.java          # Application entry point
│   │   │   ├── control/
│   │   │   │   └── ChambreRestController.java # REST controller for Chambre
│   │   │   ├── entity/
│   │   │   │   ├── Bloc.java
│   │   │   │   ├── Chambre.java
│   │   │   │   ├── Etudiant.java
│   │   │   │   ├── Foyer.java
│   │   │   │   ├── Reservation.java
│   │   │   │   ├── TypeChambre.java           # Enum: SIMPLE, DOUBLE, TRIPLE
│   │   │   │   └── Universite.java
│   │   │   ├── repository/
│   │   │   │   ├── BlocRepository.java
│   │   │   │   ├── ChambreRepository.java
│   │   │   │   ├── EtudiantRepository.java
│   │   │   │   ├── FoyerRepository.java
│   │   │   │   ├── ReservationRepository.java
│   │   │   │   └── UniversiteRepository.java
│   │   │   └── service/
│   │   │       ├── IChambreService.java       # Service interface
│   │   │       └── ChambreServiceImpl.java    # Service implementation
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/com/example/demo/
│           └── DemoApplicationTests.java
├── pom.xml
└── mvnw / mvnw.cmd
```

---

## Domain Model

### Entities

| Entity | Key Fields |
|---|---|
| **Chambre** | `idChambre`, `numeroChambre`, `typeC` (TypeChambre enum) |
| **Bloc** | `idBloc`, `nomBloc`, `capaciteBloc` |
| **Foyer** | `idFoyer`, `nomFoyer`, `capaciteFoyer` |
| **Universite** | `idUniversite`, `nomUniversite`, `adresse` |
| **Etudiant** | `idEtudiant`, `nomEt`, `prenomEt`, `cin`, `ecole`, `dateNaissance` |
| **Reservation** | `idReservation`, `anneeUniversitaire`, `estValide` |

### Room Types (`TypeChambre`)

```
SIMPLE   – single-occupancy room
DOUBLE   – double-occupancy room
TRIPLE   – triple-occupancy room
```

---

## REST API Endpoints

Base URL: `http://localhost:8089/tpfoyer`

### Chambre

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/chambre/retrieve-all-chambres` | Retrieve all rooms |
| `GET` | `/chambre/retrieve-chambre/{chambre-id}` | Retrieve a room by ID |
| `POST` | `/chambre/add-chambre` | Add a new room |
| `PUT` | `/chambre/modify-chambre` | Update an existing room |
| `DELETE` | `/chambre/remove-chambre/{chambre-id}` | Delete a room by ID |

#### Example Request Body (POST / PUT)

```json
{
  "numeroChambre": 101,
  "typeC": "SIMPLE"
}
```

---

## Configuration

All configuration lives in `demo/src/main/resources/application.properties`:

```properties
spring.application.name=demo

# MySQL datasource
spring.datasource.url=jdbc:mysql://localhost:3307/tp?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA / Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

# Server
server.port=8089
server.servlet.context-path=/tpfoyer
```

> **Note:** The application expects a MySQL server running on port **3307**. Update `spring.datasource.url`, `username`, and `password` to match your local setup.

---

## Getting Started

### Prerequisites

- Java 17+
- Maven 3.x (or use the included `mvnw` wrapper)
- MySQL 8+ running on port 3307 (or adjust the config)

### Steps

1. **Clone the repository**

   ```bash
   git clone https://github.com/yassine-mathlouthi/Tp-spring-boot.git
   cd Tp-spring-boot/demo
   ```

2. **Configure the database**

   Edit `src/main/resources/application.properties` and set your MySQL credentials.

3. **Build the project**

   ```bash
   ./mvnw clean package
   ```

4. **Run the application**

   ```bash
   ./mvnw spring-boot:run
   ```

   The API will be available at: `http://localhost:8089/tpfoyer`

---

## API Documentation (Swagger)

SpringDoc OpenAPI is included. Once the application is running, access the interactive Swagger UI at:

```
http://localhost:8089/tpfoyer/swagger-ui/index.html
```

The raw OpenAPI JSON spec is available at:

```
http://localhost:8089/tpfoyer/v3/api-docs
```

---

## Running Tests

```bash
./mvnw test
```
