package com.projectpandas.ridemory.auth;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.projectpandas.ridemory.config.APIKeys;
import com.projectpandas.ridemory.util.dto.LoginDto;
import com.projectpandas.ridemory.util.dto.TokenDto;

public class AuthService {
    @Autowired
    APIKeys apiKeys;

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    static final String loginUrl = "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=";
    static final String signupUrl = "https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=";
    static final String lookupUrl = "https://identitytoolkit.googleapis.com/v1/accounts:lookup?key=";
    static final String deleteUrl = "https://identitytoolkit.googleapis.com/v1/accounts:delete?key=";
    static final String changePasswordUrl = "https://identitytoolkit.googleapis.com/v1/accounts:update?key=";

    final HttpClient client = HttpClient.newHttpClient();

    public TokenDto login(LoginDto loginDto) {
        try {
            // TODO: finish
            return null;
        } catch (Exception e) {
            logger.warn("Log in failed: {}", e.getStackTrace()[0]);
            return null;
        }
    }
}
