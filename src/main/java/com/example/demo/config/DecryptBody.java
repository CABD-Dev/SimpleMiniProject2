package com.example.demo.config;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DecryptBody {
    private static final String ALGORITHM = "AES";
    private static final byte[] KEY = "WnZr4u7x!A%D*G-KaPdSgVkXp2s5v8y/".getBytes(); // replace with your own key

    public static String decrypt(String encryptedBody) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecretKeySpec keySpec = new SecretKeySpec(KEY, ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] decodedBytes = Base64.decodeBase64(encryptedBody.getBytes());
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes);
    }
}
