# rasa-spring-boot-starter

Starter Spring Boot with implementation of service produced by Rasa server

Support jdk version 1.8+


### Usage

- Add dependecies

```xml
<dependency>
    <groupId>com.evidence</groupId>
    <artifactId>rasa-spring-boot-starter</artifactId>
    <version>0.0.1</version>
</dependency>
```

- Add configuration in application.properties

```properties
spring.rasa.instance[0].host=127.0.0.1
spring.rasa.instance[0].port=5005
spring.rasa.instance[0].name=default
```

- Add `@EnableRasaConfiguration` on the main application

### Reference
- spring-boot: https://spring.io/projects/spring-boot
- rasa: https://rasa.com/docs/
