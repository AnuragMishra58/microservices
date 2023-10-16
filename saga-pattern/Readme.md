# Implementing Saga in Spring Boot:

## Saga Flow:

* OrderService receives a request to place an order.
* It sends OrderPlaced event for InventoryService
* InventoryService checks Inventory and sends StockReserved Event To Payment Service
* PaymentService listens to StockReserved Event and process payment
* PaymentService sends PaymentSuccessEvent to Notification Service if Payment is successful
* PaymentService sends PaymentFailed Event to Order Service and Notification Service
* Order Service would cancel the order when Event Fails
* Notification Service sends order succes/failed notifaction to customer

## Postman Script
Postman API test scripts can be found below.
[link](./postman-collection/Saga-via-Kafka.postman_collection.json)
