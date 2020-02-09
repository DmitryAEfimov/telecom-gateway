FROM tomcat:9.0.30-jdk11
MAINTAINER  Dmitry Efimov <d.efimov@argustelecom.ru>

RUN rm -rf $CATALINA_HOME/webapps/*
COPY target/telecom.war $CATALINA_HOME/webapps/telecom.war

EXPOSE 8080

CMD ["catalina.sh", "run"]