# REST Web Service for CRUD operations
[Active] REST web service using Spring Rest, Spring MVC , Hibernate and Maven. 

 
+This project is a Spring-based Web Service that implements CRUD (Create, Read, Update, Delete) operations for managing products. It leverages Spring REST, Spring MVC, and Hibernate to handle HTTP requests,
 business logic, and database operations, respectively. Additionally, a global Exception Handler is employed to manage all API data.
  

## Requeriments

* Java - 1.8.x
* JDK or OpenJDK - 1.8.x
* Maven - 3.x.x
* spring mvc 5.3.9
* MySQL - 8.0.23  
* hibernate 5.5.6
* Junit 4.11
* Jackson 2.16.1
* springFox 2.9.2

 
* Tested on:
 
* JDK 1.8.0_161
 
* MySQL - 8.0.23

## tools 
* intellJ IDE
* swagger 
* postman

## How to run

**1. Clone the repository.**

```bash
git clone https://github.com/gmartinezramirez/Spring-API-REST-Person-CRUD.git
```

**2. Create the database "hib" in MySQL or MariaDB.**

```
mysql -u root -p
```

```
mysql> create database hib
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`.

+ change ` datasource.username` and `datasource.password` as per your MySQL installation.

+ by default the user is: 'root' and password is: '1234' (without the ').


```java
datasource.url = jdbc:mysql://localhost:3306/hib?useSSL=false&serverTimezone=UTC
datasource.username = root
datasource.password = 1234
```

**4. Build and run the app using Maven**
   
+ The REST service is running at <http://localhost:8080/>.


## How to use the API

+ The current version of the API is v1.0.

### Create (Add)

1. Creating a new Person using POST /products API
+ localhost:8080/products
+ Example: {"name": "fish", "expirationDate":"2022-02-2"}

![GitHub Logo](/images/addProduct.png) 

### Read (View)
2. Retrieving all products using GET /products/productDetails/id=17 API
+ localhost:8080/products/{productId}
![GitHub Logo](/images/getAllProduct.png)

### Update  
3. Updating a product using PUT /products/{personId} API
+ localhost:8080/products
![GitHub Logo](/images/updateProduct.png)

### Delete  
4. Deleting a product using DELETE products/{personId} API
+ localhost:8080/products/{productId}
![GitHub Logo](/images/deleteProduct.png)

## IDE

This project was developed using IntelliJ IDEA 2020. 

 

## Database Schema

If applicable, the project uses the following database schema for CRUD operations on products:

 hib is the schema of myDataBase

 
## Contact Information

For questions or collaboration opportunities, feel free to reach out:

- Name : Abdullah hamada Abd ElSalam
- email : Abdullahhamada100@gmail.com
-  phone : +20 0106-734-3329
 
 
 
