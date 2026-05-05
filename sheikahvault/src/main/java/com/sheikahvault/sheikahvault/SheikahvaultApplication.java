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


}
