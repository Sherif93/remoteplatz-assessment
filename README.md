## Steps to Setup the Spring Boot Assessment App

1. **Clone the application**

	```bash
	git clone https://github.com/Sherif93/remoteplatz-assessment.git
	cd remoteplatz-assessment
	```

2. **Create MySQL database**

	```bash
	create database moviesdb
	```

3. **Change MySQL username and password as per your MySQL installation**

	+ open `src/main/resources/application.properties` file.

	+ change `spring.datasource.username` and `spring.datasource.password` properties as per your mysql installation

4. **Run the app**

	You can run the spring boot app by typing the following command -

	```bash
	mvn spring-boot:run
	```

	The server will start on port 8080. The spring boot app includes the front end build also, so you'll be able to access the complete application on `http://localhost:8080`.

	You can also package the application in the form of a `jar` file and then run it like so -

	```bash
	mvn package
	java -jar target/assessment-0.0.1-SNAPSHOT.jar
	```
