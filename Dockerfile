FROM openjdk:8u121-jdk

MAINTAINER Tarini Dash <dash.tarini@gmail.com>

WORKDIR /app/

COPY target/osase-website-1.0.jar /app/app.jar

CMD ["java", "-jar", "app.jar"]