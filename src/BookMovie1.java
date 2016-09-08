

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
//import javax.swing.JComboBox;
//import javax.swing.ComboBoxModel;
//import javax.swing.DefaultComboBoxModel;
//import java.awt.SystemColor;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;



public class BookMovie1 extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 5462223600l;
	public static JTextField textFieldseat;
	public static JTextField textFieldper;
	public static JTextField textFieldtotal;

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
		textFieldseat.setBounds(156, 228, 237, 28);
		contentPane.add(textFieldseat);
		textFieldseat.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Price Per Ticket");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(46, 284, 99, 28);
		contentPane.add(lblNewLabel);
		
		textFieldper = new JTextField();
		textFieldper.setBounds(159, 284, 237, 28);
		contentPane.add(textFieldper);
		textFieldper.setColumns(10);
		
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
					  price=Integer.parseInt(textFieldper.getText());
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
					textFieldper.setText("");
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
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Sultan", "Rustum", "Mohenjo daro"}));
		comboBox.setBounds(161, 59, 232, 27);
		contentPane.add(comboBox);
		
		JComboBox<String> comboBox_1 = new JComboBox<>();
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"First", "Second", "Third"}));
		comboBox_1.setBounds(161, 118, 232, 27);
		contentPane.add(comboBox_1);
		
		JComboBox<String> comboBox_2 = new JComboBox<>();
		comboBox_2.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3"}));
		comboBox_2.setBounds(161, 174, 232, 27);
		contentPane.add(comboBox_2);
		
		
	}
}
