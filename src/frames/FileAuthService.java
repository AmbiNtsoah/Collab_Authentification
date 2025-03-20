package frames;
import java.io.*;
import java.util.Scanner;
import java.util.regex.*;

/**
 * Classe pour gérer l'authentification des utilisateurs et le stockage des données dans un fichier.
 */
public class FileAuthService implements AuthService {
    private final File file = new File("users.txt");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&*]).{12,}$");

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean login(String username, String password) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] credentials = scanner.nextLine().split(":");
                if (credentials.length == 2 && credentials[0].equals(username) && credentials[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new CustomException("Erreur de lecture du fichier");
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void register(String username, String password) {
        if (!isValidEmail(username)) {
            throw new IllegalArgumentException("Format d'email invalide");
        }
        if (!isValidPassword(password)) {
            throw new IllegalArgumentException("Le mot de passe doit contenir au moins 12 caractères, une majuscule, un chiffre et un caractère spécial (@#$%^&*)");
        }
        if (emailExists(username)) {
            throw new IllegalArgumentException("Cet email est déjà utilisé");
        }
        try (FileWriter fw = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(username + ":" + password);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new CustomException("Erreur de lecture du fichier");
        }
    }

    /**
     * Vérifie si l'email est valide.
     *
     * @param email L'email à vérifier.
     * @return true si l'email est valide, false sinon.
     */
    private boolean isValidEmail(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }
    private boolean emailExists(String email) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] credentials = scanner.nextLine().split(":");
                if (credentials.length == 2 && credentials[0].equals(email)) {
                    return true;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new CustomException("Erreur de lecture du fichier");
        }
        return false;
    }
    /**
     * Vérifie si le mot de passe est valide.
     *
     * @param password Le mot de passe à vérifier.
     * @return true si le mot de passe est valide, false sinon.
     */
    private boolean isValidPassword(String password) {
        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
    }
}