# spring-boot-starter-web-logging-requestid

## what is this?
logging one request, one id.
for spring boot starter web.

## how to use
* add scan
```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.iyher.spring.logging.requestid.LoggingFilter;

@SpringBootApplication(scanBasePackageClasses = {$$$your ApplicationClass$$$,LoggingFilter.class})
```
* add logging setting
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE logback>
<configuration>
	<include resource="com/iyher/spring/logging/requestid/base.xml" />
</configuration>
```

or custom pattarn
```xml
	<include resource="com/iyher/spring/logging/requestid/defaults.xml" />
	<property name="PATTERN" value="[%reqId]%m%n%ex"/>
```
