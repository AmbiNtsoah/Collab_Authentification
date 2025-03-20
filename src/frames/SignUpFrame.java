package frames;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

/**
 * Classe permettant d'afficher l'interface
 * où l'utilisateur peut s'incrire à notre application
 */
public class SignUpFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField confirmPassword;
	private JPasswordField createPassword;
	private JTextField loginUser;

	/**
	 * Constructeur qui permet de créer l'interface graphique
	 * Formulaire d'inscription
	 */
	public SignUpFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel titleLabel = new JLabel("Sign Up Page");
		titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel loginUserLabel = new JLabel("Enter email login :");
		loginUserLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginUserLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		JLabel createPasswordLabel = new JLabel("Create password :");
		createPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		createPasswordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		JLabel confiemPasswordLabel = new JLabel("Confirm password :");
		confiemPasswordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		confiemPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		confirmPassword = new JPasswordField();
		confirmPassword.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		createPassword = new JPasswordField();
		createPassword.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		loginUser = new JTextField();
		loginUser.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		loginUser.setColumns(10);
		
		JButton signUpButton = new JButton("S'inscrire");
		signUpButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		
		JLabel redirectLoginLabel = new JLabel("Déjà un compte ?");
		redirectLoginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		redirectLoginLabel.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		JButton redirectLoginButton = new JButton("connexion"); /** Boutton pour être redirigé vers l'interface de connexion */
		redirectLoginButton.addActionListener(event -> redirectLogin()); /** Ecoute les évènements sur le boutton*/
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(58)
					.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(117, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(redirectLoginLabel, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(redirectLoginButton)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(createPasswordLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(loginUserLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
								.addComponent(confiemPasswordLabel, Alignment.LEADING))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(signUpButton)
									.addContainerGap())
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(loginUser, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
										.addComponent(createPassword, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
										.addComponent(confirmPassword, 226, 226, 226))
									.addGap(72))))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(36)
					.addComponent(titleLabel)
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginUserLabel)
						.addComponent(loginUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(createPasswordLabel)
						.addComponent(createPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(confiemPasswordLabel)
						.addComponent(confirmPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addComponent(signUpButton)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(redirectLoginLabel)
						.addComponent(redirectLoginButton))
					.addContainerGap(144, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	/**
	 * Inscrire le nouveau utilisateur
	 * */
	
	
	/**
	 * Rediriger vers l'interface de connexion
	 * */
	private void redirectLogin() {
		new Main().setVisible(true);
		this.setVisible(false);
	}

}
