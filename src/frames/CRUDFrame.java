package frames;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class CRUDFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField usernameField;
    private JTextField passwordField;
    private JTextField idField;
    private JTextField newPasswordField;
    private JTable table;
    private DBConnect dbConnect = new DBConnect();

    /**
     * Constructeur qui permet de créer notre interface utilisateur pour le CRUD.
     */
    public CRUDFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel titleLabel = new JLabel("CRUD Operations");
        titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        idField = new JTextField();
        idField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        idField.setColumns(10);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        usernameField = new JTextField();
        usernameField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        usernameField.setColumns(10);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        passwordField = new JTextField();
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        passwordField.setColumns(10);

        JLabel newPasswordLabel = new JLabel("New Password:");
        newPasswordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        newPasswordField = new JTextField();
        newPasswordField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        newPasswordField.setColumns(10);

        JButton addButton = new JButton("Add");
        addButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addUser();
            }
        });

        JButton updateButton = new JButton("Update");
        updateButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateUser();
            }
        });

        JButton deleteButton = new JButton("Delete");
        deleteButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteUser();
            }
        });

        JButton resetPasswordButton = new JButton("Reset Password");
        resetPasswordButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        resetPasswordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetPassword();
            }
        });

        JScrollPane scrollPane = new JScrollPane();
        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {"ID", "Username", "Password"}
        ));
        table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        table.setRowHeight(25);
        scrollPane.setViewportView(table);

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(200)
                            .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(30)
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addComponent(idLabel)
                                .addComponent(usernameLabel)
                                .addComponent(passwordLabel)
                                .addComponent(newPasswordLabel))
                            .addGap(18)
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                .addComponent(idField)
                                .addComponent(usernameField)
                                .addComponent(passwordField)
                                .addComponent(newPasswordField, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                            .addGap(18)
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                .addComponent(addButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(updateButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(deleteButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(resetPasswordButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(30)
                            .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(30, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(30)
                    .addComponent(titleLabel)
                    .addGap(30)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(idLabel)
                        .addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(addButton))
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(usernameLabel)
                        .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(updateButton))
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(passwordLabel)
                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteButton))
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(newPasswordLabel)
                        .addComponent(newPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(resetPasswordButton))
                    .addGap(30)
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(30, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);

        // Charger les utilisateurs dans le tableau
        loadUsers();
    }

    // Méthode pour ajouter un utilisateur
    private void addUser() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        dbConnect.addUser(username, password);
        JOptionPane.showMessageDialog(this, "Utilisateur ajouté avec succès !");
        loadUsers();
    }

    // Méthode pour mettre à jour les informations d'un utilisateur
    private void updateUser() {
        int id = Integer.parseInt(idField.getText());
        String username = usernameField.getText();
        String password = passwordField.getText();
        dbConnect.updateUser(id, username, password);
        JOptionPane.showMessageDialog(this, "Utilisateur mis à jour avec succès !");
        loadUsers();
    }

    // Méthode pour supprimer un utilisateur
    private void deleteUser() {
        int id = Integer.parseInt(idField.getText());
        dbConnect.deleteUser(id);
        JOptionPane.showMessageDialog(this, "Utilisateur supprimé avec succès !");
        loadUsers();
    }

    // Méthode pour réinitialiser le mot de passe
    private void resetPassword() {
        int id = Integer.parseInt(idField.getText());
        String newPassword = newPasswordField.getText();
        dbConnect.resetPassword(id, newPassword);
        JOptionPane.showMessageDialog(this, "Mot de passe réinitialisé avec succès !");
        loadUsers();
    }

    // Méthode pour charger les utilisateurs dans le tableau
    private void loadUsers() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing rows
        List<User> users = dbConnect.getAllUsers();
        for (User user : users) {
            model.addRow(new Object[]{user.getId(), user.getUsername(), user.getPassword()});
        }
    }
}