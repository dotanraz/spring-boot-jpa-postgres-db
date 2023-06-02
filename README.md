# spring-boot-jpa-postgres-db

run the following command in order to spin up postgress:<br/>
`./docker docker-compose up -d`


DB credentials can be taken from resources/application.properties file.<br/>
Create a "test" db and a server table:<br/>
`CREATE TABLE IF NOT EXISTS Server(
ID SERIAL PRIMARY KEY,
ip varchar(100),
os varchar(100),
os_type varchar(100));`

Use the following example to add Server entry to the application:<br/>
`curl --location --request POST 'http://localhost:8080/api/addServer' --header 'Content-Type: application/json' --data-raw '{
"ip": "192.168.1.23",
"os": "linux",
"osVersion": "fedora"
}'`

Use the following curl to retrieve all servers from DB:<br/>
`curl --location --request GET 'http://localhost:8080/api/getServers'`