# Spring Boot CRUD example

This project is an example to show some different technological components and functionality around a CRUD based application.

The following technologies are used for this project:

- Spring Boot
- H2 embedded SQL database
- JPA + Hibernate
- Liquibase
- MapStruct
- Lombok
- REST

The application is built up in three layers:

- Presentation (Contains REST controllers, handling DTOs)
- Service (Contains services, handling model objects)
- Persistence (Contains repositories, handling entity objects)


Currently, the project is lacking of tests for e.g.:

- REST controllers
- Data repositories
- MapStruct mappings between bean objects
- To confirm that the data model is correctly realized through liquibase