FROM maven:3.6.3 AS maven
MAINTAINER  Dmitry Efimov <d.efimov@argustelecom.ru>

RUN mkdir -p /tmp/workspace
WORKDIR /tmp/workspace

COPY parent/ ./parent/
COPY telecom-app/ ./telecom-app/
COPY pom.xml .

RUN mvn clean install

FROM tomcat:9.0.31

RUN apt-get install curl && rm -rf $CATALINA_HOME/webapps/* && mkdir -p /flyway
ENV FLYWAY_VERSION 6.3.0

RUN curl -L https://repo1.maven.org/maven2/org/flywaydb/flyway-commandline/${FLYWAY_VERSION}/flyway-commandline-${FLYWAY_VERSION}.tar.gz -o flyway-commandline-${FLYWAY_VERSION}.tar.gz \
  && tar -xzf flyway-commandline-${FLYWAY_VERSION}.tar.gz --strip-components=1 \
  && rm flyway-commandline-${FLYWAY_VERSION}.tar.gz

ENV PATH="/flyway:${PATH}"
WORKDIR /flyway

RUN ls -la .

COPY db/conf/flyway.conf conf/flyway.conf
COPY db/migration/* db/migration/

COPY --from=maven /tmp/workspace/telecom-app/web/target/telecom.war $CATALINA_HOME/webapps/telecom.war

EXPOSE 8080
CMD ["catalina.sh", "run"]