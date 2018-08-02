# spring-boot-test

### Run project for production environment: 
mvn spring-boot:run -Dspring.profiles.active=production

### Package and run project for production environment: 
mvn package  
java -jar -Dspring.profiles.active=production target/main-0.0.1-SNAPSHOT.jar
