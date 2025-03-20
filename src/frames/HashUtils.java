package frames;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;


public class HashUtils {
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return byteArrayToHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    
    private static String byteArrayToHexString(byte[] bytes) {
        try (Formatter formatter = new Formatter()) {
			for (byte b : bytes) {
			    formatter.format("%02x", b);
			}
			return formatter.toString();
		}
    }
}

