# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.bits.scalableservices.group23.' is invalid and this project uses 'com.bits.scalableservices.group23' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.5/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.5/reference/htmlsingle/#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.7.5/reference/htmlsingle/#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)


docker tag registration-service:0.0.1-SNAPSHOT hisureshk/registration-service
docker push hisureshk/registration-service

kubectl create deployment registration-service --image=hisureshk/registration-service --dry-run -o=yaml > deployment.yaml

kubectl create service clusterip registration-service --tcp=8080:8080 --dry-run -o=yaml >> deployment.yaml

kubectl port-forward svc/registration-service 8080:8080

$ echo --- >> deployment.yaml
$ kubectl create service clusterip demo --tcp=8080:8080 --dry-run -o=yaml >> deployment.yaml

kubectl run registration-service --image=registration-service:latest \
  --port=8080 --image-pull-policy Never

kubectl expose deployment registration-service --type=NodePort  

