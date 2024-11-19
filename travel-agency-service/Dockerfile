FROM openjdk:19-alpine
MAINTAINER bd
VOLUME /tmp
COPY target/travel-agency-service-1.0-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=9999 -jar /app.jar