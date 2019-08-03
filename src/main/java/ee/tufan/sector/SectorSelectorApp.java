package ee.tufan.sector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SectorSelectorApp {
	public static void main(String[] args) throws Throwable {
		SpringApplication.run(SectorSelectorApp.class, args);
	}
}
