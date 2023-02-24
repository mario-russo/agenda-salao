FROM maven:3.9-amazoncorretto-17 as build
WORKDIR /app
COPY . .

RUN mvn clean package

FROM openjdk:17
WORKDIR /app
COPY --from=build ./app/target/*.jar ./app.jar
EXPOSE 8080
ENV BD_PASSWORD=agenda
ENV BD_USERNAME=agenda
ENV DB_URL=localhost:8090
ENV DB_BASE=agenda
ENV PROFILE_PROD=dev
ENTRYPOINT java -jar app.jar