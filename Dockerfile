FROM openjdk:8 as BUILD_IMAGE
RUN apt update && apt install maven -y
RUN git clone spring-boot-3 https://github.com/thuankiet36/spring-boot-3.git
RUN cd spring-boot-3 && git checkout main && mvn install

FROM tomcat:8-jre-11
RUN rm -rf /usr/local/tomcat/webapps/*
COPY --from=BUILD_IMAGE spring-boot-3/target/spring-boot-3-v2.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]