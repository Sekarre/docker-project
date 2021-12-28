package iw.sb.springdockergateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringDockerGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDockerGatewayApplication.class, args);
	}

}
