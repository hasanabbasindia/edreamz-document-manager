# eDreamz Document Manager

A modern web-based document management system built with Spring Boot that allows users to upload, view, and manage documents with pagination support.

## 🚀 Features

- **Document Upload**: Upload files of various formats through a user-friendly web interface
- **Document Management**: View, delete, and manage uploaded documents
- **Pagination**: Navigate through large collections of documents with built-in pagination
- **Database Storage**: Documents are stored securely in a MySQL database
- **Responsive UI**: Clean and intuitive user interface with modern styling
- **RESTful API**: Well-structured REST endpoints for all document operations
- **Docker Support**: Easy deployment using Docker containers

## 🛠 Technology Stack

- **Backend**: Spring Boot 3.2.3
- **Frontend**: Thymeleaf templating engine with HTML/CSS
- **Database**: MySQL 8.x
- **Build Tool**: Maven
- **Java Version**: 17
- **Containerization**: Docker

### Dependencies

- Spring Boot Starter Web
- Spring Boot Starter Thymeleaf
- Spring Boot Starter Data JPA
- MySQL Connector/J
- Commons FileUpload
- Spring Boot DevTools
- Lombok

## 📋 Prerequisites

Before running the application, ensure you have the following installed:

- **Java 17** or higher
- **Maven 3.6+** or use the included Maven wrapper
- **MySQL 8.0+** database server
- **Docker** (optional, for containerized deployment)

## ⚙️ Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/hasanabbasindia/edreamz-document-manager.git
cd edreamz-document-manager
```

### 2. Database Configuration

Create a MySQL database and update the connection details in `src/main/resources/application.properties`:

```properties
server.port=${PORT:8080}
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Add your database configuration
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Build the Application

Using Maven:
```bash
mvn clean install
```

Or using the Maven wrapper:
```bash
./mvnw clean install
```

## 🚀 Running the Application

### Local Development

1. Start your MySQL database server
2. Run the Spring Boot application:

```bash
mvn spring-boot:run
```

Or:
```bash
./mvnw spring-boot:run
```

3. Open your browser and navigate to: `http://localhost:8080`

### Using Docker

1. Build the Docker image:
```bash
docker build -t edreamz-document-manager .
```

2. Run the container:
```bash
docker run -p 8080:8080 edreamz-document-manager
```

Note: For Docker deployment, ensure your MySQL database is accessible from the container.

## 📁 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── org/example/
│   │       ├── EDocumentUploadApp.java          # Main application class
│   │       ├── controller/
│   │       │   └── DocumentController.java      # REST controllers
│   │       ├── model/
│   │       │   └── Document.java                # Entity classes
│   │       ├── repository/
│   │       │   └── DocumentRepository.java      # Data access layer
│   │       └── service/
│   │           └── DocumentService.java         # Business logic
│   └── resources/
│       ├── templates/
│       │   └── index.html                       # Thymeleaf templates
│       └── application.properties               # Configuration files
```

## 🌐 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/` | Display the main page with uploaded documents and pagination |
| POST | `/upload` | Upload a new document |
| GET | `/delete/{id}` | Delete a document by ID |

### Query Parameters

- `page`: Page number for pagination (default: 0)

## 💡 Usage

1. **Upload Documents**: 
   - Click "Choose File" button to select a document
   - Click "Upload" to store the document in the database

2. **View Documents**: 
   - All uploaded documents are displayed on the main page
   - Document names are shown with delete options

3. **Navigate Pages**: 
   - Use "Previous" and "Next" buttons to navigate through pages
   - Click on page numbers for direct navigation
   - 5 documents are displayed per page by default

4. **Delete Documents**: 
   - Click the "Delete" link next to any document to remove it

## 🔧 Configuration

### Application Properties

- `server.port`: Server port (default: 8080)
- `spring.jpa.properties.hibernate.dialect`: Database dialect for MySQL

### File Upload Configuration

The application uses Spring Boot's default file upload configuration. You can customize limits in `application.properties`:

```properties
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB
```

## 🐳 Docker Deployment

The application includes a multi-stage Dockerfile:

1. **Build Stage**: Uses Maven to compile and package the application
2. **Runtime Stage**: Uses OpenJDK 17 slim image for running the application

### Build and Run with Docker

```bash
# Build the image
docker build -t edreamz-document-manager .

# Run the container
docker run -p 8080:8080 \
  -e SPRING_DATASOURCE_URL=jdbc:mysql://host.docker.internal:3306/your_db \
  -e SPRING_DATASOURCE_USERNAME=your_username \
  -e SPRING_DATASOURCE_PASSWORD=your_password \
  edreamz-document-manager
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is open source and available under the [MIT License](LICENSE).

## 👨‍💻 Author

**Hasan Abbas**
- GitHub: [@hasanabbasindia](https://github.com/hasanabbasindia)

## 🐛 Issues and Support

If you encounter any issues or have questions, please file an issue on the [GitHub Issues](https://github.com/hasanabbasindia/edreamz-document-manager/issues) page.

---

⭐ **Star this repository if you find it helpful!**