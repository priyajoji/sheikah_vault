package com.sheikahvault.sheikahvault;

import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sheikahvault.sheikahvault.repositories.UserRepository;
import com.sheikahvault.sheikahvault.services.UserService;
import com.sheikahvault.sheikahvault.utils.PasswordUtil;
import com.sheikahvault.sheikahvault.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SheikahvaultApplication {

	public static void main(String[] args) {
		SpringApplication.run(SheikahvaultApplication.class, args);

	}
	@Bean
	CommandLineRunner repoTest(UserRepository repo) {
		return args -> {
			System.out.println("Repo check: " + repo.count());
		};
	}
	@Bean
	CommandLineRunner bcryptTest() {
		return args -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

			String raw = "test123";
			String hashed = encoder.encode(raw);

			System.out.println("HASH: " + hashed);
			System.out.println("MATCH: " + encoder.matches(raw, hashed));
		};
	}
	@Bean
	CommandLineRunner serviceTest(UserService service) {
		return args -> {
			service.registerUser("test@mail.com", "password123");
			System.out.println("User saved via service");
		};
	}

}
