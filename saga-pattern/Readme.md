<h1 align="center"> Implementing Saga Pattern in Spring Boot:</h1>
<h2 align="left">Languages and Tools:</h2>
<p align="left"> <a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a> <a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> </a> </p>
<br/>
<h2>Microservices</h2>

* <h3>Order Service</h3>
* <h3>Product Service</h3>
* <h3>Payment Service</h3>
* <h3>Notification Service</h3>
<br/>

<h2>Saga Flow:</h2>

* OrderService receives a request to place an order.
* It sends <b>OrderPlaced</b> event for InventoryService
* InventoryService checks Inventory and sends <b>StockReserved</b> Event To Payment Service
* PaymentService listens to <b>StockReserved</b> Event and process payment
* PaymentService sends <b>PaymentSuccessEvent</b> to Notification Service if Payment is successful
* PaymentService sends <b>PaymentFailedEvent</b> to Order Service and Notification Service
* Order Service would cancel the order when Event Fails
* Notification Service sends order succes/failed notifaction to customer

<h2> Postman Script </h2>
Postman API test scripts can be found below.
[link](./postman-collection/Saga-via-Kafka.postman_collection.json)

## Testing Screenshots:-

### 1. Create Product Inventory
![img1.png](img1.png)
### 2. Create Orders
![img2.png](img2.png)
### 3. Kafka "Order Placed" topic after 6 Orders processed by Order Service:-
![img3.png](img3.png)
### 4. Kafka "Inventory Reserved" After 6 Orders process by Inventory Service:-
![img4.png](img4.png)
### 5. Kafka "Payment Failed" and "Payment Success" Topic Events After 6 Orders are process by Payment Service:-
![img5.png](img5.png)
### 6. Order cancelled using fallback(Saga Pattern) if Payment is Failed Otherwise Order procesed successfully:-
![img6.png](img6.png)
### 7. Order Confirmation/Cancellation Notifications SMTP:-
![img7.png](img7.png)

