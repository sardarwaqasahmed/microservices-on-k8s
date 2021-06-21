# stakater-frontend-app

## Requirements

For building and running the application you need:

- [JDK 8]
- [Maven ](https://maven.apache.org)

## Build the application locally

```shell
mvn clean install
```


## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.demo.stakater.StakaterBEApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Deploying the application to Docker

Execute below commands to build and run docker file.

```shell
docker build -t <image-name> .
docker run -dit --name <container-name> -p 8081:8081
```

All the configurations are present in application.yml file.


## Note to the reader

 Future enhancements

1. This is front end api and exposed outside k82 cluster. For accessing this front service you need to call below url

```shell
docker build -t <image-name> .
docker run -dit --name <container-name> -p 8081:8081
```