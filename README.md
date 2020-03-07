Telecom application. Is an education project for OTUS cource softwarearchitect. 2019-11
It simple CRUD application and emulates telecom operator input data business process.
Domain model:
- Address - physical address of any geo-object. It may be created manually or selected from predefined address dictionary (FIAS, for examle).
- Location - geo coordinate in WGS-84 projection. It can be enriched with physical address.
- Site - telecom place, i.e. location where operator equipments are presented.
- LogicalNode - some active equipment, such as Swith, BaseStation, multiplexor and so on.
Logical means that only equipment's network function is significant, but not the physical aspects (vendor, model, serial model, etc)

Application URL context is: http://localhost:8080/telecom
REST api:

How to install:
Fork or download project to your local machine.

Сhange directory to: <your_project_location>/workspace/db

Build telecom-db image based on PostgreSQL v12.2. It restrict max-connections to 5 and create database with name telecomdb.
Also it creates user named migrate who will be used to apply database changes via FLYYWAY
Run command: docker build -t telecom-db:0.1.0 .

Change directory to: <your_project_location>/workspace
Build telecom-web multistage image based on maven 3.6 and tomcat 9.30
It build application via maven clean install command, then copy flyway configuration and migrate scripts
After all it copy applicatio war file to tomcat/webapp directory
run command: docker build -t telecom-web:0.1.0 .

After both images have been built you should run command: docker-compose.yml up -d
Now your ready to use application.