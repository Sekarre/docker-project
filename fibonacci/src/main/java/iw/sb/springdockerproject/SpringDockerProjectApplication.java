package iw.sb.springdockerproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringDockerProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDockerProjectApplication.class, args);
    }

}
