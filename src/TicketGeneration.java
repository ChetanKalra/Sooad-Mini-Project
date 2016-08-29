import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JButton;





public class TicketGeneration extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 5462223600l;
	private JTextField txtTicketGenerator;
	private JTextField textFiedmovsel;
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
		
		textFiedmovsel = new JTextField();
		
		textFiedmovsel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textFiedmovsel.setBounds(166, 133, 238, 28);
		contentPane.add(textFiedmovsel);
		textFiedmovsel.setColumns(10);
		
		lbltimesel = new JLabel("Timings Selected");
		lbltimesel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbltimesel.setBounds(34, 183, 116, 28);
		contentPane.add(lbltimesel);
		
		textFieldtime = new JTextField();
		textFieldtime.setBounds(166, 183, 238, 28);
		contentPane.add(textFieldtime);
		textFieldtime.setColumns(10);
		
		lblscreenno = new JLabel("Screen Number");
		lblscreenno.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblscreenno.setBounds(34, 233, 116, 28);
		contentPane.add(lblscreenno);
		
		textFieldscreen = new JTextField();
		textFieldscreen.setBounds(166, 233, 238, 28);
		contentPane.add(textFieldscreen);
		textFieldscreen.setColumns(10);
		
		lblseatbook = new JLabel("No of Seat Booked");
		lblseatbook.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblseatbook.setBounds(34, 283, 116, 28);
		contentPane.add(lblseatbook);
		
		textFieldseat = new JTextField();
		textFieldseat.setBounds(166, 283, 238, 28);
		contentPane.add(textFieldseat);
		textFieldseat.setColumns(10);
		
		lbltotalcost = new JLabel("Total Cost");
		lbltotalcost.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbltotalcost.setBounds(34, 333, 116, 28);
		contentPane.add(lbltotalcost);
		
		textFieldtotalcost = new JTextField();
		
		textFieldtotalcost.setBounds(166, 333, 238, 28);
		contentPane.add(textFieldtotalcost);
		textFieldtotalcost.setColumns(10);
		
		btnPrint = new JButton("Print");
		btnPrint.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnPrint.setBounds(315, 378, 89, 28);
		contentPane.add(btnPrint);
	}
}
