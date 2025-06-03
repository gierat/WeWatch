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

---
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

---
