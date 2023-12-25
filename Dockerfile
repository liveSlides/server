FROM maven:3-amazoncorretto-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM amazoncorretto:17
COPY --from=build /target/liveSlideServer-0.0.1-SNAPSHOT.jar liveSlideServer.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","liveSlideServer.jar"]