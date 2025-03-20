package frames;
import java.io.*;
import java.util.Scanner;

/**
 * Classe pour gérer l'authentification des utilisateurs et le stockage des données dans un fichier.
 */
public class FileAuthService implements AuthService {
    private final File file = new File("users.txt");

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
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void register(String username, String password) {
        try (FileWriter fw = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(username + ":" + password);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
