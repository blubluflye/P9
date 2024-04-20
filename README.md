#P9: MédiLabo Solutions
## Description
Web application in java for an OpenClassroom project using Docker, microservice, NoSQL and MySQL.
The frontend is made with ReactJS.

# Technologies

> Java 17
> Spring Boot 3.X
> ReactJS
> Docker
> MySQL
> MongoDB

You need at least that 3 technologies: Docker, MySQL and MongoDB are install and work on your computer.

## How to Set up the 2 database for the project

Set up a MySQL database named patient.
Set up a MongoDB database at port 27017 with name note and a collection named notes.

##Set up your own configServer

Fork mine to create ur own from https://github.com/blubluflye/p9-config-server.git .
You will need to change one field in the file application.properties from microservice config-server:
```
spring.cloud.config.server.git.uri=<your-github-config-server.git>
```

In your own git for your config server, you also need to change from the file microservice-patients.properties the four field in the #DataSource Configuration# part to make it work with your Mysql Database.

## Executing program with docker
After setting up your database

* going directly to the directory of the poject P9 where the docker-compose.yml file is and use the commandLine:
```
docker-compose up
```

Now the container are up on ur pc.
An issue can happen where they don't wait the config-server to be up to start.

if you use an UI for docker like Docker Desktop restart all container except config-server and frontend.

else use commandline
```
docker ps
```
to see container names.
```
docker restart <container-id>
```
to restart all others than config-server and frontend.
