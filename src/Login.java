import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField Username;
	private JPasswordField Password;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 438, 266);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(76, 65, 80, 16);
		panel.add(lblUsername);
		
		JLabel lblAdminLogin = new JLabel("Admin Login");
		lblAdminLogin.setBounds(150, 19, 80, 16);
		panel.add(lblAdminLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(76, 126, 61, 16);
		panel.add(lblPassword);
		
		Username = new JTextField();
		Username.setBounds(150, 59, 134, 28);
		panel.add(Username);
		Username.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String usr=Username.getText();
					String pass= Password.getText();
					//JOptionPane.showMessageDialog(null, usr);
					//JOptionPane.showMessageDialog(null, pass);
					
					if(usr.equals("Sierra") && pass.equals("admin"))
					{
						JOptionPane.showMessageDialog(null, "Login Successful");
						Add_Movie am=new Add_Movie();
						am.setVisible(true);
					}
					else{
						JOptionPane.showMessageDialog(null, "Invalid Credentials");
					}
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
				
			}
		});
		btnLogin.setBounds(132, 189, 102, 29);
		panel.add(btnLogin);
		
		Password = new JPasswordField();
		Password.setBounds(150, 120, 134, 28);
		panel.add(Password);
	}
}
