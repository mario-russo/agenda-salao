FROM maven:3.9-amazoncorretto-17 as build
WORKDIR /app
COPY . .
RUN mvn clean package

FROM openjdk:17
WORKDIR /app
COPY --from=build ./app/target/*.jar ./app.jar
EXPOSE 8080
ENTRYPOINT java -jar app.jar