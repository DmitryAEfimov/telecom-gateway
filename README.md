# Telecom application.
This is MVP of [OSS](https://en.wikipedia.org/wiki/Operations_support_system) class system. It provides CRUD operations for active equipment inventory.
Application has been developed in scope of [software architect](https://otus.ru/lessons/arhitektor-po/) course.

## Domain model:
* Address
	* Physical address. It can be created manually or selected from preloaded [FIAS](https://fias.nalog.ru/) database.
* Location 
	* Geo coordinate in WGS-84 projection. It can be enriched with physical address or human well-known synonym (for example, Hermitage).
* Site 
	* Telecom place, i.e. location or limited space inside the location where operator's equipments are installed. Sites are have restricted access often.
* LogicalNode 
	* Active equipment (switch, base station, optical line terminal (OLT), etc). Logical means that only equipment's network function is significant, but not the equipment's physical aspects (vendor, model, serial number, etc).

## Installation
Fork or download project to your local machine.
```bash
cd <your_project_location>/workspace/db
```

Build telecom-db docker image based on PostgreSQL v12.2. It restricts max-connections to 5 and create database with name `telecomdb`.
Also it creates user named `migrate` who will be used to apply database changes via [FlyWay](https://flywaydb.org/)
```bash
docker build -t telecom-db:0.1.0 .
```

Next build telecom-web docker multistage image based on maven 3.6 and tomcat 9.30. It build application via `mvn clean install` command, then copy flyway configuration and migration scripts. After all it copy application war file to `tomcat/webapp` directory
```bash
cd <your_project_location>/workspace
docker build -t telecom-web:0.1.0 .
```

After both images have been built you should run command:
```bash
docker-compose -f docker-compose.yml up -d
```

## Usage

Application URL context is `http://localhost:8080/telecom`

The resources are: `/addresses`, `/locations`, `/sites`, `/logical-nodes`

Use database primary key value to access individual resource. For example to access site with `id=1` use `/sites/1`.

You can do following CRUD actions:

**GET** /{resources} to READ all objects from database.

**GET** /{resources}/{id} to READ individual object from database.

**POST** /{resources} to CREATE new object in database.

**PUT** /{resources}/{id} to UPDATE existing object in database. Omitted attributes are interpreted as unchanged.

**DELETE** /{resources}/{id} to DELETE existing object in database.