import java.awt.BorderLayout;
import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.sql.Connection;
 

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JComboBox.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
 
 


public class Utilisateur extends JFrame {

	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtSearchingFor;
	private JTextField txtUsername;
	private JTextField txtPass;
	private JTextField txtSearch;
	private static JTable tableUtilisateur;
	private JTextField txtPrenom;
	private JTextField txtEmail;
	private JComboBox<String> comboBox,comboBoxSearch;
	private JTextField txtIdUser;
	private String filterCriteria;

	dbhotel db = new dbhotel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Utilisateur frame = new Utilisateur();
					frame.setVisible(true);
					showTable();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Utilisateur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 1328, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDconnexion = new JButton("D\u00E9connexion");
		btnDconnexion.setBounds(1095, 587, 137, 29);
		contentPane.add(btnDconnexion);
//================================ DELETE ===========================================================			
		JButton btnDelete = new JButton("Effacer");
		btnDelete.setForeground(Color.RED);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String id = txtIdUser.getText();
				String nom = txtNom.getText();
				String prenom = txtPrenom.getText();
				String username = txtUsername.getText();
				String email = txtEmail.getText();
				String password = txtPass.getText();
				String value = comboBox.getSelectedItem().toString();
				
				
if( nom.trim().length()==0 || prenom.trim().length()==0 || username.trim().length()==0 || email.trim().length()==0 || password.trim().length()==0 ){
		
					
					JOptionPane.showMessageDialog(null, "Remplissez les champs");

			}else {
				
				try {
					
					
					Connection con = db.db_connect();
					PreparedStatement stmt = con.prepareStatement("DELETE FROM utilisateur WHERE id=?");
				 	stmt.setString(1,id);
			 
					stmt.executeUpdate();
					JOptionPane.showMessageDialog(null,"Mise à jour effectué");
					showTable();
					
					
					
					
				}catch(Exception Up) {
					System.out.print(Up);
				}
				
			}
			
				 
				
			}
		});
		btnDelete.setBounds(509, 519, 122, 29);
		contentPane.add(btnDelete);
//================================ NEW ===========================================================		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = txtIdUser.getText();
				String nom = txtNom.getText();
				String prenom = txtPrenom.getText();
				String username = txtUsername.getText();
				String email = txtEmail.getText();
				String password = txtPass.getText();
				 
				String value = comboBox.getSelectedItem().toString();
				
//				===========================VAlidation===========
if( nom.trim().length()==0 && prenom.trim().length()==0 && username.trim().length()==0 && email.trim().length()==0 && password.trim().length()==0 ){
		
					
					JOptionPane.showMessageDialog(null, "Remplissez les champs");

			}
			
				 else if(nom.trim().length()==0) {
					
					 JOptionPane.showMessageDialog(null,"Remplissez le champs de nom");
					
				}else if(prenom.trim().length()==0) {
				
					JOptionPane.showMessageDialog(null,"Remplissez le champs de nom");
					
				}else if(username.trim().length()==0) {
					
					
					JOptionPane.showMessageDialog(null,"Remplissez le champs de username");
					
				
				}else if(email.trim().length()==0) {
					
					
					JOptionPane.showMessageDialog(null,"Remplissez le champs de email");
					
				
				}else if(password.trim().length()==0) {
					
					
					JOptionPane.showMessageDialog(null,"Remplissez le champs de password");
					
				
				 
					
				
				}else {
					
					try {
						
						
						Connection con = db.db_connect();
						PreparedStatement stmt = con.prepareStatement("INSERT INTO  utilisateur (nom,prenom,username,email,password,role)VALUES(?,?,?,?,?,?)");
					 	stmt.setString(1,nom);
						stmt.setString(2, prenom);
						stmt.setString(3, username);
						stmt.setString(4, email);
						stmt.setString(5, password);
						stmt.setString(6, value);
						stmt.executeUpdate();
						JOptionPane.showMessageDialog(null,"Mise à jour effectué");
						showTable();
						
						
						
						
					}catch(Exception Up) {
						System.out.print(Up);
					}
				}
				
				
				
				
				
			}
		});
		
//=============================REFRESH=================================================		
		btnAjouter.setBounds(64, 519, 122, 29);
		contentPane.add(btnAjouter);
		
		JButton btnActualiser = new JButton("Actualiser");
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				showTable();
				txtIdUser.setText("");
				
			}
		});
		
		
		btnActualiser.setBounds(284, 519, 122, 29);
		contentPane.add(btnActualiser);
		
		JLabel lblnom = new JLabel("Nom");
		lblnom.setBounds(12, 104, 69, 20);
		contentPane.add(lblnom);
		
		txtNom = new JTextField();
		txtNom.setBounds(91, 101, 146, 26);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
	
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(284, 52, 69, 20);
		contentPane.add(lblPrenom);
		
		JLabel lblMail = new JLabel("Email");
		lblMail.setBounds(284, 104, 61, 20);
		contentPane.add(lblMail);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnModifier.setBounds(753, 519, 122, 29);
		contentPane.add(btnModifier);
		
		JLabel lblEnregistrer = new JLabel("Enregistrez-Vous!!");
		lblEnregistrer.setBounds(53, 16, 152, 20);
		contentPane.add(lblEnregistrer);
		
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setBounds(836, 121, 69, 20);
		contentPane.add(lblSearch);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(615, 49, 146, 26);
		contentPane.add(txtUsername);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(524, 52, 81, 20);
		contentPane.add(lblUsername);
		
		JLabel lblPass = new JLabel("Password");
		lblPass.setBounds(520, 104, 69, 20);
		contentPane.add(lblPass);
		
		txtPass = new JTextField();
		txtPass.setColumns(10);
		txtPass.setBounds(615, 101, 146, 26);
		contentPane.add(txtPass);
		
		//=============================SEARCH=========================================================		
	 	this.comboBoxSearch =new JComboBox<String>();
		comboBoxSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
			Object selected =comboBoxSearch.getSelectedItem();
			if(selected.toString().equals("Nom"))
				filterCriteria= "nom";
			
			if(selected.toString().equals("Prénom"))
				filterCriteria= "prenom";
			
			if(selected.toString().equals("Courriel"))
				filterCriteria= "email";
			
			if(selected.toString().equals("Nom de l'Utilisateur"))
				filterCriteria= "username";
			
			if(selected.toString().equals("Privilege"))
				filterCriteria= "role";
			System.out.print(filterCriteria);
	
				
			}
		});
		
		comboBoxSearch.setModel(new DefaultComboBoxModel<String>(new String[]{" ","Nom","Prénom","Courriel","Nom de l'Utilisateur","Privilege"}));
		comboBoxSearch.setBounds(1088, 118, 122, 26);
		contentPane.add(comboBoxSearch);

txtSearch = new JTextField();
txtSearch.addKeyListener(new KeyAdapter() {
	@Override
	public void keyReleased(KeyEvent arg0) {
	 
	
		try {
			
			String searchObject=txtSearch.getText();
			Connection con;
			con = db.db_connect();
			PreparedStatement stmt = con.prepareStatement("SELECT  id as '#', nom as 'Nom' , prenom as 'Prénom'"
					+ " , email as 'Email', role as 'Role', username as 'Username' FROM utilisateur WHERE "+filterCriteria+" LIKE ? ");
			stmt.setString(1,  "%" +searchObject + "%");
			

			ResultSet rs = stmt.executeQuery();
			
			
			
			
			tableUtilisateur.setModel(DbUtils.resultSetToTableModel(rs));//link database data to table
			
			
			
		}catch(Exception e1) {
			
			System.out.print(e1);
			
//			JOptionPane.showMessageDialog(null, "Veuillez d'abord seletionner les critères");
								
		}
	}
});
//txtSearch.setText("searching for...");
txtSearch.setBounds(884, 118, 137, 26);
contentPane.add(txtSearch);





























		
	
		
		JScrollPane scrollPane = new JScrollPane();
		
		tableUtilisateur = new JTable() {
			
			public boolean isCellEditable(int row,int column) {
				return false;
			}//cela permet de restrincte la partie d'editable....
		};
		
		
		
		
		tableUtilisateur.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			try {  
				
				int row = tableUtilisateur.getSelectedRow();// nous permet de stocker des valeurs dans la variable row...
				
//				System.out.print(row);
				
				String Click = (tableUtilisateur.getModel().getValueAt(row, 0).toString());
				
//				System.out.print(Click);
				
				

				Connection con;
				con= db.db_connect();
				PreparedStatement stmt = con.prepareStatement("SELECT * FROM utilisateur WHERE id='"+Click+"'");
				ResultSet rs = stmt.executeQuery();
				if(rs.next()) {
					
					String data1 = rs.getString("idUser");
					String data2 = rs.getString("nom");
					String data3 = rs.getString("prenom");
					String data4 = rs.getString("username");
					String data5 = rs.getString("email");
					String data6 = rs.getString("password");
					String data7 = rs.getString("role");

					
					

					System.out.println(data1);
					System.out.println(data2);
					System.out.println(data3);
					System.out.println(data4);
					System.out.println(data5);
					System.out.println(data6);
					System.out.println(data7);
					System.out.println("_______________________________________________________________________________");
					
					txtIdUser.setText(data1);
					txtNom.setText(data2);
					txtPrenom.setText(data3);
					txtUsername.setText(data4);
					txtEmail.setText(data5);
					txtPass.setText(data6);
		 
					comboBox.setSelectedItem(data7);
					
					
					
				}
				
				
				
				
			}catch(Exception en) {
				
				System.out.print(en);
				JOptionPane.showMessageDialog(null, en);
				
			}	
				
				
				
			
				
			}// pour permettre de faire des actions sur ma table avec la souris
		});
		
		
		
		
		scrollPane.setBounds(53, 155, 772, 279);
		contentPane.add(scrollPane);
		
		
		
		
		
		scrollPane.setViewportView(tableUtilisateur);
		tableUtilisateur.setBackground(Color.WHITE);
		
		
		
		
		
		
		
		
		
		
		
		
		txtPrenom = new JTextField();
		txtPrenom.setBounds(331, 49, 146, 26);
		contentPane.add(txtPrenom);
		txtPrenom.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(331, 101, 146, 26);
		contentPane.add(txtEmail);
		
		comboBox = new JComboBox();
		comboBox.addItem("Administrateur");
		comboBox.addItem("Utilisateur");
		comboBox.setBounds(884, 49, 137, 26);
		comboBox.setEditable(false);
		contentPane.add(comboBox);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(12, 52, 69, 20);
		contentPane.add(lblId);
		
		txtIdUser = new JTextField();
		txtIdUser.setEditable(false);
		txtIdUser.setColumns(10);
		txtIdUser.setBounds(91, 49, 146, 26);
		contentPane.add(txtIdUser);

		
	
		
		
	}
	
	
	
	
	
	
	
	
	
	public static void showTable() {
		
		dbhotel db = new dbhotel();
		
		try {
			
			Connection con;
			con= db.db_connect();
			PreparedStatement userStmt = con.prepareStatement("SELECT id AS '#',nom AS 'Nom', prenom AS 'Prenom', username AS 'Username', role AS 'Role', email AS 'Email' FROM utilisateur");
			ResultSet rs = userStmt.executeQuery();
			tableUtilisateur.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e) {
			
			System.out.print(e);
		
		}
	
		
	
	}
}
