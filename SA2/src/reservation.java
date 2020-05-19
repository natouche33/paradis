
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class reservation extends JFrame {


	private JPanel contentPane;
	private JTextField txtidReservation,txtnombre;
	private static JTable tablereservation;
    private JComboBox<String> comboBoxPays;
	private JTextField  txtMail,txtPhone,txtprenom,txtnom,txtIdclient;


dbhotel db = new dbhotel();
    
	
	
	
	
	
//	  Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reservation frame = new reservation();
					frame.setVisible(true);
					showTable();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
//	  Create the frame.
	 
	public reservation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 1328, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		
		
		
		
		  
        JLabel lblNewLabel = new JLabel("Ref");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel.setBounds(275, 70, 46, 14);
        getContentPane().add(lblNewLabel);
        
        
        JDateChooser dateArr = new JDateChooser();
        dateArr.setBounds(392, 99, 121, 20);
        getContentPane().add(dateArr);
        

    	JDateChooser dateDep = new JDateChooser();
		dateDep.setBounds(392, 152, 121, 20);
		contentPane.add(dateDep);
		
        JLabel lblDateDepart = new JLabel("Date Depart");
        lblDateDepart.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblDateDepart.setBounds(275, 152, 100, 14);
        getContentPane().add(lblDateDepart);
        
        JLabel lblNombreDeClient = new JLabel("Nombre de client");
        lblNombreDeClient.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNombreDeClient.setBounds(275, 195, 108, 14);
        getContentPane().add(lblNombreDeClient);
        
        JLabel lblNumeroClient = new JLabel("Numero client");
        lblNumeroClient.setBounds(40, 71, 80, 14);
        getContentPane().add(lblNumeroClient);
        
        JLabel lblDateArrivee = new JLabel("Date Arrivee");
        lblDateArrivee.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblDateArrivee.setBounds(275, 107, 100, 14);
        getContentPane().add(lblDateArrivee);
        
        JLabel lblNom = new JLabel("Nom\r\n");
        lblNom.setBounds(40, 108, 46, 14);
        getContentPane().add(lblNom);
        
        JLabel lblPrenom = new JLabel("Prenom");
        lblPrenom.setBounds(40, 152, 46, 14);
        getContentPane().add(lblPrenom);
        
        JLabel lblPhone = new JLabel("Telephone");
        lblPhone.setBounds(40, 196, 70, 14);
        getContentPane().add(lblPhone);
        
        JLabel lblMail = new JLabel("Mail");
        lblMail.setBounds(40, 240, 46, 14);
        getContentPane().add(lblMail);
        
        JLabel lblPays = new JLabel("Pays");
        lblPays.setBounds(40, 277, 46, 14);
        getContentPane().add(lblPays);
        
        txtidReservation = new JTextField();
        txtidReservation.setBounds(392, 68, 121, 20);
        getContentPane().add(txtidReservation);
        txtidReservation.setColumns(10);
        
        txtnombre = new JTextField();
        txtnombre.setColumns(10);
        txtnombre.setBounds(392, 193, 121, 20);
        getContentPane().add(txtnombre);
        
        txtIdclient = new JTextField();
        txtIdclient.setColumns(10);
        txtIdclient.setBounds(144, 68, 121, 20);
        getContentPane().add(txtIdclient);
        
        txtnom = new JTextField();
        txtnom.setColumns(10);
        txtnom.setBounds(144, 106, 121, 20);
        getContentPane().add(txtnom);
        
        txtprenom = new JTextField();
        txtprenom.setColumns(10);
        txtprenom.setBounds(144, 146, 121, 20);
        getContentPane().add(txtprenom);
        
        txtPhone = new JTextField();
        txtPhone.setColumns(10);
        txtPhone.setBounds(144, 195, 121, 20);
        getContentPane().add(txtPhone);
        
        txtMail = new JTextField();
        txtMail.setColumns(10);
        txtMail.setBounds(144, 237, 121, 20);
        getContentPane().add(txtMail);
        
        JComboBox comboBoxPays = new JComboBox();
        comboBoxPays.addItem("Maurice");
		comboBoxPays.addItem("France");
		 comboBoxPays.addItem("Brazil");
 		comboBoxPays.addItem("Switzerland");
        comboBoxPays.setBounds(144, 277, 121, 20);
        getContentPane().add(comboBoxPays);
		
		
		
        JLabel lblNewLabel_1 = new JLabel("Formulaire d'enregistrement");
        lblNewLabel_1.setFont(new Font("Georgia", Font.ITALIC, 17));
        lblNewLabel_1.setBounds(196, 11, 249, 33);
        getContentPane().add(lblNewLabel_1);
        
        JLabel lbldateres = new JLabel("Date Reservation");
        lbldateres.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lbldateres.setBounds(275, 239, 108, 14);
        getContentPane().add(lbldateres);
		
		
		
        JDateChooser dateres = new JDateChooser();
		dateres.setBounds(392, 240, 121, 20);
		contentPane.add(dateres);
		
		
		
		
		
		
		
		
		
		
	
		
//================================ EFFACER ===========================================================			
		JButton btnEffacer = new JButton("Effacer");
		btnEffacer.setBackground(new Color(240, 248, 255));
		btnEffacer.setForeground(Color.BLACK);
		btnEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
//reservation
//                String id_reservation =txtid_reservation.getText();
        		String dateArrivee=((JTextField)  dateArr.getDateEditor().getUiComponent()).getText();
        		String dateDepart=((JTextField) dateDep.getDateEditor().getUiComponent()).getText();
				String nombre  	= txtnombre.getText();
				String dateReservation =((JTextField) dateres.getDateEditor().getUiComponent()).getText();
				
				//client
				String id_client = txtIdclient.getText();
				String nom	    =  txtnom .getText();
				String prenom	= txtprenom.getText();
				String adresse 		= txtPhone .getText();
				String mail 		= txtMail .getText();
				String value	    = comboBoxPays.getSelectedItem().toString();
				
				
				//reservation
				
				System.out.println(dateArrivee);
				System.out.println(dateDepart);
				System.out.println(nombre);
				System.out.println(dateReservation);
				//client
				
				System.out.println(nom);
				System.out.println(prenom);
				System.out.println(adresse);
				System.out.println(mail);
				System.out.println(value);
				
				
				
				
        		
				if(  nom.trim().length()==0 || prenom.trim().length()==0 || adresse.trim().length()==0 || mail.trim().length()==0 || value.trim().length()==0 || 
					dateArrivee.trim().length()==0 ||dateDepart.trim().length()==0 || nombre.trim().length()==0 ||dateReservation.trim().length()==0)
			     {
				JOptionPane.showMessageDialog(null,"Remplissez tous les champs SVP");
				return;
        		
			}else {
				
				try {
					
					dbhotel db= new dbhotel();
					String idReservation   = txtidReservation.getText();

				
					Connection con;
					con =db.db_connect();

					PreparedStatement findIdClient=con.prepareStatement("Select id_client FROM reservation WHERE id_reservation=?");
					findIdClient.setString(1, idReservation );
					ResultSet rs = findIdClient.executeQuery();
					if(rs.next()) {
					String id=rs.getString("id_client");
					// System.out.print(id);

					PreparedStatement stmt = con.prepareStatement("DELETE FROM RESERVATION WHERE id_reservation=?");
					stmt.setString(1, idReservation );
					stmt.executeUpdate();
				

					PreparedStatement stmt2 = con.prepareStatement("DELETE FROM client WHERE id_client=?");
					stmt2.setString(1, id);
					stmt2.executeUpdate();
					JOptionPane.showMessageDialog(null,"Suppression effectuée");
					
					
					
					}
						
				}catch(Exception D) {
					System.out.print(D);
				
				
			
			}
				}		 
				
			}
		});
		
		
        
		
		btnEffacer.setBounds(290, 335, 122, 29);
		contentPane.add(btnEffacer);
//================================ AJOUTER ===========================================================		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setBackground(new Color(240, 248, 255));
		btnEnregistrer.addActionListener(new ActionListener() {
			
            	public void actionPerformed(ActionEvent arg0) {
            		//reservation
            		
            		String dateArrivee=((JTextField)  dateArr.getDateEditor().getUiComponent()).getText();
            		String dateDepart=((JTextField) dateDep.getDateEditor().getUiComponent()).getText();
    				String nombre  	= txtnombre.getText();
    				String dateReservation =((JTextField) dateres.getDateEditor().getUiComponent()).getText();
    				
    				
    				//client
    				String id_client = txtIdclient.getText();
    				String nom	    =  txtnom .getText();
    				String prenom	= txtprenom.getText();
    				String adresse 		= txtPhone .getText();
    				String mail 		= txtMail .getText();
    				String value	    = comboBoxPays.getSelectedItem().toString();
    				
    				
    				//reservation
    				
    				System.out.println(dateArrivee);
    				System.out.println(dateDepart);
    				System.out.println(nombre);
    				System.out.println(dateReservation);
    				//client
    				
    				System.out.println(nom);
    				System.out.println(prenom);
    				System.out.println(adresse);
    				System.out.println(mail);
    				System.out.println(value);
    				
    				
    				
    				
            		
    				if(  nom.trim().length()==0 || prenom.trim().length()==0 || adresse.trim().length()==0 || mail.trim().length()==0 || value.trim().length()==0 || 
    					dateArrivee.trim().length()==0 ||dateDepart.trim().length()==0 || nombre.trim().length()==0 ||dateReservation.trim().length()==0)
    			     {
    				JOptionPane.showMessageDialog(null,"Remplissez tous les champs SVP");
    				return;
            		
    				
            	
} else {
					
					try {
						
						
						Connection con = db.db_connect();
						
                        
                        PreparedStatement stmtClient = con.prepareStatement("INSERT INTO client (nom,prenom,adresse,mail,pays) values(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);      
                       
                        
                        stmtClient.setString(1,nom);
                        stmtClient.setString(2,prenom);
                        stmtClient.setString(3,adresse);
                        stmtClient.setString(4,mail);
                        stmtClient.setString(5,value);
                        stmtClient.executeUpdate();
                        ResultSet rs = stmtClient.getGeneratedKeys();
                        
                        if(rs.next()) {
                        	
                            id_client=rs.getString(1);

							
							 
							PreparedStatement stmt1 = con.prepareStatement("INSERT INTO reservation(dateArrivee,dateDepart,nbPersonnes,dateReservation,id_client) VALUES( ?,?,?,?,?");
							stmt1.setString(1, dateArrivee);
							stmt1.setString(2,dateDepart);
							stmt1.setString(3, nombre);
							stmt1.setString(4,dateReservation);
							stmt1.setString(5, id_client);
							stmt1.executeUpdate();
						}
							JOptionPane.showMessageDialog(null,"reservation confirmer"); 
						 	showTable();
						
						
						
						
 
					}catch(Exception e1) {
						System.out.print(e1);
						
					}
				
				}
			}
		});
		
		btnEnregistrer.setBounds(10, 335, 122, 29);
		contentPane.add(btnEnregistrer);
		
		
//====================================REFRESH=================================================		
		
		JButton btnActualiser = new JButton("Actualiser");
		btnActualiser.setBackground(new Color(240, 248, 255));
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				txtIdclient.setText("");
				
				showTable();
			}
		});
		
		
		btnActualiser.setBounds(143, 335, 122, 29);
		contentPane.add(btnActualiser);
//===========================================================================================		
		
		
		

//====================================MODIFIER================================================
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBackground(new Color(240, 248, 255));
		btnModifier.addActionListener(new ActionListener() {
			private String id_client;

			public void actionPerformed(ActionEvent e) {
			
				//reservation
				String idReservation = txtidReservation.getText();
        		String date_arrivee=((JTextField)  dateArr.getDateEditor().getUiComponent()).getText();
        		String date_depart=((JTextField) dateDep.getDateEditor().getUiComponent()).getText();
				String nombre  	= txtnombre.getText();
				String date_reservation =((JTextField) dateres.getDateEditor().getUiComponent()).getText();
				
				//client
				String id_client = txtIdclient.getText();
				String nom	    =  txtnom .getText();
				String prenom	= txtprenom.getText();
				String adresse 		= txtPhone .getText();
				String mail 		= txtMail .getText();
				String value	    = comboBoxPays.getSelectedItem().toString();
				
				
				//reservation
				
				System.out.println(date_arrivee);
				System.out.println(date_depart);
				System.out.println(nombre);
				System.out.println(date_reservation);
				//client
				
				System.out.println(nom);
				System.out.println(prenom);
				System.out.println(adresse);
				System.out.println(mail);
				System.out.println(value);
				
				
				
				
        		
				if(  nom.trim().length()==0 || prenom.trim().length()==0 || adresse.trim().length()==0 || mail.trim().length()==0 || value.trim().length()==0 || 
					date_arrivee.trim().length()==0 ||date_depart.trim().length()==0 || nombre.trim().length()==0 ||date_reservation.trim().length()==0)
			     {
				JOptionPane.showMessageDialog(null,"Remplissez tous les champs SVP");
				return;
        		
				
        	
			
				
				}else {
					
					try {
	
						
//=========================================Connexion pour la table Client============================================================================						
			
						
						Connection con = db.db_connect();
						
                        
                        PreparedStatement stmtClient = con.prepareStatement("UPDATE client nom=?,prenom=?,adresse=?,mail=?,pays=? where id_client=?",Statement.RETURN_GENERATED_KEYS);      
                       
                        stmtClient.setString(1,nom);
                        stmtClient.setString(2,prenom);
                        stmtClient.setString(3,adresse);
                        stmtClient.setString(4,mail);
                        stmtClient.setString(5,value);
                        stmtClient.executeUpdate();
                        ResultSet rs =stmtClient.getGeneratedKeys();
                        
                        if(rs.next()) {
                        	
                             id_client= rs.getString(1);

                        
                        
                        
//==================================================Connection pour la table reservation=======================================================================================================================================================================                        
						
                        PreparedStatement stmt = con.prepareStatement("UPDATE reservation idReservation=?,date_arrivee=?,date_depart=?, nb_personnes=?,date_reservation=?,id_client=? WHERE id_reservation=?" );
						stmt.setString(1,idReservation);
						stmt.setString(2,date_arrivee);
						stmt.setString(3,date_depart);
						stmt.setString(4,nombre);
						stmt.setString(5,date_reservation);
						stmt.setString(6,id_client);
						stmt.executeUpdate();
                        }
                        
						JOptionPane.showMessageDialog(null,"Vos données ont été bien envoyées");
						showTable();
				
					
						
						
					}catch(Exception Mo) {
						System.out.print(Mo);
					}
				}
				
				
				
			}
		});
		btnModifier.setBounds(421, 335, 122, 29);
		contentPane.add(btnModifier);
//======================================================================================================
		
		
		
		



//===========================================================================================================



		
		JScrollPane scrollPane = new JScrollPane();
		
		tablereservation = new JTable() {
			
			public boolean isCellEditable(int row,int column) {
				return false;
			}//cela permet de restrincte la partie d'editable....
		};
		
		
		
		
		tablereservation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			try {  
				
				int row = tablereservation.getSelectedRow(); //nous permet de stocker des valeurs dans la variable row...
				
//				System.out.print(row);
				
				String Click = (tablereservation.getModel().getValueAt(row, 0).toString());
				
//				System.out.print(Click);
//				
				

				Connection con;
				con= db.db_connect();
				PreparedStatement stmt = con.prepareStatement(
						"SELECT  FROM reservation inner join categorie ON reservation.id_client = client.id_client WHERE idReservation=?'"+Click+"' ");
				ResultSet rs = stmt.executeQuery();
				if(rs.next()) {
					
					
					
					String data1 = rs.getString("id_reservation");
//					String data2 = rs.getString("date_arrivee");
//					String data3 = rs.getString("date_depart");
					String data4 = rs.getString("nb_personnes");
//					String data5 = rs.getString("date_reservation");
					String data6 = rs.getString("id_client");
					String data7 = rs.getString("nom");
					String data8 = rs.getString("prenom");
					String data9 = rs.getString("adresse");
					String data10 = rs.getString("mail");
					String data11 = rs.getString("pays");
					
					System.out.print(data11);
 
					
					txtidReservation.setText(data1);
//					dateArr.getDateEditor().getUiComponent(()).setText(data2);
					
					txtnombre.setText(data4);
					txtIdclient.setText(data6);
					txtnom.setText(data7);
					txtprenom.setText(data8);
					txtPhone.setText(data9);
					txtMail.setText(data10);
					comboBoxPays.setSelectedItem(data11);
					
					 
					
					
					
				}
				
				
				
				
			}catch(Exception en) {
				
				System.out.print(en);
				JOptionPane.showMessageDialog(null, en);
				
			}	
				
				
				
			
				
			}// pour permettre de faire des actions sur ma table avec la souris
		});
		
		
		
		
		scrollPane.setBounds(553, 29, 749, 493);
		contentPane.add(scrollPane);
		
		
		
		
		
		scrollPane.setViewportView(tablereservation);
		tablereservation.setBackground(Color.WHITE);
		
	
		
		
		
		
		
		
		
		
		

		
		
 

	
		
	}
	
	
	
	
	
	
	
	
	
	public static void showTable() {
		
	dbhotel db = new dbhotel();
		
		try {
			
			Connection con;
			con= db.db_connect();
			PreparedStatement clientStmt = con.prepareStatement("SELECT id_reservation As'#',date_arrivee AS'Date Avrriee',date_depart AS 'Date Depart',nb_personnes AS 'Nombre Client',date_reservation AS'Date Reservation ', reservation.id_client AS 'No',nom AS'Nom',prenom AS'Prenom',adresse AS 'Adresse',mail AS'Mail',pays AS'Pays' FROM reservation inner join client ON reservation.id_client = client.id_client");
			ResultSet rs = clientStmt.executeQuery();
			tablereservation.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e) {
			
			System.out.print(e);
		
		}
	
		
	
	}
}
