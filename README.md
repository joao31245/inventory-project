# E-commerce Inventory and Order Management System
This project is a cloud-native e-commerce inventory and order management system built with Spring Boot 3, DynamoDB, EC2, and various AWS Services. It enables admins to manage inventory, customers to place orders, and ensures scalable, secure API access.

## Features
### Inventory Management
Add/Update/Delete Products: Admins can manage the product catalog by adding, updating, or deleting products.
View Product Details: Customers can view available products with details such as name, price, and stock quantity.
### Order Processing
Place Orders: Customers can place orders by selecting products and specifying quantities.
Order Confirmation: The system verifies stock availability and deducts quantities upon order confirmation.
Stock Alerts: Alerts for low stock levels via AWS SNS.
### User Management
User Registration/Login: Basic user registration and login functionality.
User Roles: Differentiate access between customers and admins.
## Project Architecture
### 1. Backend (Spring Boot on EC2)
The backend is built using Spring Boot and deployed on an AWS EC2 instance.
It exposes REST APIs for inventory and order management, integrating with ### DynamoDB for persistent storage.
### 2. Data Layer (DynamoDB)
Products Table: Stores details about products, such as productId, name, price, and stockQuantity.
Orders Table: Stores order data, including orderId, userId, productIds, quantity, and status.
Users Table: Contains user information with fields like userId, username, password, and role.
### 3. API Gateway
AWS API Gateway serves as a secure entry point for accessing backend APIs.
Manages routes for endpoints like /products, /orders, and /users.
### 4. SNS for Notifications
Amazon SNS (Simple Notification Service) sends notifications such as order confirmations and low stock alerts.
### 5. Monitoring with CloudWatch
CloudWatch is configured to monitor system performance, log errors, and set up alerts for critical metrics.
## Getting Started
### Prerequisites
Java 17 or higher
AWS CLI configured with IAM credentials
Spring Boot and Maven
Installation
Clone this repository:

bash
Copiar código
git clone https://github.com/joao31245/inventory-project.git
cd ecommerce-management-system
Configure DynamoDB tables on AWS and set up appropriate permissions.

## Set up an EC2 instance:

Launch an EC2 instance with Java installed.
Adjust security groups to allow HTTP/HTTPS and SSH access.
Deploy the Spring Boot application:

Package and deploy the application JAR to the EC2 instance.
Start the application on the server.
Usage
Inventory Management: Admins can add/update/delete products via the /products API.
Order Processing: Customers can place orders via the /orders API.
User Management: Users can register and login through the /users API.
Additional AWS Services
API Gateway: Configured as a public-facing API for secured access.
SNS: Integrated for notifications, such as order confirmations and low stock alerts.
Monitoring and Alerts
Use CloudWatch for performance monitoring and error tracking.
Alerts configured for system health and error rate spikes.
Future Enhancements
Add caching with Amazon ElastiCache.
Implement authentication with Amazon Cognito.
Extend functionalities to include payment processing integration.

## License
This project is licensed under the MIT License - see the LICENSE file for details.

