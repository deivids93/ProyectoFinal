package cabanas.cabanas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"cabanas.cabanas.Modelo"})
public class CabanasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabanasApplication.class, args);
	}

}
