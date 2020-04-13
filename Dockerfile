FROM openjdk:8-jre-alpine

ENTRYPOINT ["java", "-jar", "/usr/share/myservice/myservice.jar"]

EXPOSE 8080

# Add the service itself
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/myservice/myservice.jar