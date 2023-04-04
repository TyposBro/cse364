package me.typosbro.moshimoshi;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MoshiMoshiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoshiMoshiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(MovieRepository movieRepository){
		return args -> {
			Movie movie = new Movie("Kaguya-sama", List.of("Shounen", "Comedy", "Romance", "Drama"));
			movieRepository.insert(movie);
		};

	};

}
