### texo-challenge-api

## RESTful API for the Golden Raspberry Awards

This is a RESTful API developed in Spring Boot and Java 17 to facilitate the retrieval of information about nominees and winners in the Worst Film category of the Golden Raspberry Awards.

## Requirements

Ensure you have the following installed:

- Maven
- Java 17
- Spring Boot 3

## Building the Project

To build the project, navigate to the project folder and run the following command in a command prompt:

```
mvn clean package
```

## Running the Project

After building the project, you can run it using the following command:

```
java -jar texo-challenge-api-0.0.1-SNAPSHOT.jar
```

## Accessing the API

To interact with the API, you can use Postman. Import the Postman collection located at:

```
/texo-challenge-api/src/main/resources/doc/texo-challenge.postman_collection.json
```

This collection contains pre-configured requests to interact with the API endpoints.