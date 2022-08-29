FROM openjdk:8
EXPOSE 8080
ADD target/finalapp.jar finalapp.jar
ENTRYPOINT ["java" , "-jar" , "/finalapp.jar"]
