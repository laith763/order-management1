# order-management
## 1) Documentation for each resource 
<img width="649" alt="Screen Shot 2022-05-27 at 4 44 12 PM" src="https://user-images.githubusercontent.com/81861451/171474511-611d4df0-ba73-48bc-8cb3-b006658be747.png">


## 2) Testing 
i used postman to test all the Api's


## 3) Database
i used postgresql to storage the data in it


## 4) API
i build four model the customer, order and product,stock
and declear all request Methods ( get , post , put , delete), For each one I have added a controller, dto, path costantis, entity, repository, service Impl, and a service intrface.
the best practices to add the end points is to add it into class, and this allowed you to manage it easy and an efficient way.
and for the security part i use the JWT token to make sure that the user is authorized , and i send the token with each request the user sent.
 ## 5) How to create and run the docker image
  1- first iam created a file and name it Docker file
  2- and in the Docker file this info
      a. FROM openjdk:17
b. EXPOSE 8000
c. ADD target/spring-boot-docker.jar spring-boot-docker.jar
d. ENTRYPOINT ["java","-jar","/spring-boot-docker.jar"]
