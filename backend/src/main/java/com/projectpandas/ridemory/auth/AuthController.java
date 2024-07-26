package com.projectpandas.ridemory.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectpandas.ridemory.util.dto.LoginDto;
import com.projectpandas.ridemory.util.dto.TokenDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping
    public ResponseEntity<TokenDto> login(@RequestBody LoginDto loginDto) {
        TokenDto token = authService.login(loginDto);
        return token == null ? ResponseEntity.status(HttpStatus.UNAUTHORIZED).build() : ResponseEntity.ok(token);
    }
}
