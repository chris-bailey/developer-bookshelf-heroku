## Spring Boot + Thymeleaf + Heroku
This demo application has been created as an example utilization of the [Spring Boot + Thymeleaf + Heroku Template](https://github.com/chris-bailey/spring-boot-thymeleaf-heroku-template) project. 

### Technology Stack 
1. Spring Boot, no-xml Spring MVC 4 web application for Servlet 3.0 environment
1. Thymeleaf templates with added Joda Time & Spring Security Dialects  
1. Heroku fully cloud deployable
1. JPA 2.0 (Spring Data JPA/Hibernate)
1. Database (Liquibase/PostgreSQL/H2 embedded/HikariCP)  
1. Testing (JUnit/Mockito/MockMVC/AssertJ/Hamcrest)  
1. Java 8, Spring Security 3.2, Maven 3, SLF4J, Logback, Bootstrap 3.3.4, jQuery 1.11.2, i18n


### Local Deployment 
```
$ mvn clean install  
$ mvn spring-boot:run
```

Navigate to [http://localhost:8080](http://localhost:8080).  
 
The application can also be deployed by running the `Application.java` class.

### Deploying to Heroku
<i>The following steps require that the [Heroku Toolbelt](https://toolbelt.heroku.com/) has been installed locally and that a Heroku account has been created.</i>

Navigate to the project directory on the command line.

Before creating your Heroku application, make sure that there is a Git repository associated with the project.   
```
$ git status
```  

If a Git repository is not associated with the project, then create one before continuing. 

Create a new application on Heroku  
```
$ heroku create
```

Rename your Heroku application if interested  
``` 
$ heroku apps:rename new-name
```

Add a PostgreSQL database to your Heroku application  
```
$ heroku addons:create heroku-postgresql
```

Deploy project to Heroku  
```
$ git push heroku master
```

Look at your application logs to see what is happening behind the scenes  
```
$ heroku logs
```

If your application deploys without timing out then open it as follows 
```
$ heroku open
```

### Special Thanks 
A big thank you to [Julien Dubois](http://www.julien-dubois.com/) and the [JHipster](https://jhipster.github.io/) project for leading the way in the rapid development of Spring applications, as well as for part of the foundation for this template.  JHipster is a Yeoman generator used to create Spring + AngularJS projects, with full hot reload of Java and JavaScript code.

Also, thank you to Rafal Borowiec's for his impressive [spring-mvc-quickstart-archetype](https://github.com/kolorobot/spring-mvc-quickstart-archetype) project.


### Author 
 Chris Bailey 
