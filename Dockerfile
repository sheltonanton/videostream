FROM ubuntu
RUN apt-get update && apt-get install iproute2 iputils-ping openjdk-17-jdk -y
COPY target/videostream-0.0.1-SNAPSHOT.jar /videostream-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/videostream-0.0.1-SNAPSHOT.jar"]