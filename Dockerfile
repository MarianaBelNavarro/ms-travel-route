FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/ms-travel-route-0.1.0.jar ms-travel-route.jar
EXPOSE 8080
CMD ["java", "-jar", "ms-travel-route.jar"]