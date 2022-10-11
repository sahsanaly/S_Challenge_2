FROM openjdk:11
EXPOSE 8080
ADD target/S_Challenge_2.jar S_Challenge_2
ENTRYPOINT ["java", "-jar", "S_Challenge_2.jar"]
