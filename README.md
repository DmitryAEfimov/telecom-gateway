# Telecom application.

An education course's project [software architect](https://otus.ru/lessons/arhitektor-po/) It simple CRUD application that emulates telecom operator input data business process.

## Domain model:
* Address
	* physical address of any geo-object. It may be created manually or selected from predefined address dictionary (FIAS, for examle).
* Location 
	* geo coordinate in WGS-84 projection. It can be enriched with physical address.
* Site 
	* telecom place, i.e. location where operator equipments are presented.
* LogicalNode 
	* some active equipment, such as Swith, Base Station, Otical Line Terminal (OLT) and so on.	Logical means that only equipment's network function is significant, but not the physical aspects (vendor, model, serial model, etc).

## Installation
Fork or download project to your local machine.
```bash
	cd <your_project_location>/workspace/db
```

Build telecom-db docker image based on PostgreSQL v12.2. It restricts max-connections to 5 and create database with name `telecomdb`.
Also it creates user named `migrate` who will be used to apply database changes via FLYYWAY
```bash
  docker build -t telecom-db:0.1.0 .
```

Next build telecom-web docker multistage image based on maven 3.6 and tomcat 9.30. It build application via `mvn clean install` command, then copy flyway configuration and migrate scripts. After all it copy application war file to `tomcat/webapp` directory
```bash
	cd <your_project_location>/workspace
	docker build -t telecom-web:0.1.0 .
```

After both images have been built you should run command:
```bash
	docker-compose.yml up -d
```

## Usage

Application URL context is: http://localhost:8080/telecom
REST api: