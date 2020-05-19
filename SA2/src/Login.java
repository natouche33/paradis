

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



public class Login extends JFrame implements ActionListener{
                
                private JPanel contentPane;

                /**
                * Launch the application.
                */
                public static void main(String[] args) {
                                EventQueue.invokeLater(new Runnable() {
                                                public void run() {
                                                                try {
                                                                                Login frame = new Login();
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
                public Login() {
                                setTitle("Mon Paradis Hotel_Administrateur");
                                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                setBounds(100, 100, 450, 300);
                                contentPane = new JPanel();
                                contentPane.setBackground(new Color(255, 160, 122));
                                contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                                setContentPane(contentPane);
                                contentPane.setLayout(null);
                                
                                JLabel lblNewLabel = new JLabel("Acceder aux interfaces ici.");
                                lblNewLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
                                lblNewLabel.setBounds(24, 23, 329, 14);
                                contentPane.add(lblNewLabel);
                                
                                JButton btnNewButton = new JButton("GESTION RESERVATION");
                                btnNewButton.setBackground(new Color(255, 127, 80));
                                btnNewButton.setBounds(32, 79, 180, 30);
                                contentPane.add(btnNewButton);
                                
                                JButton btnNewButton_1 = new JButton("GESTION CHAMBRE");
                                btnNewButton_1.setBackground(new Color(255, 127, 80));
                                btnNewButton_1.setBounds(244, 79, 180, 30);
                                contentPane.add(btnNewButton_1);
                                //roomcontentPane.showTable();
                                
                                
                                JButton btnNewButton_2 =new JButton("GESTION CLIENT");
                                btnNewButton_2.setBackground(new Color(255, 127, 80));
                                btnNewButton_2.setBounds(32, 167, 180, 30);
                                contentPane.add(btnNewButton_2);
                                
                                JButton btnNewButton_3 = new JButton("GESTION UTILISATEURS");
                                btnNewButton_3.setBackground(new Color(255, 127, 80));
                                btnNewButton_3.setBounds(244, 167, 180, 30);
                                contentPane.add(btnNewButton_3);
                                
                                btnNewButton.addActionListener(this);
                                btnNewButton_1.addActionListener(this);
                                btnNewButton_2.addActionListener(this);
                                btnNewButton_3.addActionListener(this);
                                
                                
                                
                }


                public void actionPerformed(ActionEvent ae) {
                                
                                String command = ((JButton) ae.getSource()).getActionCommand();
                                
                                if(command.equals("GESTION UTILISATEURS"))
               {
                                  Utilisateur wel = new Utilisateur();
                                   wel.setVisible(true);
                                
               }
                                
                                 else if(command.equals("GESTION Client"))
                                {             
                              client ret = new client();
                                   ret.setVisible(true);
                                
                                  
                                 }
                                
                                
                }
                
                
                
}              
