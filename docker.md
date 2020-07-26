#### Docker
- A platform to create, run and manage 

#### Container

> Pull an image
docker pull <image>
docker pull alphine

> Run the image in container(if image is not present locally, it will download from docker hub)
docker run <image>

> List the docker container processes
docker ps

> 

> kill the docker containers
docker kill <container-id>
docker kill 90d39035fdfb 4e7d08458f13

-p publish with port binding

docker run -p 3000:80 tutum/hello-world

docker run -d -p 3000:80 tutum/hello-world
detached mode - to run it in the background

docker run -d -p 3001:80 tutum/hello-world
docker run -d -p 3002:80 tutum/hello-world
 
 
#### Options
> detached mode - run the container in the background
-d 

> publish the container to specified port(9009)
-p 9009:30
 
> name the container
--name <container-name>

> log 


#### spring  boot docker

docker build -f Dockerfile -n docker-spring-kafka-producer -t docker-spring-kafka-producer .
docker build -f Dockerfile -n docker-spring-kafka-consumer -t docker-spring-kafka-consumer .

docker run -d -p 8882:8882 docker-spring-kafka-producer
docker run -d -p 8881:8881 docker-spring-kafka-consumer


