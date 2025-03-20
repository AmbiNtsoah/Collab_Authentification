package frames;

import frames.HashUtils;
import frames.AuthService;
import java.sql.*;

import java.beans.Statement;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DBConnect implements AuthService {
    private static final String URL = "jdbc:sqlite:users.db";
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&*]).{12,}$");

    /**
     * Crée la table si elle n'éxiste pas encore
     * */
    public DBConnect() {
        try (Connection conn = DriverManager.getConnection(URL)) {
            if (conn != null) {
                String createTableSQL = "CREATE TABLE IF NOT EXISTS users ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + "username TEXT NOT NULL,"
                        + "password TEXT NOT NULL"
                        + ");";
                try (PreparedStatement pstmt = conn.prepareStatement(createTableSQL)) {
                    pstmt.execute();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Methode pour permettre la connexion utilisateurs déjà inscrit
     * */
    @Override
    public boolean login(String username, String password) {
        String hashedPassword = HashUtils.hashPassword(password);
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, hashedPassword);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CustomException("Erreur de connexion à la base de données");
        }
    }

    /**
     * Methode pour permettre l'inscription des nouveaux utilisateurs
     * */
    @Override
    public void register(String username, String password) {
    	if (!isValidEmail(username)) {
            throw new IllegalArgumentException("Format d'email invalide");
        }
    	if (emailExists(username)) {
            throw new IllegalArgumentException("Cet email est déjà utilisé");
        }
    	if (!isValidPassword(password)) {
            throw new IllegalArgumentException("Le mot de passe doit contenir au moins 12 caractères, une majuscule, un chiffre et un caractère spécial (@#$%^&*)");
        }
        String hashedPassword = HashUtils.hashPassword(password);
        String sql = "INSERT INTO users(username, password) VALUES(?, ?)";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, hashedPassword);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CustomException("Erreur d'enregistrement dans la base de données");
        }
    }
    
    private boolean isValidEmail(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }
    private boolean emailExists(String email) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CustomException("Erreur de lecture de la base de données");
        }
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
 // Ajout de la méthode getAllUsers
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                users.add(new User(rs.getInt("id"), rs.getString("username"), rs.getString("password")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CustomException("Erreur de lecture de la base de données");
        }
        return users;
    }

    // Méthode pour ajouter un nouvel utilisateur
    public void addUser(String username, String password) {
        String hashedPassword = HashUtils.hashPassword(password);
        String sql = "INSERT INTO users(username, password) VALUES(?, ?)";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, hashedPassword);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CustomException("Erreur d'enregistrement dans la base de données");
        }
    }

    // Méthode pour lire les informations d'un utilisateur
    public User getUser(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
            } else {
                throw new CustomException("Utilisateur non trouvé");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CustomException("Erreur de lecture de la base de données");
        }
    }

    // Méthode pour mettre à jour les informations d'un utilisateur
    public void updateUser(int id, String newUsername, String newPassword) {
        String hashedPassword = HashUtils.hashPassword(newPassword);
        String sql = "UPDATE users SET username = ?, password = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newUsername);
            pstmt.setString(2, hashedPassword);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CustomException("Erreur de mise à jour de la base de données");
        }
    }

    // Méthode pour supprimer un utilisateur
    public void deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CustomException("Erreur de suppression de la base de données");
        }
    }
    
 // Méthode pour réinitialiser le mot de passe
    public void resetPassword(int id, String newPassword) {
        String hashedPassword = HashUtils.hashPassword(newPassword);
        String sql = "UPDATE users SET password = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, hashedPassword);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CustomException("Erreur de réinitialisation du mot de passe");
        }
    }
}