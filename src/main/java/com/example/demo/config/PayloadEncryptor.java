package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

@Configuration
public class PayloadEncryptor {

    private static final String KEY = "WnZr4u7x!A%D*G-KaPdSgVkXp2s5v8y/";
    private static final String ALGORITHM = "AES/ECB/PKCS5Padding";


    public String encrypt(String payload) {
        try {
            byte[] decodedKey = KEY.getBytes();
            SecretKeySpec secretKey = new SecretKeySpec(decodedKey, "AES");
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedPayloadBytes = cipher.doFinal(payload.getBytes());
            return Base64Utils.encodeToString(encryptedPayloadBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error encrypting payload", e);
        }
    }
}
