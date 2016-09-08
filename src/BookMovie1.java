

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;


import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;
//import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
//import javax.swing.JComboBox;
//import javax.swing.ComboBoxModel;
//import javax.swing.DefaultComboBoxModel;
//import java.awt.SystemColor;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
import java.sql.*;



public class BookMovie1 extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 5462223600l;
	public static JTextField textFieldseat;
	public static JTextField textfieldPer;
	public static JTextField textFieldtotal;
	private JComboBox<String> Movie_name;
	public static JTextField textFieldScreen;
	private JComboBox<String> Movie_Timing;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookMovie1 frame = new BookMovie1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void fillComboBox(){
		try{
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Movie_Ticket","root","");
			String query="Select Movie_Name from Movie;";
			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			
			while(rs.next()){
				Movie_name.addItem(rs.getString("Movie_Name"));
				//Screen_no.addItem(rs.getString("Screen_Id"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public BookMovie1() {
		setTitle("Book Movie");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblselmov = new JLabel("Select Movie");
		lblselmov.setBackground(Color.LIGHT_GRAY);
		lblselmov.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblselmov.setBounds(50, 59, 99, 28);
		contentPane.add(lblselmov);
		
		JLabel lbltime = new JLabel("Timings");
		lbltime.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbltime.setBounds(50, 116, 99, 28);
		contentPane.add(lbltime);
		
		JLabel lblseat = new JLabel("No of Seats");
		lblseat.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblseat.setBounds(55, 228, 99, 28);
		contentPane.add(lblseat);
		
		textFieldseat = new JTextField();
		textFieldseat.setBounds(159, 228, 237, 28);
		contentPane.add(textFieldseat);
		textFieldseat.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Price Per Ticket");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(46, 284, 99, 28);
		contentPane.add(lblNewLabel);
		
		textfieldPer = new JTextField();
		textfieldPer.setEditable(false);
		textfieldPer.setBounds(159, 284, 237, 28);
		contentPane.add(textfieldPer);
		textfieldPer.setColumns(10);
		
		JLabel lbltotal = new JLabel("Total Price");
		lbltotal.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbltotal.setBounds(49, 340, 99, 28);
		contentPane.add(lbltotal);
		
		textFieldtotal = new JTextField();
		textFieldtotal.setEditable(false);
		textFieldtotal.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				try {
						
					int seat,price,total;
					
					  seat=Integer.parseInt(textFieldseat.getText());
					  price=Integer.parseInt(textfieldPer.getText());
					  total=seat*price;
					  textFieldtotal.setText(Integer.toString(total));
				
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, "Please Enter The Information");
				}
			}
		});
		textFieldtotal.setBounds(159, 340, 237, 28);
		contentPane.add(textFieldtotal);
		textFieldtotal.setColumns(10);
		
		JButton btnProcced = new JButton("Procced");
		btnProcced.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					
					Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Movie_Ticket","root","");
					String query="insert into Booked_Tickets(Movie_Name,Timings, Screen_No,No_of_Seats, Total_Price) Values(?,?,?,?,?)";
					PreparedStatement pst= (PreparedStatement) conn.prepareStatement(query);
					//Statement stmt = conn.createStatement();
					pst.setString(1, (String) Movie_name.getSelectedItem());
					pst.setString(2, (String) Movie_Timing.getSelectedItem());
					pst.setString(3, (String) textFieldScreen.getText());
					pst.setString(4, (String) textFieldseat.getText());
					pst.setString(5, (String) textFieldtotal.getText());
					pst.execute();
					
					TicketGeneration tg=new TicketGeneration();
					tg.setVisible(true);
				}catch(Exception e){
					JOptionPane.showMessageDialog(null,"Fill The Information");
				}
				
			}
		});
		btnProcced.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnProcced.setBounds(159, 396, 89, 28);
		contentPane.add(btnProcced);
		
		JButton btncancel = new JButton("Cancel");
		btncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int p=JOptionPane.showConfirmDialog(null, "Do you really want to Cancel?","Cancel",JOptionPane.YES_NO_OPTION);
				if(p==0){
					JOptionPane.showMessageDialog(null, "Deleted");
					textFieldseat.setText("");
					textfieldPer.setText("");
					textFieldtotal.setText("");
					
				}
				
			}
		});
		btncancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btncancel.setBounds(283, 396, 89, 28);
		contentPane.add(btncancel);
		
		JLabel lblscreenno = new JLabel("Screen Number");
		lblscreenno.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblscreenno.setBounds(49, 172, 99, 28);
		contentPane.add(lblscreenno);
		
		Movie_name = new JComboBox<>();
		Movie_name.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Movie_Ticket","root","");
					String query="Select * from Movie where Movie_Name=?";
					//Statement stmt = conn.createStatement();
					PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
					pst.setString(1, (String) Movie_name.getSelectedItem());
					//pst.setInt(1, 3);
					//Statement stmt = conn.createStatement();
					ResultSet rs= pst.executeQuery();
					
					while(rs.next())
					{
						textFieldScreen.setText(rs.getString("Screen_Id"));
						textfieldPer.setText(rs.getString("Movie_Price"));
						
					}
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		Movie_name.setBounds(161, 59, 232, 27);
		contentPane.add(Movie_name);
		
		textFieldScreen = new JTextField();
		textFieldScreen.setEditable(false);
		textFieldScreen.setBounds(159, 172, 237, 28);
		contentPane.add(textFieldScreen);
		textFieldScreen.setColumns(10);
		
		fillComboBox();
		
		Movie_Timing = new JComboBox<>();
		Movie_Timing.setModel(new DefaultComboBoxModel<String>(new String[] {"First", "Second", "Third"}));
		Movie_Timing.setBounds(161, 118, 232, 27);
		contentPane.add(Movie_Timing);
		
		
		
		
	}
}
