import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class Versiotiedot extends JFrame {

	private JPanel contentPane;
	private JLabel lblJuomaautomaattiV;
	private JLabel lblTekijJn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Versiotiedot frame = new Versiotiedot();
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
	public Versiotiedot() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Juoma-automaatti GUI v. 1.0");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		lblJuomaautomaattiV = new JLabel("JUOMA-AUTOMAATTI V. 1.0");
		lblJuomaautomaattiV.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblJuomaautomaattiV, BorderLayout.CENTER);
		
		lblTekijJn = new JLabel("TEKIJ\u00C4: JN");
		lblTekijJn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblTekijJn, BorderLayout.SOUTH);
	}

}
