# Company-Employee Microservices

A simple Spring Boot 3 system to manage companies and their staff using microservices architecture.

### Structure
Config Server (8888): Holds all the .yml files.
Eureka Server (8761): Service discovery (where everyone meets).
API Gateway (8222): The main entry point. All requests go through here.
Employee Service (8090)
Company Service (8070)

### Tech Stack
Java 21 / Spring Boot 3
PostgreSQL
OpenFeign (Service-to-service communication)
Lombok 

### Quick Start
Run them in this order: Config -> Eureka -> Services -> Gateway.