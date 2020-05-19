import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class LoginModule {

	private JFrame frame;
	private JTextField txtUsername;
	private JTextField txtPassword;
	public String priviledge;
	public String monnom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginModule window = new LoginModule();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginModule() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		//////////////////////////////////////////////////////////////////////////
		frame = new JFrame();
		frame.setBounds(200, 100, 576, 404);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblUser = new JLabel("Nom d'utilisateur :");
		lblUser.setForeground(Color.WHITE);
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUser.setBounds(31, 96, 151, 20);
		frame.getContentPane().add(lblUser);

		JLabel lblPassword = new JLabel("Mot de Passe :");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(31, 156, 121, 20);
		frame.getContentPane().add(lblPassword);

		txtUsername = new JTextField();

		txtUsername.setBounds(216, 95, 199, 26);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.setForeground(Color.LIGHT_GRAY);
		txtPassword.setColumns(10);
		txtPassword.setBounds(216, 155, 199, 26);
		frame.getContentPane().add(txtPassword);

		JButton btnLogin = new JButton("Connexion");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String username = txtUsername.getText();
				String password = txtPassword.getText();

				JLabel alertUser = new JLabel("");
				alertUser.setBounds(261, 80, 69, 20);
				frame.getContentPane().add(alertUser);

				JLabel alertPassword = new JLabel("");
				alertPassword.setBounds(261, 152, 69, 20);
				frame.getContentPane().add(alertPassword);

				txtUsername.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) {

						alertUser.setText("");

					}
				});

				txtPassword.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) {

						alertPassword.setText("");

					}
				});

				/////////////////// Validation///////////////////

				if (username.trim().length() == 0 && password.trim().length() == 0) {

					alertUser.setText("Username is empty");
					alertPassword.setText("Password is empty");
					JOptionPane.showMessageDialog(null, "BOTH FIELDS ARE NULL");

				} else if (username.trim().length() == 0) {

					alertUser.setText("Username is empty");

				} else if (password.trim().length() == 0) {

					alertPassword.setText("Password is empty");

				} else {

					dbhotel db = new dbhotel();

					try {

						Connection con = db.db_connect();
						PreparedStatement stmt = con
								.prepareStatement("SELECT * FROM utilisateur WHERE username=? AND password=?");
						stmt.setString(1, username);
						stmt.setString(2, password);
						ResultSet rs = stmt.executeQuery();
						System.out.print(username);

						//////// C'est pour dire si la personne existe dans la base de donnee ou
						//////// non///////
						if (rs.next()) {

							String role = rs.getString(7);
							priviledge = role; // pour dire que priviledge prendre la valeur de role

							String prenom = rs.getString(3);
							monnom = prenom;

							JOptionPane.showMessageDialog(null, "Bienvenue" +' '+ prenom);

							frame.dispose();
							Gestion welcome = new Gestion(priviledge, monnom);
							welcome.setVisible(true);

						}
						// String role = rs.getString(7);
						else {

							JOptionPane.showMessageDialog(null, "n'existe pas dans la base de donées");
						}

					} catch (Exception error) {

						System.out.print(error);

					}

				}

			}
		});
		btnLogin.setBounds(435, 314, 115, 29);
		frame.getContentPane().add(btnLogin);

		JButton btnExit = new JButton("Sortie");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				frame.dispose();
			}
		});
		btnExit.setBounds(15, 301, 115, 29);
		frame.getContentPane().add(btnExit);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Nathanielle\\Documents\\eclispe\\SA2\\src\\images\\intro.jpg"));
		lblNewLabel.setBounds(10, 0, 550, 365);
		frame.getContentPane().add(lblNewLabel);

//		JLabel lblNewLabel = new JLabel("New label");
//		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User\\Documents\\SA2\\src\\images\\sunset-pool.jpg"));
//		lblNewLabel.setBounds(0, 0, 1013, 592);
//		frame.getContentPane().add(lblNewLabel);

		////////////////////////////////////////////////////////////////////////////////////////////////////

	}
}
