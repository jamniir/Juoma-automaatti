import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JToolBar;
import java.awt.Label;

public class GUI_Automaatti extends JFrame {

	// Luokkamuuttujat
	// Esitell‰‰n t‰‰ll‰ jotta komponentteihin voidaan viitata mist‰ tahansa luokan
	// sis‰lt‰

	JPanel contentPane;
	private JMenuItem mntmTallennaAutomaatinTila;
	private JMenuItem mntmLataaAutomaatti;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmAsetaKahvinMr;
	private JMenuItem mntmAsetaTeenMr;
	private JMenuItem mntmAsetaKaakaonMr;
	private JMenuItem mntmTallennaAutomaatinTila_1;
	private JMenuItem mntmLataaAutomaatti_1;
	private JMenuItem mntmLopeta;
	private JMenuItem mntmVersiotiedot;
	private JMenuItem mntmOhje;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblKahvi;
	private JLabel lblTee;
	private JLabel lblKaakao;
	private JLabel lblKahvia;
	private JLabel lblTeet;
	private JLabel lblKaakaota;

	/**
	 * Main-metodi, joka k‰ynnist‰‰ sovelluksen
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Luodaan ensmin uusi JuomaAutomaatti-olio
					JuomaAutomaatti ja = new JuomaAutomaatti();

					// K‰yttˆliittym‰ saa parametrina olion, jonka tiedot se n‰ytt‰‰
					GUI_Automaatti frame = new GUI_Automaatti(ja);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Konstruktorissa rakennetaan k‰yttˆliittym‰. Huomaa, ett‰ otetaan parametrina
	 * vastaan alussa luotu juoma-automaatti. T‰m‰ siksi, ett‰ voidaan n‰ytt‰‰ sen
	 * tiedot GUI:ssa
	 */
	public GUI_Automaatti(JuomaAutomaatti ja) {

		// Ikkunan otsikko ja koko
		
		setTitle("Kahviautomaatti GUI v. 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 705);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Yll‰pito");
		menuBar.add(mnNewMenu);
		
		mntmAsetaKahvinMr = new JMenuItem("Aseta kahvin m\u00E4\u00E4r\u00E4");
		mntmAsetaKahvinMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Kahvin m‰‰r‰
				String uusiArvo = JOptionPane.showInputDialog(null, "Anna uusi arvo:");
				int uusiKahvi = Integer.parseInt(uusiArvo);
				ja.setKahvi(uusiKahvi);
				lblKahvia.setText("Kahvia: " + ja.getKahvi());
			}
		});
		mnNewMenu.add(mntmAsetaKahvinMr);
		
		mntmAsetaTeenMr = new JMenuItem("Aseta teen m\u00E4\u00E4r\u00E4");
		mntmAsetaTeenMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Teen m‰‰r‰
				String uusiArvo = JOptionPane.showInputDialog(null, "Anna uusi arvo:");
				int uusiTee = Integer.parseInt(uusiArvo);
				ja.setTee(uusiTee);
				lblTeet.setText("Teet‰: " + ja.getTee());
			}
		});
		mnNewMenu.add(mntmAsetaTeenMr);
		
		mntmAsetaKaakaonMr = new JMenuItem("Aseta kaakaon m\u00E4\u00E4r\u00E4");
		mntmAsetaKaakaonMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Kaakaon m‰‰r‰
				String uusiArvo = JOptionPane.showInputDialog(null, "Anna uusi arvo:");
				int uusiKaakao = Integer.parseInt(uusiArvo);
				ja.setKaakao(uusiKaakao);
				lblKaakaota.setText("Kaakaota: " + ja.getKaakao());
			}
		});
		mnNewMenu.add(mntmAsetaKaakaonMr);
		
		mntmTallennaAutomaatinTila_1 = new JMenuItem("Tallenna automaatin tila");
		mntmTallennaAutomaatinTila_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Sarjallistamista.kirjoitaTiedostoon(ja);
				} catch (Exception ef) {
					System.out.println("Tallennus ep‰onnistui.");
				}
			}
		});
		mnNewMenu.add(mntmTallennaAutomaatinTila_1);
		
		mntmLataaAutomaatti_1 = new JMenuItem("Lataa automaatti");
		mntmLataaAutomaatti_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JuomaAutomaatti uusi = Sarjallistamista.lueTiedostosta();
					lblKahvia.setText("Kahvia: " + uusi.getKaakao());
					lblTeet.setText("Teet‰: " + uusi.getTee());
					lblKaakaota.setText("Kaakaota: " + uusi.getKaakao());
				} catch (Exception eff){
					System.out.println("Lataus ep‰onnistui.");
				}
			}
		});
		mnNewMenu.add(mntmLataaAutomaatti_1);
		
		mntmLopeta = new JMenuItem("Lopeta");
		mntmLopeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmLopeta);
		
		mnNewMenu_1 = new JMenu("Tietoja ohjelmasta");
		menuBar.add(mnNewMenu_1);
		
		mntmVersiotiedot = new JMenuItem("Versiotiedot");
		mntmVersiotiedot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Versiotiedot versio = new Versiotiedot();
				versio.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmVersiotiedot);
		
		mntmOhje = new JMenuItem("Ohje");
		mnNewMenu_1.add(mntmOhje);

	 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Kahvi");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Jami\\Downloads\\KT3-Juoma_Automaatti-GUI-pohja-opiske(2)\\KT3-Juoma Automaatti-GUI-pohja-opiskelijat\\img\\coffee.jpg"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ja.valmistaKahvi();
				lblKahvia.setText("Kahvia: " + ja.getKahvi());
			}
		});
		btnNewButton.setBounds(35, 22, 123, 129);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Tee");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ja.valmistaTee();
				lblTeet.setText("Teet‰: " + ja.getTee());
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Jami\\Downloads\\KT3-Juoma_Automaatti-GUI-pohja-opiske(2)\\KT3-Juoma Automaatti-GUI-pohja-opiskelijat\\img\\tea.jpg"));
		btnNewButton_1.setBounds(35, 206, 123, 129);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Kaakao");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ja.valmistaKaakao();
				lblKaakaota.setText("Kaakaota: " + ja.getKaakao());
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Jami\\Downloads\\KT3-Juoma_Automaatti-GUI-pohja-opiske(2)\\KT3-Juoma Automaatti-GUI-pohja-opiskelijat\\img\\cocoa.jpg"));
		btnNewButton_2.setBounds(35, 392, 123, 129);
		contentPane.add(btnNewButton_2);
		
		lblKahvi = new JLabel("Kahvi");
		lblKahvi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblKahvi.setBounds(71, 162, 48, 14);
		contentPane.add(lblKahvi);
		
		lblTee = new JLabel("Tee");
		lblTee.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTee.setBounds(71, 346, 48, 14);
		contentPane.add(lblTee);
		
		lblKaakao = new JLabel("Kaakao");
		lblKaakao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblKaakao.setBounds(71, 532, 62, 14);
		contentPane.add(lblKaakao);
		
		lblKahvia = new JLabel("Kahvia: " + ja.getKahvi());
		lblKahvia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblKahvia.setBounds(216, 79, 90, 20);
		contentPane.add(lblKahvia);
		
		lblTeet = new JLabel("Teet\u00E4: " + ja.getTee());
		lblTeet.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTeet.setBounds(216, 263, 76, 20);
		contentPane.add(lblTeet);
		
		lblKaakaota = new JLabel("Kaakaota: " + ja.getKaakao());
		lblKaakaota.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblKaakaota.setBounds(216, 449, 101, 20);
		contentPane.add(lblKaakaota);
	}
}
