package com.sheikahvault.sheikahvault.services;

import java.util.*;
import com.sheikahvault.sheikahvault.models.User;
import com.sheikahvault.sheikahvault.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = repo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                List.of(new org.springframework.security.core.authority.SimpleGrantedAuthority("ROLE_USER"))
        );
    }
}
