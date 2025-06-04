# WeWatch - Movie Community Platform

WeWatch is a full-stack web application that allows users to browse, comment, and interact with movies in a modern and user-friendly interface. The platform is designed to resemble popular streaming interfaces with additional community features like comment sections, categories, user roles, and notifications.

## ✨ Features

- Movie listing and detail pages
- User authentication (login/register)
- Role-based access (User/Admin)
- Comment system with moderation tools (Admin can delete comments)
- Carousel recommendations
- Categories and movie filtering by category
- Real-time comment event publishing using RabbitMQ

## 🤖 Technologies Used

### Frontend

- **React**: For building a dynamic and component-driven UI
- **React Router DOM**: Routing system for SPA
- **Axios**: HTTP requests
- **Tailwind CSS**: Modern and customizable utility-first styling

### Backend

- **Spring Boot**: Framework for building Java-based RESTful APIs
- **Spring Security + JWT**: Secure authentication and role-based access
- **Hibernate + JPA**: ORM layer for managing MySQL database
- **RabbitMQ**: Event-driven messaging system for asynchronous operations

### Infrastructure

- **Docker**: To containerize RabbitMQ and MySQL Database locally 
- **MySQL**: Relational database for persisting user, movie, and comment data

## 📁 Project Structure

```
wewatch-backend/
├── src/
│   ├── config/              # JWT, Security and Swagger config
│   ├── controller/          # REST API controllers
│   ├── dto/                 # Defines Data Transfer Objects
│   ├── mapper/              # Converting between entities and DTOs
│   ├── model/               # JPA Entity classes
│   ├── rabbit/              # RabbitMQ config, listener, publisher
│   ├── repository/          # Interfaces for database operations
│   ├── service/             # Business logic between controllers and repositories
│   └── Application.java     # Main Spring Boot Application
├── uploads/                 # Folder for images
│   ├── movies/              # Movie covers
│   ├── recommend_carousel/  # Recommend Carousel movie covers
│   └── slider/              # Slider images

wewatch-frontend/
└── src/
    ├── components/          # Reusable UI components
    ├── context/             # AuthContext for role/token handling
    ├── pages/               # Application Pages
    ├── services/            # Axios API layer
    ├── App.jsx              # Routing
    ├── index.css            # Global CSS config
    └── main.jsx             # Main React Application
```
## 🧰 Architecture Overview

![arichtecture](https://github.com/user-attachments/assets/c3bbad28-19e8-4817-8a43-213f8f0a82f8)  

## 🚀 How to Run

### Prerequisites

- Java 17+
- Node.js + npm
- MySQL running
- Docker (for RabbitMQ)

### Step 1: Setup RabbitMQ and exampl of MySQL database

```bash
docker run -d --hostname my-rabbit --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management
```
- Access management UI: http://localhost:15672 
- Default user: guest / guest

```bash
docker run --name mysql-dev -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=dev -e MYSQL_PASSWORD=root -p 3306:3306 -d mysql:latest
```
- MySQL run at http://localhost:3306
- Root User: root / root
- You can change details in application.yml

### Step 2: Backend
Move into wewatch-backend directory and run Application.java

### Step 3: Frontend
Move into wewatch-frontend
```bash
npm install
npm run dev
```
Frontend runs at: http://localhost:5173

##🔎 API Endpoints

### Auth
- POST /api/auth/register - Register new user
- POST /api/auth/login - Login, returns JWT

### Movies
- GET /api/movies - List all movies
- GET /api/movies/{id} - Get movie by ID

### Comments
- GET /api/comments/movie/{movieId} - List comments for movie
- POST /api/comments - Add comment (auth required)
- DELETE /api/comments/{id} - Delete comment (admin only)

### Categories
- GET /api/categories - List all categories
- GET /api/categories/{name} - Get movies by category

### Images
- GET /api/images/movies/{filename} - Get movie poster
- GET /api/images/slider/{filename} - Get homepage slider image
- GET /api/images/recommend_carousel - List carousel images with movie IDs
- GET /api/images/recommend_carousel/{filename} - Get individual carousel image

## 💪 Author
Tomasz Gierat
Feel free to contribute, fork, or raise issues!
