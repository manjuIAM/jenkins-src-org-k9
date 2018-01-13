FROM jboss/base-jdk:8

ENV APP_VERSION 1.0
COPY spring-boot-rest-example-0.4.0.war /opt/spring-boot-rest-example-0.4.0.war

EXPOSE 8080
CMD [ "java", "-jar", "-Dspring.profiles.active=test", "/opt/spring-boot-rest-example-0.4.0.war" ]
