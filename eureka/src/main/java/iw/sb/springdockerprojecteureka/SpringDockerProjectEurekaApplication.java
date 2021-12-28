package iw.sb.springdockerprojecteureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringDockerProjectEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDockerProjectEurekaApplication.class, args);
	}

}
