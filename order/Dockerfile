FROM openjdk:17-jdk-slim-buster

RUN apt-get update && apt-get install -y curl

ENV JAR_FILE order.jar
ENV APPLICATION_HOME /srv/order

WORKDIR $APPLICATION_HOME

COPY build/libs/$JAR_FILE $APPLICATION_HOME/$JAR_FILE

CMD java -jar $JAR_FILE