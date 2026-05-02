package com.sheikahvault.sheikahvault.services;

import com.sheikahvault.sheikahvault.models.User;
import com.sheikahvault.sheikahvault.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public UserService(UserRepository userRepository,
                       BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public User registerUser(String email, String rawPassword) {

        String hashedPassword = encoder.encode(rawPassword);

        User user = new User(email, hashedPassword);

        return userRepository.save(user);
    }

    public boolean verifyPassword(String rawPassword, String hashedPassword) {
        return encoder.matches(rawPassword, hashedPassword);
    }
}