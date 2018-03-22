# Tsummarize Backend

A Kotlin backend for Tsummarize utilising Spring Boot, MySQL, JPA and Hibernate

*A work in progress...*

### Running the project

Add the relevant details to your `application.properties` file

```
## Spring Datasource Properties

spring.datasource.url = jdbc:mysql://localhost:8889/database_name_here?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&useSSL=false
spring.datasource.username = user
spring.datasource.password = password
        
## Hibernate Properties

# The SQL dialect makes Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto = update
```

Run the project on the standard port 8080

```
mvn spring-boot:run
```

🎉 You're done, go celebrate your success

---
#### Disclaimer
This project is primarily used as an exercise to increase my understanding of the technologies used in modern Java/Kotlin backends and for this reason the code should be treated with a pinch of salt.

![Derp](https://i.imgur.com/EbZSKh6.jpg)

## Contributing

I welcome contributions and discussion for new features or bug fixes. It is recommended to file an issue first to prevent unnecessary efforts, but feel free to put in pull requests in the case of trivial changes. In any other case, please feel free to open discussion and I will get back to you when possible.

