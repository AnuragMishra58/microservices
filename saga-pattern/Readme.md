<h1 align="center"> Implementing Saga Pattern in Spring Boot:</h1>
<h3 align="left">Languages and Tools:</h3>
<p align="left"> <a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a> <a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> </a> </p>

<h2>Saga Flow:</h2>

* OrderService receives a request to place an order.
* It sends OrderPlaced event for InventoryService
* InventoryService checks Inventory and sends StockReserved Event To Payment Service
* PaymentService listens to StockReserved Event and process payment
* PaymentService sends PaymentSuccessEvent to Notification Service if Payment is successful
* PaymentService sends PaymentFailed Event to Order Service and Notification Service
* Order Service would cancel the order when Event Fails
* Notification Service sends order succes/failed notifaction to customer

<h2> Postman Script </h2>
Postman API test scripts can be found below.
[link](./postman-collection/Saga-via-Kafka.postman_collection.json)

### Create Product Inventory
![img1.png](img1.png)
### Create Order
![img2.png](img2.png)
### Kafka "Order Placed" topic after 6 Orders processed by Order Service:-
![img3.png](img3.png)
### Kafka "Inventory Reserved" After 6 Orders process by Inventory Service:-
![img4.png](img4.png)
### Kafka "Payment Failed" and "Payment Success" Topic Events After 6 Orders are process by Payment Service:-
![img5.png](img5.png)
### Order cancelled using fallback(Saga Pattern) if Payment is Failed Otherwise Order procesed successfully:-
![img6.png](img6.png)
### Order Confirmation/Cancellation Notifications SMTP:-
![img7.png](img7.png)

