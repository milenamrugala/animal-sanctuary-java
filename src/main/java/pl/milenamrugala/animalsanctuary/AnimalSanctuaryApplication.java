package pl.milenamrugala.animalsanctuary;

import org.springframework.boot.SpringApplication; // provides a convenient way to bootstrap a Spring application from a main method, starting the embedded server and initializing the Spring application context
import org.springframework.boot.autoconfigure.SpringBootApplication; // this annotation is a combination of three annotations: @Configuration, @EnableAutoConfiguration, and @ComponentScan, it is used to mark the main class of a Spring Boot application and triggers auto-configuration, component scanning, and allows defining extra beans in the context

@SpringBootApplication // this annotation is crucial in Spring Boot. It combines:
// @Configuration: indicates that the class can be used by the Spring IoC container as a source of bean definitions
// @EnableAutoConfiguration: tells Spring Boot to automatically configure your application based on the dependencies you have added, for example, if spring-webmvc is on the classpath, it will configure a web application
// @ComponentScan: enables component scanning, so Spring can discover and register beans in the application context, it scans the package of the annotated class and all sub-packages

public class AnimalSanctuaryApplication {

    public static void main(String[] args) {

        SpringApplication.run(AnimalSanctuaryApplication.class, args); // launches the Spring Boot application
    }

}
