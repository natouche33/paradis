import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Gestion extends JFrame {

	private JPanel contentPane;
	public  String priviledge;
	public  String monnom;
	public  Component client;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestion frame = new Gestion("role","nom");
					frame.setVisible(true);
					
					
					
					
					

					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gestion(String priviledge,String monnom) {
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 581, 428);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGestion = new JLabel("Gestion MonParadis");
		lblGestion.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		lblGestion.setBounds(143, 11, 284, 40);
		contentPane.add(lblGestion);
		
		JButton btnRservation = new JButton("Reservation");
		btnRservation.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {	
		
			reservation res = new reservation(); 
			res.setVisible(true);
			
		
					
		
			}
		
		});
		
		btnRservation.setBounds(161, 55, 115, 29);
		
		
		JButton btnClient = new JButton("Client");
		btnClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client cli= new client();
				cli.showTable();
					cli.setVisible(true);
					
				
				
				
			}
		});
		btnClient.setBounds(161, 111, 115, 29);
		
		
		JButton btnUtilisateur = new JButton("Utilisateur");
		btnUtilisateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Utilisateur uti = new Utilisateur(); 
				uti.showTable();
				uti.setVisible(true);
					
			}
		});
		btnUtilisateur.setBounds(161, 156, 115, 29);
		
		
		JButton btnChambre = new JButton("Chambre");
		btnChambre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				chambre c = new chambre(); 
				c.showTable();
				c.setVisible(true);
						
				
			}
		});
		btnChambre.setBounds(161, 201, 115, 29);
		
		
		JButton btnDeconnexion = new JButton("Déconnexion");
		btnDeconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				reservation res = new reservation(); 
				Utilisateur uti= new Utilisateur();
				
				
			}
		});
		btnDeconnexion.setBounds(15, 242, 123, 29);
		
		
		JLabel lblUser = new JLabel("");
		lblUser.setBounds(467, 11, 69, 20);
		lblUser.setText(monnom);
		contentPane.add(lblUser);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Nathanielle\\Desktop\\veranda-grand-baie-hotel-spa--mauritius.jpg"));
		lblNewLabel.setBounds(10, 0, 555, 389);
		contentPane.add(lblNewLabel);
		
		System.out.println(priviledge);
		System.out.println(monnom);
		
		try { if(priviledge.contentEquals("administrateur")) {
			contentPane.add(btnRservation);
			contentPane.add(btnClient);
			contentPane.add(btnUtilisateur);
			contentPane.add(btnChambre);
			contentPane.add(btnDeconnexion);
			
			
			
		}else if(priviledge.contentEquals("utilisateur")) {
			contentPane.add(btnRservation);
			contentPane.add(btnClient);
			contentPane.add(btnChambre);
			contentPane.add(btnDeconnexion);
			
		}
		else {
			
			JOptionPane.showMessageDialog(null, "Il y a une erreur avec votre compte!!! S'il vous Plait Contactez votre Administrateur");
		}
			
		}catch(Exception e1) {
			System.out.println(e1);
		}
		
	}
	
	

    public void actionPerformed(ActionEvent ae) {
                    
                    String command = ((JButton) ae.getSource()).getActionCommand();
                    
                    if(command.equals("GESTION UTILISATEURS"))
   {
                    Utilisateur wel = new Utilisateur();
                       wel.setVisible(true);
                    
   }
                    
                     else if(command.equals("GESTION CHAMBRE"))
                    {             
                      client ret = new client();
                       ret.setVisible(true);
                    
                      
                     }
                    
                    
    }
}
