import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class Add_Movie extends JFrame {
	private JTextField Movie_Name;
	private JTextField Screen_No;
	private JTextField Price;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Movie frame = new Add_Movie();
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
	public Add_Movie() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 438, 266);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblMovieName = new JLabel("Movie Name");
		lblMovieName.setBounds(46, 49, 77, 16);
		panel.add(lblMovieName);
		
		Movie_Name = new JTextField();
		Movie_Name.setBounds(139, 43, 134, 28);
		panel.add(Movie_Name);
		Movie_Name.setColumns(10);
		
		JLabel lblScreenNo = new JLabel("Screen No");
		lblScreenNo.setBounds(46, 105, 77, 16);
		panel.add(lblScreenNo);
		
		Screen_No = new JTextField();
		Screen_No.setBounds(139, 99, 134, 28);
		panel.add(Screen_No);
		Screen_No.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price ");
		lblPrice.setBounds(47, 160, 61, 16);
		panel.add(lblPrice);
		
		Price = new JTextField();
		Price.setBounds(139, 154, 134, 28);
		panel.add(Price);
		Price.setColumns(10);
		
		JButton btnAdd = new JButton("ADD ");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String Name= Movie_Name.getText();
					String Screen= Screen_No.getText();
					String Price_Per_Ticket= Price.getText();
					
					Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Movie_Ticket","root","");
					String query="update Movie set Movie_Name=?, Movie_Price=?, Screen_Id=? where Screen_Id=?";
					PreparedStatement pst=(PreparedStatement) conn.prepareStatement(query);
					pst.setString(1, Name);
					pst.setString(2, Price_Per_Ticket);
					pst.setString(3, Screen);
					pst.setString(4, Screen);
					pst.execute();
					
					String query1="update Screen set First=100, Second=100,Third=100 where Screen_Id=?";
					PreparedStatement pst1=(PreparedStatement) conn.prepareStatement(query1);
					pst1.setString(1, Screen);
					pst1.execute();
					JOptionPane.showMessageDialog(null,"Movie Added");
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
				
			}
		});
		btnAdd.setBounds(168, 219, 77, 28);
		panel.add(btnAdd);
	}
}
