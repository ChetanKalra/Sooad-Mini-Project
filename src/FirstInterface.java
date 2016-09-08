import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;


public class FirstInterface {
	
	
	private JFrame frame1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstInterface window = new FirstInterface();
					window.frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	/**
	 * Create the application.
	 */
	public FirstInterface()  {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame1 = new JFrame();
		frame1.setTitle("Options");
		frame1.getContentPane().setBackground(SystemColor.window);
		frame1.setBounds(100, 100, 400, 450);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		
		JButton btnaddmov = new JButton("Add Movie");
		btnaddmov.setBackground(Color.WHITE);
		btnaddmov.setForeground(Color.BLACK);
		btnaddmov.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnaddmov.setBounds(140, 133, 141, 63);
		frame1.getContentPane().add(btnaddmov);
		
		JButton btnbookmov = new JButton("Book Movie");
		btnbookmov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookMovie1 bm=new BookMovie1();
				bm.setVisible(true);
			}
		});
		btnbookmov.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnbookmov.setBackground(Color.WHITE);
		btnbookmov.setBounds(140, 221, 141, 63);
		frame1.getContentPane().add(btnbookmov);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "OPTIONS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel.setBounds(88, 82, 246, 266);
		frame1.getContentPane().add(panel);
	}

}
