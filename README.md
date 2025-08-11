# Bulk MongoDB Upload – Spring Boot Java Implementation

A Spring Boot application for **bulk uploading data into MongoDB** using Java 17, Spring Data MongoDB, and Apache POI.  
It processes Excel files, validates the data, and performs optimized bulk insert operations through REST APIs.  
Swagger UI is included for interactive API documentation.

---

## 🚀 Features
- Bulk data upload from Excel to MongoDB.
- Department and Employee management APIs.
- Data validation before persistence.
- Swagger UI for API documentation.
- Layered architecture (Controller → Service → Repository → Model).
- Apache POI for Excel parsing.

---

## 📂 Project Structure
src/main/java/com/mongoDb/MongoDB
│
├── controller # REST controllers
├── model # Entity classes & DTOs
│ ├── request
│ └── response
├── repository # MongoDB repositories
├── service # Business logic layer
├── utility # Excel processing helpers
└── MongoDbApplication # Application entry point
## 🛠 Tech Stack
- **Java**: 17
- **Spring Boot**: 3.5.3
- **Spring Data MongoDB**
- **Apache POI**
- **Swagger UI**
- **Maven**

---

## ⚙️ Setup & Run

### Prerequisites
- Java 17+
- Maven 3.8+
- MongoDB running locally or remotely

### Steps
1. **Clone the repository**
   ```bash
   git clone https://github.com/<your-username>/Bulk-MongoDB-Upload-Spring-Boot-Java-Implementation.git
   cd Bulk-MongoDB-Upload-Spring-Boot-Java-Implementation
   
To add this file to your repo:
```bash
echo "<paste the above content>" > README.md
git add README.md
git commit -m "Add README.md with project overview, setup, and usage"
git push
