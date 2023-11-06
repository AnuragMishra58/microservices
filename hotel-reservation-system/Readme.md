<h1 align="center"> Spring Microservices - Reservation System </h1>
<h2 align="left">Languages and Tools:</h2>
<p align="left"> <a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a> <a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> </a> </p>
<br/>
<p align="left"> <a href="https://www.docker.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/docker/docker-original-wordmark.svg" alt="docker" width="40" height="40"/> </a> <a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a> <a href="https://kafka.apache.org/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/apache_kafka/apache_kafka-icon.svg" alt="kafka" width="40" height="40"/> </a> <a href="https://postman.com" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/getpostman/getpostman-icon.svg" alt="postman" width="40" height="40"/> </a> <a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> </a> </p>
<h2>Microservices</h2>

* <h3>API Gateway: API Gateway Pattern to route to core services</h3>
* <h3>Eureka Registry: Used for service discovery/registration</h3>
* <h3>Customer Service: Handles customer profiles and preferences.</h3>
* <h3>Reservation Service: Manages reservation logic.</h3>
* <h3>Payment Service: Handles payment transactions.</h3>
* <h3>Hotel Management Service: Manages room inventories.</h3>
* <h3>Notification  Service: Sends out notifications.</h3>

<br/>

* <h3Key Microservice Patterns User</h3>
Saga Pattern: Primarily used in the refund process to ensure that a series of local transactions are all executed or compensated. Each step is an individual local transaction and has a compensating transaction.

Example: If the refund is not processed, the reservation is not cancelled, and the user is notified.

API Gateway Pattern: All client requests go through an API Gateway (Zuul/Spring Cloud Gateway), which routes requests to appropriate services.

Example: A user makes a reservation. The API gateway routes this request to the Reservation Service, which then talks to Payment Service and Hotel Management Service.



<h2> Postman Script </h2>
Postman API test scripts can be found below.
[link](./postman-tests/Capstone Project.postman_collection)

