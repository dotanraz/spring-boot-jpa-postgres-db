# spring-boot-jpa-postgres-db

An example project that uses Spring Boot and a Postgres DB using JPA specifications  

## Postgres DB
run the following command in order to spin up postgres:<br/>
cd to ./docker folder and run `docker-compose up -d`<br/><br/>

## DB Management:
The DB is managed by a Liquibase framework.<br/>
SQL procedures are stored at: resource/db/changelog/changes<br/>
DB credentials can be taken from resources/application.properties file.<br/>
Note: the program is using a default db with the name "postgres" that comes with Postgres image by default.
If from some reason this will be changed in the future, then make sure to create the db manually.

## API
Use the following example to add Server entry to the application:<br/>
`curl --location --request POST 'http://localhost:8080/api/addServer' --header 'Content-Type: application/json' --data-raw '{
"ip": "192.168.1.23",
"os": "linux",
"osVersion": "fedora",
"hwType": "x400"
}'`


Use the following curl to retrieve all servers from DB:<br/>
`curl --location --request GET 'http://localhost:8080/api/getServers'`
<br/>

Example of returned date:<br/>

[{
"id": 1,
"ip": "192.168.1.77",
"os": "linux",
"osVersion": "fedora",
"hwType": "x645"
},
{
"id": 2,
"ip": "192.168.1.43",
"os": "linux",
"osVersion": "arch linux",
"hwType": "x332"
}]