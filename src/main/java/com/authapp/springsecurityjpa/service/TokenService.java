package com.authapp.springsecurityjpa.service;

import com.authapp.springsecurityjpa.data.Token;
import com.authapp.springsecurityjpa.repo.TokenRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TokenService {

    private final TokenRepo tokenRepo;

    public void saveToken(Token token){
        tokenRepo.save(token);
    }
    public Optional<Token> getToken(String token) {
        return tokenRepo.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return tokenRepo.updateConfirmedAt(
                token, LocalDateTime.now());
    }
}
