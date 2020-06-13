# spring-microservice-mongodb-kafka-redis-sonar
Building Microservice architecture with Spring Boot and integrating MongoDB, Kafka, Redis, Sonarqube 


## Software List 


Eclipse -> https://www.eclipse.org/downloads/ (Download and install, choose the link depending on the OS.). 

Git SCM -> https://git-scm.com/downloads (Download and install, choose the link depending on the OS.). 

IntelliJ IDEA -> https://www.jetbrains.com/idea/download/ (Download and install, choose the link depending on the OS.). 

Java 8 -> https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html (Download and install, choose the link depending on the OS.). 

Apache Kafka -> https://archive.apache.org/dist/kafka/2.4.0/kafka_2.11-2.4.0.tgz (Download & extract)   

MongoDB -> https://www.mongodb.com/download-center/community (Download and install, choose the link depending on the OS.). 

Redis -> http://download.redis.io/releases/redis-6.0.4.tar.gz (copy and follow same link for installation )   
 
SonarQube -> https://www.sonarqube.org/downloads/ (Download Community Edition & extract )   

Sonar Scanner -> https://docs.sonarqube.org/latest/analysis/scan/sonarscanner/ (Download & extract)   



--------------------------------------------------------------------------
Scaffolded projects 

Eureka 
https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.2.8.RELEASE&packaging=jar&jvmVersion=1.8&groupId=com.naveen&artifactId=eureka-naming-server&name=eureka-naming-server&description=eureka%20naming%20server%20project&packageName=com.naveen.eureka&dependencies=cloud-eureka-server,web

Zuul 
https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.2.8.RELEASE&packaging=jar&jvmVersion=1.8&groupId=com.naveen&artifactId=api-gateway&name=api-gateway&description=api%20gateway%20project&packageName=com.naveen.api.gateway&dependencies=web,cloud-zuul

Product Service
https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.2.8.RELEASE&packaging=jar&jvmVersion=1.8&groupId=com.naveen&artifactId=product-service&name=product-service&description=product%20service%20project&packageName=com.naveen.product.service&dependencies=web,devtools,data-mongodb,cloud-eureka,lombok


Product Review Service 
https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.2.8.RELEASE&packaging=jar&jvmVersion=1.8&groupId=com.naveen&artifactId=product-review-service&name=product-review-service&description=product%20review%20service&packageName=com.naveen.product.review&dependencies=devtools,web,data-mongodb,cloud-eureka,lombok


