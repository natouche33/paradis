import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;

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
import java.awt.SystemColor;

public class chambre extends JFrame {


	private JPanel contentPane;
	private JTextField txtNomChambre,txtNumChambre;
	private JTextField txtSearchChambre;
	private static JTable tableChambre;
	private JTextField txtSuperficie;
	private JComboBox<String> comboBoxType,comboBoxChambre;
	private JTextField txtIdChambre;
	private JTextField txtidCategorie;
	private String filterCriteria;
    private JTextField txtTarrif;
	dbhotel db = new dbhotel();
	private JFrame frame;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chambre frame = new chambre();
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
	public chambre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 1328, 700);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDconnexion = new JButton("D\u00E9connexion");
		btnDconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				dispose();
//				Gestion frame = new Gestion("role","nom");
				frame.setVisible(true);
				
				
			}
		});
		btnDconnexion.setBounds(218, 551, 137, 40);
		contentPane.add(btnDconnexion);
		
		
		
//=================================================== EFFACER =======================================================================//			
		JButton btnDelete = new JButton("Effacer");
		btnDelete.setForeground(Color.RED);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String id_chambre	= txtIdChambre.getText();
				String id_categorie	= txtidCategorie.getText();
				String nomChambre 	= txtNomChambre.getText();
				String numChambre 	= txtNumChambre.getText();
				String superficie 	= txtSuperficie.getText();
				String tarif 		= txtTarrif.getText();
				String value	    = comboBoxType.getSelectedItem().toString();
				
				
if( nomChambre.trim().length()==0 || numChambre.trim().length()==0 || superficie.trim().length()==0 || tarif.trim().length()==0 ||   value.trim().length()==0){
		
					
					JOptionPane.showMessageDialog(null, "Remplissez les champs");

			}else {
				
				try {
					
					
					Connection con = db.db_connect();
					PreparedStatement stmtCa = con.prepareStatement("DELETE FROM categorie WHERE id_categorie=? ");
				 	stmtCa.setString(1,id_categorie);
				 	stmtCa.executeUpdate();
				 PreparedStatement stmtCh = con.prepareStatement("DELETE FROM chambre WHERE id_chambre=? ");
				 	stmtCh.setString(1,id_chambre);
				 	stmtCh.executeUpdate();
					
				 	ResultSet rs = null;
					if(rs.next()) {
                    	id_categorie=rs.getString(1);	
				
					
				 	}else {
				 		
				 		

					 	ResultSet c = null;
					
	                    	id_chambre=rs.getString(1);	
							
				 	}
					

				 	
					
			 
				 
					
					
				 	
					JOptionPane.showMessageDialog(null,"Vos champs a été effacé");
					showTable();
					
					
					
					
				}catch(Exception D) {
					System.out.print(D);
				}
				
			}
			
				 
				
			}
		});
		
		
		btnDelete.setBounds(15, 551, 122, 40);
		contentPane.add(btnDelete);
//================================ AJOUTER ===========================================================		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id_chambre    = txtIdChambre.getText();
				String id_categorie  = txtidCategorie.getText();
				String nomChambre 	= txtNomChambre.getText();
				String numChambre 	= txtNumChambre.getText();
				String superficie 	= txtSuperficie.getText();
				String tarif 		= txtTarrif.getText();
				String value 		= comboBoxType.getSelectedItem().toString();
				
				
//================================Validation pour le bouton ajouter========================================================
if( id_chambre.trim().length()==0 && id_categorie.trim().length()==0 && nomChambre.trim().length()==0 && numChambre.trim().length()==0 && superficie.trim().length()==0 && tarif.trim().length()==0 &&  value.trim().length()==0 ){
		
					
					JOptionPane.showMessageDialog(null, "Remplissez les champs");

			}
			
				 else if(nomChambre.trim().length()==0) {
					
					 JOptionPane.showMessageDialog(null,"Remplissez le champs de nom de chambre");
					
				}else if(numChambre.trim().length()==0) {
				
					JOptionPane.showMessageDialog(null,"Remplissez le champs de numéro de chambre");
					
				}else if(superficie.trim().length()==0) {
					
					
					JOptionPane.showMessageDialog(null,"Remplissez le champs de superficie");
					
				
				}else if(tarif.trim().length()==0) {
					
					
					JOptionPane.showMessageDialog(null,"Remplissez le champs de tarif");
					
				
	 
					
				
				 
					
				
				}else {
					
					try {
						
//=========================================Connexion pour la table Categorie============================================================================						
			
						
						Connection con = db.db_connect();
						
                        
                        PreparedStatement stmtCategorie = con.prepareStatement("INSERT INTO categorie (tarif,type) values(?,?)",Statement.RETURN_GENERATED_KEYS);      
                       
                        stmtCategorie.setString(2,value);
                        stmtCategorie.setString(1,tarif);
                        stmtCategorie.executeUpdate();
                        ResultSet rs =stmtCategorie.getGeneratedKeys();
                        
                        if(rs.next()) {
                        	
                            id_categorie=rs.getString(1);

                        
                        
                        
//==================================================Connexion pour la table Chambre=======================================================================================================================================================================                        
						
                        PreparedStatement stmtChambre = con.prepareStatement("INSERT INTO chambre (id_categorie,nomChambre,superficie,numChambre)VALUES(?,?,?,?) ");
						stmtChambre.setString(1,id_categorie);
						stmtChambre.setString(2,nomChambre);
						stmtChambre.setString(3,superficie);
						stmtChambre.setString(4,numChambre);
						stmtChambre.executeUpdate();
                        }
                        
						JOptionPane.showMessageDialog(null,"Vos données ont été bien envoyées");
						showTable();
						
					
					}catch(Exception Aj) {
						System.out.print(Aj);
					}
				}
				
				
				
				
				
			}
			
		});
		
		
		btnAjouter.setBounds(20, 446, 122, 40);
		contentPane.add(btnAjouter);
		
		
//====================================REFRESH=================================================		
		
		JButton btnActualiser = new JButton("Actualiser");
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				txtIdChambre.setText("");
				txtNomChambre.setText("");
				txtNumChambre.setText("");
				txtSuperficie.setText("");
				txtTarrif.setText("");
				showTable();
			}
		});
		
		
		btnActualiser.setBounds(1059, 30, 174, 29);
		contentPane.add(btnActualiser);
//===========================================================================================		
		
		
		JLabel lblnomChambre = new JLabel("Nom de Chambre");
		lblnomChambre.setBounds(0, 101, 137, 20);
		contentPane.add(lblnomChambre);
		
		txtNomChambre = new JTextField();
		txtNomChambre.setBackground(SystemColor.text);
		txtNomChambre.setBounds(197, 98, 146, 26);
		contentPane.add(txtNomChambre);
		txtNomChambre.setColumns(10);
		
	
		
		JLabel lblSuperficie = new JLabel("Superficie");
		lblSuperficie.setBounds(0, 192, 69, 20);
		contentPane.add(lblSuperficie);

//====================================MODIFIER================================================
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String id_chambre	= txtIdChambre.getText();
				String id_categorie	= txtidCategorie.getText();
				String nomChambre 	= txtNomChambre.getText();
				String numChambre 	= txtNumChambre.getText();
				String tarif 		= txtTarrif.getText();
				String superficie 	= txtSuperficie.getText();
				String value		= comboBoxType.getSelectedItem().toString();
//===========================================================================================
		
				

String idCategorie ;
//====================================Validation de Modification=============================================
if(  nomChambre.trim().length()==0 && numChambre.trim().length()==0 &&   superficie.trim().length()==0 && tarif.trim().length()==0 && value.trim().length()==0 ){
		
					
					JOptionPane.showMessageDialog(null, "Remplissez les champs");

			}
			
				 else if(nomChambre.trim().length()==0) {
					
					 JOptionPane.showMessageDialog(null,"Remplissez le champs de nom dela Chambre");
					
				}else if(numChambre.trim().length()==0) {
				
					JOptionPane.showMessageDialog(null,"Remplissez le champs de numéro de chambre");
					
				 
				
				}else if(superficie.trim().length()==0) {
					
					
					JOptionPane.showMessageDialog(null,"Remplissez le champs de superficie");
					
				
				}else if(tarif.trim().length()==0) {
					
					
					JOptionPane.showMessageDialog(null,"Remplissez le champs de tarif");
					
				
				
				}else {
					
					try {
											
			
						
//=========================================Connexion pour la table Categorie============================================================================						
			
						
						Connection con = db.db_connect();
						
                        
                        PreparedStatement stmtCategorie = con.prepareStatement("UPDATE categorie SET tarif=?,type=? where id_categorie=?",Statement.RETURN_GENERATED_KEYS);      
                       
                        stmtCategorie.setString(2,value);
                        stmtCategorie.setString(1,tarif);
                        stmtCategorie.setString(3,id_categorie);
                        stmtCategorie.executeUpdate();
                        ResultSet rs =stmtCategorie.getGeneratedKeys();
                        
                        if(rs.next()) {
                        	
                             idCategorie= rs.getString(1);

                        
                        
                        
//==================================================Connection pour la table Chambre=======================================================================================================================================================================                        
						
                        PreparedStatement stmtChambre = con.prepareStatement("UPDATE chambre SET id_categorie=?,nomChambre=?,superficie=?,numChambre=? WHERE id_chambre=? ");
						stmtChambre.setString(1,id_categorie);
						stmtChambre.setString(2,nomChambre);
						stmtChambre.setString(3,superficie);
						stmtChambre.setString(4,numChambre);
						stmtChambre.setString(5,id_chambre);
						stmtChambre.executeUpdate();
                        }
                        
						JOptionPane.showMessageDialog(null,"Vos données ont été bien modifées");
						showTable();
				
					
						
						
					}catch(Exception Mo) {
						System.out.print(Mo);
					}
				}
				
				
				
			}
		});
		btnModifier.setBounds(233, 446, 122, 40);
		contentPane.add(btnModifier);
//======================================================================================================
		
		
		
		
		JLabel lblEnregistrer = new JLabel("Enregistrez-Vous!!");
		lblEnregistrer.setBounds(53, 16, 152, 20);
		contentPane.add(lblEnregistrer);
		
		
		JLabel lblRecherche = new JLabel("Recherche");
		lblRecherche.setBounds(487, 34, 96, 20);
		contentPane.add(lblRecherche);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(0, 290, 81, 20);
		contentPane.add(lblType);
		
		JLabel lblTarif = new JLabel("Tarif");
		lblTarif.setBounds(0, 342, 69, 20);
		contentPane.add(lblTarif);
		
//=====================================RECHERCHE=========================================================		
	 	this.comboBoxChambre =new JComboBox<String>();
		comboBoxChambre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
			Object selected =comboBoxChambre.getSelectedItem();
			if(selected.toString().equals("Nom de la Chambre"))
				filterCriteria= "nomChambre";
			
			if(selected.toString().equals("Numéro de Chambre"))
				filterCriteria= "numChambre";
			
			if(selected.toString().equals("Type de Chambre"))
				filterCriteria= "typeChambre";
			
			
			if(selected.toString().equals("Tarif"))
				filterCriteria= "tarif";
			
			if(selected.toString().equals("Superficie"))
				filterCriteria= "superficie";
			System.out.print(filterCriteria);
	
				
			}
		});
		
		comboBoxChambre.setModel(new DefaultComboBoxModel<String>(new String[]{" ","Nom de la Chambre","Numero de Chambre","Type de Chambre","Superficie","Tarif"}));
		comboBoxChambre.setBounds(846, 31, 165, 26);
		contentPane.add(comboBoxChambre);

txtSearchChambre = new JTextField();
txtSearchChambre.addKeyListener(new KeyAdapter() {
	@Override
	public void keyReleased(KeyEvent arg0) {
	 
	
		try {
			dbhotel db = new dbhotel();
			String searchObject=txtSearchChambre.getText();
			Connection con;
			con = db.db_connect();
			PreparedStatement stmtCh = con.prepareStatement("SELECT  id_chambre as '#', nomChambre as 'Nom de la Chambre' , numChambre as 'Numero de Chambre'" 
			+ "  superficie as 'Superficie'"+filterCriteria+" LIKE ? ");
			stmtCh.setString(1,  "%" +searchObject + "%");
			

			PreparedStatement stmtCa = con.prepareStatement("SELECT  id_categorie as '#', type as 'Type de Chambre'"
			+ " , tarif as 'Tarif'FROM categorie  "+filterCriteria+" LIKE ? ");
			stmtCa.setString(1,  "%" +searchObject + "%");
			
			
			ResultSet rsCh = stmtCh.executeQuery();
			ResultSet rsCa = stmtCa.executeQuery();
			
			
			
			
			tableChambre.setModel(DbUtils.resultSetToTableModel(rsCh));//link database data to table
			tableChambre.setModel(DbUtils.resultSetToTableModel(rsCa));//link database data to table
			
			
			
		}catch(Exception s) {
			
			System.out.print(s);
			
//			JOptionPane.showMessageDialog(null, "Veuillez d'abord seletionner les critères");
								
		}
	}
});

txtSearchChambre.setBounds(581, 31, 137, 26);
contentPane.add(txtSearchChambre);




//============================================FIN RECHERCHE===============================================================



		
		JScrollPane scrollPane = new JScrollPane();
		
		tableChambre = new JTable() {
			
			public boolean isCellEditable(int row,int column) {
				return false;
			}//cela permet de restrincte la partie d'editable....
		};
		
		
		
		
		tableChambre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			try {  
				
				int row = tableChambre.getSelectedRow();// nous permet de stocker des valeurs dans la variable row...
				
//				System.out.print(row);
				
				String Click = (tableChambre.getModel().getValueAt(row, 0).toString());
				
				System.out.print(Click);
				
				

				Connection con;
				con= db.db_connect();
				PreparedStatement stmt = con.prepareStatement(
						"SELECT * FROM chambre inner join categorie ON chambre.id_categorie = categorie.id_categorie WHERE id_chambre='"+Click+"' ");
				ResultSet rs = stmt.executeQuery();
				if(rs.next()) {
					
					
					
					String data1 = rs.getString("id_chambre");
					String data2 = rs.getString("nomChambre");
					String data3 = rs.getString("numChambre");
					String data4 = rs.getString("tarif");
					String data5 = rs.getString("type");
					String data6 = rs.getString("superficie");
//					System.out.print(data6);
 
					
					txtIdChambre.setText(data1);
					txtNomChambre.setText(data2);
					txtNumChambre.setText(data3);
					txtTarrif.setText(data4);
					comboBoxType.setSelectedItem(data5);
					txtSuperficie.setText(data6);
					 
					
					
					
				}
				
				
				
				
			}catch(Exception en) {
				
				System.out.print(en);
				JOptionPane.showMessageDialog(null, en);
				
			}	
				
				
				
			
				
			}// pour permettre de faire des actions sur ma table avec la souris
		});
		
		
		
		
		scrollPane.setBounds(466, 75, 809, 553);
		contentPane.add(scrollPane);
		
		
		
		
		
		scrollPane.setViewportView(tableChambre);
		tableChambre.setBackground(Color.WHITE);
		
		
		
		
		
		
		
		

		
		txtSuperficie = new JTextField();
		txtSuperficie.setBounds(197, 189, 146, 26);
		contentPane.add(txtSuperficie);
		txtSuperficie.setColumns(10);
		
		JLabel lblId = new JLabel("Ref");
		lblId.setBounds(0, 52, 69, 20);
		contentPane.add(lblId);
		
		txtIdChambre = new JTextField();
		txtIdChambre.setEditable(false);
		txtIdChambre.setColumns(10);
		txtIdChambre.setBounds(197, 49, 146, 26);
		contentPane.add(txtIdChambre);
		
		comboBoxType = new JComboBox();
		comboBoxType.addItem("Simple");
		comboBoxType.addItem("Double");
		comboBoxType.addItem("Double Confort");
		comboBoxType.addItem("Suite");
		comboBoxType.setBounds(197, 287, 146, 26);
		contentPane.add(comboBoxType);
		
		JLabel lblNumChambre = new JLabel("Num\u00E9ro de Chambre");
		lblNumChambre.setBounds(0, 149, 182, 20);
		contentPane.add(lblNumChambre);
		
		txtNumChambre = new JTextField();
		txtNumChambre.setColumns(10);
		txtNumChambre.setBounds(197, 147, 146, 26);
		contentPane.add(txtNumChambre);
		
		txtTarrif = new JTextField();
		txtTarrif.setColumns(10);
		txtTarrif.setBounds(197, 339, 146, 26);
		contentPane.add(txtTarrif);
		
		JLabel lblidCategorie = new JLabel("idCategorie");
		lblidCategorie.setBounds(0, 242, 182, 20);
		contentPane.add(lblidCategorie);
		
		txtidCategorie = new JTextField();
		txtidCategorie.setEditable(false);
		txtidCategorie.setColumns(10);
		txtidCategorie.setBounds(197, 239, 146, 26);
		contentPane.add(txtidCategorie);
		
		JLabel lblCritere = new JLabel("Crit\u00E8re");
		lblCritere.setBounds(762, 34, 69, 20);
		contentPane.add(lblCritere);
		
 

	
		
	}
	
	
	
	
	
	
	
	
	
	public static void showTable() {
		
		dbhotel db = new dbhotel();
		
		try {
			
			Connection con;
			con= db.db_connect();
			PreparedStatement chambreStmt = con.prepareStatement("SELECT id_chambre, nomChambre,superficie,numChambre,chambre.id_categorie,type,tarif FROM chambre inner join categorie ON chambre.id_categorie = categorie.id_categorie");
			ResultSet rs = chambreStmt.executeQuery();
			tableChambre.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e) {
			
			System.out.print(e);
		
		}
	
		
	
	}
}
