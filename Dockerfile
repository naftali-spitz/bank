FROM openjdk:21-jdk-slim
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY target/bank-0.0.1-SNAPSHOT.jar bank.jar
EXPOSE 8080
ENTRYPOINT exec java $JAVA_OPTS -jar bank.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar bank.jar
