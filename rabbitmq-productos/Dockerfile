FROM maven:3.9.6-amazoncorretto-17 AS compiler
WORKDIR /build
COPY ../rabbitmq-commons .
RUN mvn clean install -DskipTests


FROM amazoncorretto:17-alpine-full
WORKDIR /app

ENV TZ=America/Asuncion
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY --from=compiler /build/target/rossano-1.jar /app/app.jar
CMD ["java", "-jar", "app.jar"]
