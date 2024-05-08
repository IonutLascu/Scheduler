FROM openjdk:17-slim AS builder

WORKDIR /app

RUN apt-get update && apt-get install -y findutils

COPY gradlew .
COPY gradle gradle

COPY build.gradle .
COPY settings.gradle .
COPY src src

RUN ./gradlew build

FROM openjdk:17-slim

WORKDIR /app

COPY --from=builder /app/build/libs/Scheduler-0.0.1-SNAPSHOT.jar /app/Scheduler.jar

EXPOSE 7000

CMD ["java", "-jar", "Scheduler.jar"]
