package com.spring.crud.service;

import com.spring.crud.dto.request.LoginRequest;
import com.spring.crud.exception.BusinessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.spring.crud.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.spring.crud.security.JwtService;

@Service

public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;


    public AuthService( UserRepository repository,
                        PasswordEncoder encoder,
                        JwtService jwtService) {
        this.repository = repository;
        this.encoder = encoder;
        this.jwtService = jwtService;
    }

    public LoginResponse login(LoginRequest request) {
        User user = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BusinessException("Usuário invalido"));

        if (!encoder.matches(request.getPassword(), user.getPassword())) {
            throw new BusinessException("Senha inválida");
        }

        String token = jwtService.generateToken(user);
    }
}
