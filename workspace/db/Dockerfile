FROM postgres:12.2
MAINTAINER  Dmitry Efimov <d.efimov@argustelecom.ru>

RUN mkdir -p /etc/postgresql/logs && chown -R postgres:postgres /etc/postgresql/logs
COPY ./conf/postgresql.conf /etc/postgresql/postgresql.conf
COPY ./conf/init.sql /docker-entrypoint-initdb.d/init.sql

ENV POSTGRES_PASSWORD initial
ENV FLYWAY_VERSION 6.3.0

CMD ["postgres", "-c", "config_file=/etc/postgresql/postgresql.conf", "-c", "logging_collector=on", "-c", "log_destination=stderr", \
"-c", "log_directory=/etc/postgresql/logs", "-c", "log_statement=all"]