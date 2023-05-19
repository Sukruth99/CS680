package edu.umb.cs680.hw09.util;

public class Authenticator {
    public static boolean authenticate(SecurityContext ctx, EncryptedString password) {
        if (password == null || ctx == null) {
            return false;
        }
        return true;
    }
}
