package frames;

/**
 * Interface pour gérer l'authentification des utilisateurs.
 */
public interface AuthService {
    /**
     * Méthode pour vérifier les informations de connexion.
     *
     * @param username Le mail d'utilisateur.
     * @param password Le mot de passe.
     * @return true si les informations de connexion sont correctes, false sinon.
     */
    boolean login(String username, String password);

    /**
     * Méthode pour enregistrer un nouvel utilisateur.
     *
     * @param username Le mail d'utilisateur.
     * @param password Le mot de passe.
     */
    void register(String username, String password);
}