FROM openjdk:11
ARG JAR_FILE=build/libs/TourGuideLocation-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} TourGuideLocation-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/TourGuideLocation-0.0.1-SNAPSHOT.jar"]
EXPOSE 9006