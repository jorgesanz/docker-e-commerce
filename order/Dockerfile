FROM openjdk:17-jdk-slim-buster

ENV JAR_FILE order-0.0.1-SNAPSHOT.jar
ENV APPLICATION_HOME /srv/order

WORKDIR $APPLICATION_HOME

COPY build/libs/$JAR_FILE $APPLICATION_HOME/$JAR_FILE

CMD source ./configure_environment.sh; \
    java -jar $JAR_FILE