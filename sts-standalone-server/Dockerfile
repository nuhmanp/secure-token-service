FROM adorsys/openjdk-jre-base:8-minideb

WORKDIR /opt/
COPY ./target/sts-standalone-server.jar .

EXPOSE 8080

CMD exec $JAVA_HOME/bin/java $JAVA_OPTS -jar /opt/sts-standalone-server.jar
