FROM openjdk:11
VOLUME /tmp
EXPOSE 8088
ADD target/spring-boot-docker.jar spring-boot-docker.jar
ENTRYPOINT ["java", "-jar", "/spring-boot-docker.jar"]
# ARG JAR_FILE=target/spring-boot-docker.jar
# ADD ${JAR_FILE} app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]