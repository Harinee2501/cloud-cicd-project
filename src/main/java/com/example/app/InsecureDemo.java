
package com.example.app;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class InsecureDemo {

    // BAD PRACTICE 1: Hardcoded password
    private static final String ADMIN_PASSWORD = "admin123";

    // BAD PRACTICE 2: Weak random number generator for security tokens
    public static String generateSessionToken() {
        Random random = new Random();
        return "TOKEN-" + random.nextInt();
    }

    // BAD PRACTICE 3: Weak hashing algorithm for passwords
    public static String hashPassword(String password)
            throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hash = md.digest(password.getBytes());

        return java.util.HexFormat.of().formatHex(hash);
    }

    // BAD PRACTICE 4: Comparing strings using ==
    public static boolean isAdmin(String role) {
        return role == "admin";
    }

    // BAD PRACTICE 5: Empty exception handling
    public static void processInput(String input) {
        try {
            int number = Integer.parseInt(input);
            System.out.println(number);
        } catch (NumberFormatException e) {
            // Intentionally left empty for the demo
        }
    }
}
