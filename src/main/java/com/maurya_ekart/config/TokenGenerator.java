package com.maurya_ekart.config;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.UUID;

public class TokenGenerator {
	public String generateToken() {
        return UUID.randomUUID().toString();
    }

    public String generateSecureToken() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] tokenBytes = new byte[32]; // 256-bit token
        secureRandom.nextBytes(tokenBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(tokenBytes);
    }
}
