FROM openjdk:8u212-b04-slim-stretch
COPY dummy-api-layer.jar /usr/local/bin/app.jar
COPY application.yml /usr/local/bin/application.yml
CMD ["java","-jar","/usr/local/bin/app.jar"]
EXPOSE 8080