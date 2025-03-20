package frames;

/**
 * Classe utile pour permettre l'enregistrement 
 * et la manipulation des utilisateurs
 */
public class User {
    private int id;
    private String username;
    private String password;

    /**
     * Constructeur de la classe pour permettre la 
     * manipulation des utilisateurs
     * 
     */
    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    /**
     * Getters et setters des attributs privées de la classe
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}