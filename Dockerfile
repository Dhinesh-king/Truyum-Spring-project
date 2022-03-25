FROM openjdk:15

EXPOSE 8080

ADD target/truyum-app.jar truyum-app.jar

ENTRYPOINT ["java","-jar","/truyum-app.jar"]