FROM adoptopenjdk:11-jre-hotspot
COPY "./target/InsitelIoTAPIRest-0.0.1-SNAPSHOT.jar" "api.jar"
EXPOSE 8789
ENTRYPOINT ["java","-jar","api.jar"]
