import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;





public class TicketGeneration extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 5462223600l;
	private JTextField txtTicketGenerator;
	private JTextField textFieldmovsel;
	private JLabel lbltimesel;
	private JTextField textFieldtime;
	private JLabel lblscreenno;
	private JTextField textFieldscreen;
	private JLabel lblseatbook;
	private JTextField textFieldseat;
	private JLabel lbltotalcost;
	private JTextField textFieldtotalcost;
	private JButton btnPrint;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicketGeneration frame = new TicketGeneration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void fillTextBox(){
		try{
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Movie_Ticket","root","");
			String query="Select * from Booked_Tickets order by id DESC limit 1;";
			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			
			while(rs.next()){
				textFieldmovsel.setText(rs.getString("Movie_Name"));
				textFieldtime.setText(rs.getString("Timings"));
				textFieldscreen.setText(rs.getString("Screen_No"));
				textFieldseat.setText(rs.getString("No_of_Seats"));
				textFieldtotalcost.setText(rs.getString("Total_Price"));
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
	public TicketGeneration() {
		setFont(new Font("Times New Roman", Font.PLAIN, 13));
		setTitle("Ticket Generation");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTicketGenerator = new JTextField();
		txtTicketGenerator.setEditable(false);
		txtTicketGenerator.setBorder(null);
		txtTicketGenerator.setText("TICKET GENERATOR");
		txtTicketGenerator.setHorizontalAlignment(SwingConstants.CENTER);
		txtTicketGenerator.setFont(new Font("Times New Roman", Font.BOLD, 25));
		txtTicketGenerator.setBackground(SystemColor.window);
		txtTicketGenerator.setBounds(60, 28, 314, 94);
		contentPane.add(txtTicketGenerator);
		txtTicketGenerator.setColumns(10);
		
		JLabel lblmov = new JLabel("Movie Selected");
		lblmov.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblmov.setBounds(34, 133, 116, 28);
		contentPane.add(lblmov);
		
		textFieldmovsel = new JTextField();
		textFieldmovsel.setEditable(false);
		
		textFieldmovsel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textFieldmovsel.setBounds(166, 133, 238, 28);
		contentPane.add(textFieldmovsel);
		textFieldmovsel.setColumns(10);
		
		lbltimesel = new JLabel("Timings Selected");
		lbltimesel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbltimesel.setBounds(34, 183, 116, 28);
		contentPane.add(lbltimesel);
		
		textFieldtime = new JTextField();
		textFieldtime.setEditable(false);
		textFieldtime.setBounds(166, 183, 238, 28);
		contentPane.add(textFieldtime);
		textFieldtime.setColumns(10);
		
		lblscreenno = new JLabel("Screen Number");
		lblscreenno.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblscreenno.setBounds(34, 233, 116, 28);
		contentPane.add(lblscreenno);
		
		textFieldscreen = new JTextField();
		textFieldscreen.setEditable(false);
		textFieldscreen.setBounds(166, 233, 238, 28);
		contentPane.add(textFieldscreen);
		textFieldscreen.setColumns(10);
		
		lblseatbook = new JLabel("No of Seat Booked");
		lblseatbook.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblseatbook.setBounds(34, 283, 116, 28);
		contentPane.add(lblseatbook);
		
		textFieldseat = new JTextField();
		textFieldseat.setEditable(false);
		textFieldseat.setBounds(166, 283, 238, 28);
		contentPane.add(textFieldseat);
		textFieldseat.setColumns(10);
		
		lbltotalcost = new JLabel("Total Cost");
		lbltotalcost.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbltotalcost.setBounds(34, 333, 116, 28);
		contentPane.add(lbltotalcost);
		
		textFieldtotalcost = new JTextField();
		textFieldtotalcost.setEditable(false);
		
		textFieldtotalcost.setBounds(166, 333, 238, 28);
		contentPane.add(textFieldtotalcost);
		textFieldtotalcost.setColumns(10);
		
		fillTextBox();
		
		btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					JOptionPane.showMessageDialog(null, "Ticket Generated");
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		btnPrint.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnPrint.setBounds(315, 378, 89, 28);
		contentPane.add(btnPrint);
	}
}
