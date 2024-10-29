
# Ecommerce App Backend - Spring Boot

Backend service for the **Ecommerce App**, built with **Spring Boot**. This backend is designed to manage the core functionalities of an online ecommerce platform, including user authentication, product management, order processing, and payment integration.

## Features

- **User Management**: Sign up, login, and role-based access control for customers and admins.
- **Product Management**: Add, edit, delete, and view products with categorization and inventory tracking.
- **Order Processing**: Manage shopping carts, orders, and order history.
- **Payment Integration**: Integrated with Stripe for secure and seamless payments.
- **RESTful API**: Clean, standardized API endpoints to serve the frontend application.
- **Security**: HTTPS support, secure user data storage, and integration with Okta for OAuth2-based authentication.

## Technologies Used

- **Spring Boot**: Core framework for building REST APIs.
- **Hibernate**: ORM for database management.
- **MySQL**: Relational database for storing ecommerce data.
- **Stripe API**: For handling payment processing.
- **Okta**: For secure user authentication and authorization.
- **Maven**: For project dependency management.

## Getting Started

### Prerequisites
- **Java 17+**
- **MySQL** installed and running
- **Maven** for dependency management
- **Okta** account and project created (refer to [Okta.com](https://help.okta.com/asa/en-us/content/topics/adv_server_access/docs/setup/create-a-project.htm)) 

### Installation and Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/devraider/ecommerce-app-backend-springboot.git
   cd ecommerce-app-backend-springboot
   ```

2. **Configure Database:**
    - Ensure your MySQL server is running.
    - Update the `application.properties` or `.env` file with your MySQL credentials.

3. **Configure Environment Variables:**
    - Replace sensitive information in the application configuration with your own (e.g., Stripe API key, Okta client ID, and issuer).
    - Example variables you might need to set up:
      ```properties
      STRIPE_KEY_SECRET=<your_stripe_secret_key>
      OKTA_OAUTH2_CLIENT_ID=<your_okta_client_id>
      OKTA_OAUTH2_ISSUER=<your_okta_issuer_url>
      ```

4. **Build and Run the Application:**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

5. **Access API Documentation** (if Swagger is enabled):
    - Go to `http://localhost:9898/swagger-ui.html` for API documentation and testing.

## API Endpoints

- **/api/users**: User registration and management
- **/api/products**: Product listing and management
- **/api/orders**: Order processing
- **/api/cart**: Shopping cart management
