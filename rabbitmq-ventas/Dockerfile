# TODO: Corregir importación de rabbitmq-commons en maven ya que falla al compilar

FROM maven:3.9.6-amazoncorretto-17 AS compiler
WORKDIR /build
COPY ../rabbitmq-productos .
RUN mvn clean install -DskipTests


FROM amazoncorretto:17-alpine-full
WORKDIR /app

ENV TZ=America/Asuncion
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY --from=compiler /build/target/rabbitmq-ventas-0.0.1-SNAPSHOT.jar /app/app.jar
CMD ["java", "-jar", "app.jar"]
