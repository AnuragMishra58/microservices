<h1 align="center"> Spring Microservice Design Patterns - Online Banking System </h1>
<h2 align="left">Languages and Tools:</h2>
<p align="left"> <a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a> <a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> </a> </p>
<br/>
<h2>Microservices</h2>

* <h3>Account Management Service</h3>
* <h3>Transaction Service</h3>
* <h3>Notification Service</h3>
* <h3>Audit Service</h3>
* <h3>Fraud Detection Service</h3>

<br/>

<h2>Tasks 1 & 2:-</h2>

* Transaction services receives request to initiate transaction
* Transaction service calls account service to credit/debit account
* Transaction service process transaction and sends <b>TransactionCompleted</b> or <b>TransactionFailed</b> Event 
* Account Service listens to <b>TransactionFailed</b> event and reverts account balance
* Fraud Service listens to <b>TransactionCompleted</b> event and analyses transaction
* If transaction is Fraud, it sends <b>SuspiciousTransaction</b> Event
* Notification Service listens to <b>SuspiciousTransaction</b> Event and sends out email notification

<h2> Postman Script </h2>
Postman API test scripts can be found below.
[link](./postman-collection/BankingApp.postman_collection.json)

## Testing Screenshots:-

### 1. Create Account
![img1.png](img1.png)
### 2. Initiate Transaction:-
![img2.png](img2.png)
### 3. Kafka Transaction Completed Topic:-
![img3.png](img3.png)
### 4. Updated Account
![img4.png](img4.png)
### 5. Initiate another Transaction
![img5.png](img5.png)
### 6. Transaction Failed Topic
![img6.png](img6.png)
### 7.Account balance reverted:-
![img7.png](img7.png)
### 8.Initiate Suspicious Transaction with Amount > 50000
![img7.png](img8.png)
### 9.Fraud Service listens TransactionCompletedEvent and Analyses Transaction
 #### Transaction Completed Topic
 ![img9.png](img9.png)
 #### Suspicious Activity Topic
 ![img10.png](img10.png)

### 10.Notification Service Sends Email for Suspicious Activity
![img11.png](im11.png)
