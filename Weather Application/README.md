#Weather Application
This is a weather application which gives weather information of any city in U.S. if a valid zip code is provided. 
This uses wunderground.com API to fetch weather information.

##Prerequisites
Maven and Apache tomcat are required to successfully run this application.

##Compile
Move into the application directory and run the following command to compile the application 
mvn compile

##Test
Move into the application directory and run the following coomand to test the application
mvn test

##Package
Move into the application directory and run the following coomand to package the application
mvn package
An application war file will be created in the target directory. Copy the application war file and deploy it in the 
tomcat webapps folder.
To access the application visit the following url http://localhost:8080/WeatherApp-1.0/weather/
