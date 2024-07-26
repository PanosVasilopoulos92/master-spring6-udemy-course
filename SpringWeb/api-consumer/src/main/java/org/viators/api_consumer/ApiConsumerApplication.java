package org.viators.api_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "org.viators.api_consumer.proxy")
public class ApiConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiConsumerApplication.class, args);
	}
}
