package com.machinarymgmt.service.api.service;

import com.machinarymgmt.service.api.data.UserRepository;
import com.machinarymgmt.service.api.data.model.User;
import com.machinarymgmt.service.api.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public String login(String email, String rawPassword) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        System.out.println("Raw password: " + rawPassword);
        System.out.println("Hashed password in DB: " + user.getPassword());
        System.out.println("Password match: " + passwordEncoder.matches(rawPassword, user.getPassword()));

        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return jwtUtil.generateToken(user);
    }


    public User register(String username, String email, String rawPassword) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        String hashed = passwordEncoder.encode(rawPassword);

        User user = User.builder()
                .username(username)
                .email(email)
                .password(hashed)
                .role("user") // default role
                .active(true)
                .build();

        return userRepository.save(user);
    }
}
