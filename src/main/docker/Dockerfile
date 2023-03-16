FROM openjdk:18-oracle
ARG JAR_FILE=*.jar
ENV JAVA_TOOL_OPTIONS -agentlib:jdwp=transport=dt_socket,address=*:5005,server=y,suspend=n
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]