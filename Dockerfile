FROM openjdk:8-jdk-alpine
WORKDIR /usr/football
COPY ./build/libs/app.jar app.jar
#RUN ./gradlew :bootJar
#COPY /usr/football/build/libs/app.jar app.jar
EXPOSE 8081
ENTRYPOINT  ["java", "-jar", "./app.jar"]