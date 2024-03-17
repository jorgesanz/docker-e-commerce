FROM openjdk:17-jdk-slim-buster

ENV JAR_FILE promotion.jar
ENV APPLICATION_HOME /srv/promotion

WORKDIR $APPLICATION_HOME

COPY build/libs/$JAR_FILE $APPLICATION_HOME/$JAR_FILE

CMD java -jar $JAR_FILE