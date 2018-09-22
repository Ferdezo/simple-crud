**Project overview**
* Simple REST API
* Simple CRUD operations
* Simple article domain

**Techonogies**
* Spring MVC
* Spring Boot
* MyBatis
* H2 Database
* Spring Cloud Contracts

**Contract testing** <br/>
Project as REST API producer provides Contracts, by them you can verify if any change don't break them and as Consumer you can generate Stubs. <br/><br/>
To generate tests you need to run `spring-clound-contract:generateTests` and then in target you will have generated tests for contracts. <br/><br/>
To generate Stubs you need to run mvn `spring-cloud-contract:convert` and then `spring-cloud-contract:generateStubs` by that you will have a stubs jar file in your target.
