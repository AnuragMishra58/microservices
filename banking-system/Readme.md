<h1 align="center"> Spring Microservice Design Patterns - Online Banking System </h1>
<h2 align="left">Languages and Tools:</h2>
<p align="left"> <a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="50" height="50"/> </a> <a href="https://kafka.apache.org/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/apache_kafka/apache_kafka-icon.svg" alt="kafka" width="50" height="50"/> </a> <a href="https://postman.com" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/getpostman/getpostman-icon.svg" alt="postman" width="50" height="50"/> </a> <a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="50" height="50"/> </a> </p>
<br/>
<h2>Key Microservice Patterns Used</h3>
<ul>
 <li><h4>API Gateway:</h4> Utilized Spring Cloud Gateway for routing requests and isolating internal microservice architectures from client apps.</li>
 <li><h4>Event-Driven System:</h4> Implemented events, channels, and queues to manage asynchronous communication between microservices.</li>
</ul>
<br/>
<h2>Microservices</h2>

* <h3>Account Management Service</h3>
* <h3>Transaction Service</h3>
* <h3>Notification Service</h3>
* <h3>Audit Service</h3>
* <h3>Fraud Detection Service</h3>

<br/>

<h2>Functional Workflow 1:-</h2>

* Transaction services receives request to initiate transaction
* Transaction service calls account service to credit/debit account
* Transaction service process transaction and sends <b>TransactionCompleted</b> or <b>TransactionFailed</b> Event 
* Account Service listens to <b>TransactionFailed</b> event and reverts account balance
* Fraud Service listens to <b>TransactionCompleted</b> event and analyses transaction
* If transaction is Fraud, it sends <b>SuspiciousTransaction</b> Event
* Notification Service listens to <b>SuspiciousTransaction</b> Event and sends out email notification

<h2>Functional Workflow 2- Audit Service Tracking Transactions</h2>

* Every transaction should be audited and logged, providing a trail for future references.
* This has been implemented using events TransactionCompleted and TransactionFailed
* Audit Service listens to both events and creates audit record

<h2> Postman Script </h2>
Postman API test scripts can be found below.
[link](./postman-collection/BankingApp.postman_collection.json)

## Workflow Screenshots:-

### 1. Create Account
![img1.png](./images/img1.png)
### 2. Initiate Transaction:-
![img2.png](./images/img2.png)
### 3. Kafka Transaction Completed Topic:-
![img3.png](./images/img3.png)
### 4. Updated Account
![img4.png](./images/img4.png)
### 5. Initiate another Transaction
![img5.png](./images/img5.png)
### 6. Transaction Failed Topic
![img6.png](./images/img6.png)
### 7.Account balance reverted:-
![img7.png](./images/img7.png)
### 8.Initiate Suspicious Transaction with Amount > 50000
![img7.png](./images/img8.png)
### 9.Fraud Service listens TransactionCompletedEvent and Analyses Transaction
 #### Transaction Completed Topic
 ![img9.png](./images/img9.png)
 #### Suspicious Activity Topic
 ![img10.png](./images/img10.png)

### 10.Notification Service Sends Email for Suspicious Activity
![img11.png](./images/img11.png)

### Task 3. Audit Service Tracking Transactions
![img12.png](./images/img12.png)

