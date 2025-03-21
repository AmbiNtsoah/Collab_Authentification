package frames;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

/**
 * Classe spécifique pour sécuriser les mots de passe enregistrés.
 * Utilisation de hashage avec SHA-256
 */
public class HashUtils {
	/**
	 * Methode qui va hashé le mot de passe
	 * @param password qui va être hashé par l'algorithme SHA-256
	 * @return
	 */
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return byteArrayToHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Mehode qui transforme le mot de passe hashé en chaîne
     * de caractère Hexadécimal
     * @param bytes
     * @return
     */
    private static String byteArrayToHexString(byte[] bytes) {
        try (Formatter formatter = new Formatter()) {
			for (byte b : bytes) {
			    formatter.format("%02x", b);
			}
			return formatter.toString();
		}
    }
}

