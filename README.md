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

## output sample
```
2017-11-05 17:31:42.436  INFO 8644 --- [nio-8080-exec-1][a1cc08dd-b101-407c-8142-a8007330fdf7] com.example.demo.RootController          : logging call from controller
2017-11-05 17:32:09.901  INFO 8644 --- [nio-8080-exec-2][42ed1f6c-6238-47af-a330-d29ffd3d8a41] com.example.demo.RootController          : logging call from controller
2017-11-05 17:32:11.999  INFO 8644 --- [nio-8080-exec-3][269b4287-8010-41df-a70c-c851f57eabb8] com.example.demo.RootController          : logging call from controller
2017-11-05 17:32:12.186  INFO 8644 --- [nio-8080-exec-4][12c0a1ed-b007-4598-af5f-850c32caa9ad] com.example.demo.RootController          : logging call from controller
2017-11-05 17:32:12.358  INFO 8644 --- [nio-8080-exec-5][17f46c1e-60d7-4ab8-ae7e-226040010478] com.example.demo.RootController          : logging call from controller
2017-11-05 17:32:16.852  INFO 8644 --- [nio-8080-exec-6][108ad3c3-44bb-4707-b982-f28dc3fa7bbe] com.example.demo.RootController          : logging call from controller
2017-11-05 17:32:17.011  INFO 8644 --- [nio-8080-exec-7][1e9df781-71c7-49cc-a44b-dcc6ab9b7426] com.example.demo.RootController          : logging call from controller
2017-11-05 17:32:17.167  INFO 8644 --- [nio-8080-exec-8][e3c7f2e2-0c43-4b68-9d52-c6719ea5db25] com.example.demo.RootController          : logging call from controller
2017-11-05 17:32:17.324  INFO 8644 --- [nio-8080-exec-9][d51a6848-9068-41b6-ada0-6918b9fe0161] com.example.demo.RootController          : logging call from controller
2017-11-05 17:32:17.495  INFO 8644 --- [io-8080-exec-10][f49422e8-d9aa-4db7-bb92-c1885cf97888] com.example.demo.RootController          : logging call from controller
2017-11-05 17:32:18.074  INFO 8644 --- [nio-8080-exec-1][6cf439e0-a180-4040-a413-d28069d2a1dc] com.example.demo.RootController          : logging call from controller
2017-11-05 17:32:18.444  INFO 8644 --- [nio-8080-exec-2][83c61f46-8388-4413-ac47-fb013e4610c4] com.example.demo.RootController          : logging call from controller
2017-11-05 17:32:18.944  INFO 8644 --- [nio-8080-exec-3][6c82d334-ac3d-49ca-9425-b5e9021e350c] com.example.demo.RootController          : logging call from controller
2017-11-05 17:32:19.163  INFO 8644 --- [nio-8080-exec-4][d9c6bc57-d5c8-4782-a5c2-de0c86ac05e6] com.example.demo.RootController          : logging call from controller
```
