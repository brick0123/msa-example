package se.magnus.microservices.core.product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication
@ComponentScan("se.magnus")
public class ProductServiceApplication {

	public static void main(String[] args) {
		final ConfigurableApplicationContext ctx = SpringApplication.run(ProductServiceApplication.class, args);
		final String mongoDbHost = ctx.getEnvironment().getProperty("spring.data.mongodb.host");
		final String mongoDbPort = ctx.getEnvironment().getProperty("spring.data.mongodb.port");
		log.info("Connected to MongoDb [{}]:[{}]", mongoDbHost, mongoDbPort);
	}
}
