package site.xddongx.boardspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.persistence.MappedSuperclass;

@EnableScheduling
@EnableJpaAuditing
@SpringBootApplication
public class BoardSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardSpringbootApplication.class, args);
	}

}
