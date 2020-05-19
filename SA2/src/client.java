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
//import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JComboBox.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
 
 


public class client extends JFrame {

	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtSearchingFor;
	private JTextField txtSearch;
	private static JTable tableClient;
	private JTextField txtPrenom;
	private JTextField txtEmail;
//	private JTextField txtAge;
	private JComboBox<String> comboBoxSexe,comboBoxSearch, comboBoxPays;
	private JTextField txtIdClient;
	private String filterCriteria;

	dbhotel db = new dbhotel();
	private JTextField textAge;
	private JTextField textPhone;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					client frame = new client();
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
	public client() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 1328, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
	//////////////////////////// Bouton de Connection//////////////////	
		
		JButton btnDconnexion = new JButton("Deconnexion");
		btnDconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
	
                                                
                                                
                                
				
				
				
				
				
			}
			
			
			
			
			
			
		});
		btnDconnexion.setBounds(21, 492, 137, 29);
		contentPane.add(btnDconnexion);
		
		
		
		
		
//================================ DELETE ===============================================================//		
		JButton btnDelete = new JButton("Effacer");
		btnDelete.setForeground(Color.RED);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String id_client = txtIdClient.getText();
				String nom = txtNom.getText();
				String prenom = txtPrenom.getText();
				String email = txtEmail.getText();
				String phone = textPhone.getText();
				String age = textAge.getText();
				String sexe = comboBoxSexe.getSelectedItem().toString();
				String pays = comboBoxPays.getSelectedItem().toString();
				
		
				
				
if( nom.trim().length()==0 || prenom.trim().length()==0  || email.trim().length()==0  || age.trim().length()==0 || pays.trim().length()==0 || phone.trim().length()==0 ){
		
					
					JOptionPane.showMessageDialog(null, "Remplissez les champs");

			}else {
				
				try {
					
					
					Connection con = db.db_connect();
					PreparedStatement stmt = con.prepareStatement("DELETE FROM client WHERE id_client=?");
					
				 	stmt.setString(1,id_client);
			 
					stmt.executeUpdate();
					JOptionPane.showMessageDialog(null,"Mise à jour effectué");
					showTable();
					
					
					
					
				}catch(Exception Up) {
					System.out.print(Up);
				}
				
			}
			
				 
				
			}
		});
		btnDelete.setBounds(795, 522, 122, 29);
		contentPane.add(btnDelete);
		
		
		
///////////////////////////// NEW ////////////////////////////////////////////////////		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setSelectedIcon(new ImageIcon("C:\\Users\\Nathanielle\\Documents\\eclispe\\SA2\\src\\images\\check.png"));
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		 
				
				String id_client = txtIdClient.getText();
				String nom = txtNom.getText();
				String prenom = txtPrenom.getText();
				String email = txtEmail.getText();
				String age = textAge.getText();
				String phone = textPhone.getText();
				String sexe = comboBoxSexe.getSelectedItem().toString();
				String pays = comboBoxPays.getSelectedItem().toString();
			
				
//=======================================Faire la validation==================================================
if( nom.trim().length()==0 && prenom.trim().length()==0 &&  email.trim().length()==0 &&  age.trim().length()==0 &&  pays
.trim().length()==0 &&  phone.trim().length()==0){
		
					
					JOptionPane.showMessageDialog(null, "Remplissez les champs");

			}
			
				 else if(nom.trim().length()==0) {
					
					 JOptionPane.showMessageDialog(null,"Remplissez le champs de nom");
					
				}else if(prenom.trim().length()==0) {
				
					JOptionPane.showMessageDialog(null,"Remplissez le champs de nom");
					
				}
				
				else if(email.trim().length()==0) {
					
					
					JOptionPane.showMessageDialog(null,"Remplissez le champs de email");
					
				
				}
				else if(age.trim().length()==0) {
					
					
					JOptionPane.showMessageDialog(null,"Veuiller mettre l'age exacte");
					
				
				}
				
				
				
				
				else {
					
					try {
						
						
						Connection con = db.db_connect();
						PreparedStatement stmt = con.prepareStatement("INSERT INTO client(nom,prenom,sexe,email,pays,age,phone)VALUES(?,?,?,?,?,?,?)");
					 	stmt.setString(1,nom);
						stmt.setString(2, prenom);
						stmt.setString(3, sexe);
						stmt.setString(4, email);
						stmt.setString(5, pays);
						stmt.setString(6, age);
						stmt.setString(7, phone);
						stmt.executeUpdate();
						JOptionPane.showMessageDialog(null,"Mise à jour effectué");
						showTable();
						
						
						
						
					}catch(Exception Up) {
						System.out.print(Up);
					}
				}
				
				
				
				
				
			}
		});
		btnAjouter.setBounds(588, 522, 122, 29);
		contentPane.add(btnAjouter);
///////////////////////////////////////////////////////REFRESH/////////////////////////////////////////
		
		
		JButton btnActualiser = new JButton("Actualiser");
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				showTable();
				txtIdClient.setText("");
				txtNom.setText("");
				txtPrenom.setText("");
				txtEmail.setText("");
				textAge.setText("");
				textPhone.setText("");
				
			}
		});
		
		
		btnActualiser.setBounds(795, 33, 122, 29);
		contentPane.add(btnActualiser);
		
		JLabel lblnom = new JLabel("Nom");
		lblnom.setBounds(0, 116, 69, 20);
		contentPane.add(lblnom);
		
		txtNom = new JTextField();
		txtNom.setBounds(91, 113, 146, 26);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
	
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(0, 153, 69, 20);
		contentPane.add(lblPrenom);
		
		JLabel lblMail = new JLabel("Email");
		lblMail.setBounds(0, 195, 69, 20);
		contentPane.add(lblMail);
		

		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(0, 297, 69, 20);
		contentPane.add(lblAge);
	//////////////////////// Pour Faire des modifications sur la table/////////////////////	
		
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

           
				String id_client = txtIdClient.getText();
				String nom = txtNom.getText();
				String prenom = txtPrenom.getText();
				String email = txtEmail.getText();
				String age = textAge.getText();
				String phone = textPhone.getText();
				String sexe = comboBoxSexe.getSelectedItem().toString();
				String pays = comboBoxPays.getSelectedItem().toString();
			     
// ///////////////////////////////Faire la Validation/////////////////////////////////////////////////////////                                        
                                                
if(nom.trim().length()==0 && prenom.trim().length()==0&& email.trim().length()==0 && age.trim().length()==0 && phone.trim().length()==0 && sexe.trim().length()==0 && pays.trim().length()==0)

{
JOptionPane.showMessageDialog(null,"Remplissez tous les champs");
                                               
 
	
	
	 } else if(nom.trim().length()==0) {
			
		 JOptionPane.showMessageDialog(null,"Remplissez le champs de nom");
		
	}else if(prenom.trim().length()==0) {
	
		JOptionPane.showMessageDialog(null,"Remplissez le champs prenom");
		
	}
	
	else if(email.trim().length()==0) {
		
		
		JOptionPane.showMessageDialog(null,"Remplissez le champs de email");
		
	
	}
	else if(age.trim().length()==0) {
		
		
		JOptionPane.showMessageDialog(null,"Veuiller mettre l'age exacte");
		
	
	}
	else if(phone.trim().length()==0) {
		
		
		JOptionPane.showMessageDialog(null,"Veuiller mettre l'age exacte");
		
	
	}
else if(pays.trim().length()==0) {
		
		
		JOptionPane.showMessageDialog(null,"Veuiller entrer le pays exacte");
		
	
	}
else if(sexe.trim().length()==0) {
	
	
	JOptionPane.showMessageDialog(null,"Veuiller entrer le pays exacte");
	

}
	
	
   try {
                            Connection con;
                            con = db.db_connect();
                            PreparedStatement stmt = con.prepareStatement("UPDATE client SET nom=?,prenom=?,email=?,age=?,phone=?,sexe=?,pays=? WHERE id_client=?");
                            stmt.setString(1, nom);
                            stmt.setString(2, prenom);
                            stmt.setString(3, email);
                            stmt.setString(4, age);
                            stmt.setString(5, phone);
                            stmt.setString(6, sexe);
                            stmt.setString(7, pays);
                            stmt.setString(8, id_client);

                            stmt.executeUpdate();
                            
      JOptionPane.showMessageDialog(null,"La mise a jour a bien été effectué");
     	showTable();
    	}catch(Exception e1) {
    		System.out.print(e1);                                                                
                                                                                
              }
                                                
    }
                                                
                                                
                                
            
                
                 

				
				
				
				
				
				
				
				
			
		});
		btnModifier.setBounds(1016, 522, 122, 29);
		contentPane.add(btnModifier);
		
		JLabel lblEnregistrer = new JLabel("Enregistrez-Vous!!");
		lblEnregistrer.setBounds(53, 16, 152, 20);
		contentPane.add(lblEnregistrer);
		
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setBounds(365, 37, 69, 20);
		contentPane.add(lblSearch);
		
		JLabel lblSexe = new JLabel("Sexe");
		lblSexe.setBounds(0, 328, 81, 20);
		contentPane.add(lblSexe);
		
		JLabel lblPays = new JLabel("Pays");
		lblPays.setBounds(0, 365, 69, 20);
		contentPane.add(lblPays);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(0, 242, 69, 20);
		contentPane.add(lblPhone);
		////////////////////////////////////////////SEARCH//////////////////////////////////////////////////////////////////////////////		
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
			
			if(selected.toString().equals("Sexe"))
				filterCriteria= "sexe";
			
			if(selected.toString().equals("Pays"))
				filterCriteria= "pays";
			
			if(selected.toString().equals("Phone"))
				filterCriteria= "hone";
				
			}
		});
		
		comboBoxSearch.setModel(new DefaultComboBoxModel<String>(new String[]{" ","Nom","Prénom","Courriel","Sexe","Pays","Phone"}));
		comboBoxSearch.setBounds(611, 34, 122, 26);
		contentPane.add(comboBoxSearch);

txtSearch = new JTextField();
txtSearch.addKeyListener(new KeyAdapter() {
	@Override
	public void keyReleased(KeyEvent arg0) {
	 
	
		try {
			
			String searchObject=txtSearch.getText();
			Connection con;
			con = db.db_connect();
			PreparedStatement stmt = con.prepareStatement("SELECT  id_client as '#', nom as 'Nom' , prenom as 'Prénom'"
					+ " , email as 'Email', sexe as 'Sexe', pays as 'Pays', phone as 'Numero de Telephone FROM client WHERE "+filterCriteria+" LIKE ? ");
			stmt.setString(1,  "%" +searchObject + "%");
			

			ResultSet rs = stmt.executeQuery();
			
			
			
			
			tableClient.setModel(DbUtils.resultSetToTableModel(rs));//link database data to table
			
			
			
		}catch(Exception e1) {
			
			System.out.print(e1);

		}
	}
});





txtSearch.setBounds(456, 34, 126, 26);
contentPane.add(txtSearch);



		JScrollPane scrollPane = new JScrollPane();
		
		tableClient= new JTable() {
			
			public boolean isCellEditable(int row,int column) {
				return false;
			}//cela permet de restrincte la partie d'editable....
		};
		
		
		
		
		tableClient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			try {  
				
				int row = tableClient.getSelectedRow();//////////////nous permet de stocker des valeurs dans la variable row///////////////////////
				
//				System.out.print(row);
				
				String Click = (tableClient.getModel().getValueAt(row, 0).toString());
				
//				System.out.print(Click);
				
				

				Connection con;
				con= db.db_connect();
				PreparedStatement stmt = con.prepareStatement("SELECT * FROM client WHERE id_client='"+Click+"'");
				ResultSet rs = stmt.executeQuery();
				if(rs.next()) {
					
					String data1 = rs.getString("id_client");
					String data2 = rs.getString("nom");
					String data3 = rs.getString("prenom");
					String data4 = rs.getString("sexe");
					String data5 = rs.getString("email");
					String data6 = rs.getString("pays");
					int data7 = rs.getInt("age");
					int data8 = rs.getInt("phone");
					
					

					System.out.println(data1);
					System.out.println(data2);
					System.out.println(data3);
					System.out.println(data4);
					System.out.println(data5);
					System.out.println(data6);
					System.out.println(data7);
					System.out.println(data8);
					
					System.out.println("_______________________________________________________________________________");
					
					txtIdClient.setText(data1);
					txtNom.setText(data2);
					txtPrenom.setText(data3);
					comboBoxSexe.setSelectedItem(data4);
					txtEmail.setText(data5);
					comboBoxPays.setSelectedItem(data6);

		 
					
					
					
					
				}
				
				
				
				
			}catch(Exception en) {
				
				System.out.print(en);
				JOptionPane.showMessageDialog(null, en);
				
			}	
				
				
				
			
				
			}//////////// pour permettre de faire des actions depuis table avec la souris////////////////////////////////////
		});
		
	
		
		
		
		
		scrollPane.setBounds(346, 71, 602, 261);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(tableClient);
		tableClient.setBackground(Color.WHITE);
	
		txtPrenom = new JTextField();
		txtPrenom.setBounds(91, 150, 146, 26);
		contentPane.add(txtPrenom);
		txtPrenom.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(91, 192, 146, 26);
		contentPane.add(txtEmail);
		

		comboBoxSexe = new JComboBox();
		comboBoxSexe.addItem("Female");
		comboBoxSexe.addItem("Male");
		comboBoxSexe.setBounds(91, 325, 146, 26);
		comboBoxSexe.setEditable(false);
		contentPane.add(comboBoxSexe);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(0, 79, 69, 20);
		contentPane.add(lblId);
		
		txtIdClient = new JTextField();
		txtIdClient.setEditable(false);
		txtIdClient.setColumns(10);
		txtIdClient.setBounds(91, 76, 146, 26);
		contentPane.add(txtIdClient);
		
		this.comboBoxPays = new JComboBox();
		comboBoxPays.setModel(new DefaultComboBoxModel<String>(new String[] {" ","Afghanistan", "Afrique du Sud", "Albanie",
				"Alg\u00E9rie", "Allemagne", "Andorre", "Angola", "Antigua-et-Barbuda","Arabie Saoudite", "Argentine",
				"Arm\u00E9nie", "Australie", "Autriche", "Azerba\u00EFdjan", "Bahamas", "Bahre\u00EFn", "Bangladesh", 
				"Barbade", "Belau", "Belgique", "Belize", "B\u00E9nin", "Bhoutan", "Bi\u00E9lorussie", "Birmanie", 
				"Bolivie", "Bosnie-Herz\u00E9govine", "Botswana", "Br\u00E9sil", "Brunei", "Bulgarie", "Burkina", "Burundi", 
				"Cambodge", "Cameroun", "Canada", "Cap-Vert", "Chili", "Chine", "Chypre", "Colombie", "Comores", "Congo", 
				"Cook", "Cor\u00E9e du Nord", "Cor\u00E9e du Sud", "Costa Rica", "C\u00F4te d'Ivoire", "Croatie", "Cuba", 
				"Danemark", "Djibouti", "Dominique", "\u00C9gypte", "\u00C9mirats arabes unis", "\u00C9quateur", "\u00C9rythr\u00E9e",
				"Espagne", "Estonie", "\u00C9tats-Unis", "\u00C9thiopie", "Fidji", "Finlande", "France", "Gabon", "Gambie",
				"G\u00E9orgie", "Ghana", "Gr\u00E8ce", "Grenade", "Guatemala", "Guin\u00E9e", "Guin\u00E9e-Bissao", "Guin\u00E9e \u00E9quatoriale",
				"Guyana", "Ha\u00EFti", "Honduras", "Hongrie", "Inde", "Indon\u00E9sie", "Iran", "Iraq", "Irlande", "Islande", "Isra\u00EBl",
				"Italie", "Jama\u00EFque", "Japon", "Jordanie", "Kazakhstan", "Kenya", "Kirghizistan", "Kiribati", "Kowe\u00EFt", "Laos", 
				"Lesotho", "Lettonie", "Liban", "Liberia", "Libye", "Liechtenstein", "Lituanie", "Luxembourg", "Mac\u00E9doine", "Madagascar", "Malaisie",
				"Malawi", "Maldives", "Mali", "Malte", "Maroc", "Marshall", "Maurice", "Mauritanie", "Mexique", "Micron\u00E9sie", "Moldavie",
				"Monaco", "Mongolie", "Mozambique", "Namibie", "Nauru", "N\u00E9pal", "Nicaragua", "Niger", "Nigeria", "Niue", 
				"Norv\u00E8ge", "Nouvelle-Z\u00E9lande", "Oman", "Ouganda", "Ouzb\u00E9kistan", "Pakistan", "Panama", "Papouasie - Nouvelle Guin\u00E9e",
				"Paraguay", "Pays-Bas", "P\u00E9rou", "Philippines", "Pologne", "Portugal", "Qatar", "R\u00E9publique Centrafricaine",
				"R\u00E9publique Dominicaine", "R\u00E9publique tch\u00E8que", "Roumanie", "Royaume-Uni", "Russie", "Rwanda", 
				"Saint-Christophe-et-Ni\u00E9v\u00E8s", "Sainte-Lucie", "Saint-Marin", "Saint-Si\u00E8ge, ou leVatican", "Saint-Vincent-et-les Grenadines"
				, "Salomon", "Salvador", "Samoa occidentales", "Sao Tom\u00E9-et-Principe", "S\u00E9n\u00E9gal", "Seychelles", "Sierra Leone", 
				"Singapour", "Slovaquie", "Slov\u00E9nie", "Somalie", "Soudan", "Sri Lanka", "Su\u00E8de", "Suisse", "Suriname",
				"Swaziland", "Syrie", "Tadjikistan", "Tanzanie", "Tchad", "Tha\u00EFlande", "Togo", "Tonga", "Trinit\u00E9-et-Tobago",
				"Tunisie", "Turkm\u00E9nistan", "Turquie", "Tuvalu", "Ukraine", "Uruguay", "Vanuatu", "Venezuela", "Vi\u00EAt Nam",
				"Y\u00E9men", "Yougoslavie", "Za\u00EFre", "Zambie", "Zimbabwe"}));
		
		
		
		comboBoxPays.setBounds(91, 362, 146, 26);
		contentPane.add(comboBoxPays);
		
		textAge = new JTextField();
		textAge.setColumns(10);
		textAge.setBounds(91, 288, 146, 26);
		contentPane.add(textAge);
		
	
		
		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(91, 242, 146, 26);
		contentPane.add(textPhone);

		
	
		
		
	}
	
	
	
	
	
	
	
	
	
	public static void showTable() {
		
		dbhotel db = new dbhotel();
		
		try {
			
			Connection con;
			con= db.db_connect();
			PreparedStatement userStmt = con.prepareStatement("SELECT id_client AS '#',nom AS 'Nom', prenom AS 'Prenom', sexe AS 'Sexe', email AS 'Email' , pays as 'Pays' , age as'Age' ,phone as 'Numero de Telephone' FROM client");
			ResultSet rs = userStmt.executeQuery();
			tableClient.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e) {
			
			System.out.print(e);
		
		}
	
		
	
	}
}
