FROM jetty:9.4.26-jre11
MAINTAINER  Dmitry Efimov <d.efimov@argustelecom.ru>

ADD target/telecom-gateway.war $JETTY_BASE/webapps/telecom-gateway.war

EXPOSE 8080

RUN java -jar "$JETTY_HOME/start.jar" --add-to-startd=jmx,stats