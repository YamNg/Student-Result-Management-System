# Student-Result-Management-System

Steps for setting and starting up the services

1.  Run PostgreSQL docker
    - cd assessment-backend/docker
    - docker-compose up -d
2.  Run backend server
    - cd assessment-backend
    - mvn clean install
    - mvn spring-boot:run
3.  Run Frontend server
    - cd assessment-frontend
    - npm run dev

Services Path

1. Backend service
   - http://localhost:8081
2. Frontend service
   - http://localhost:5173
3. PostgreSQL
   - http://localhost:5432
4. PostgreSQL database viewer
   - http://localhost:8080

Postman Collection

1. Located in assessment-backend/misc/Shyftlab Assessment.postman_collection.json
