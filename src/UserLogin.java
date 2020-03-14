import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;

public class UserLogin extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsername;
	private JPasswordField pfPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin frame = new UserLogin();
					frame.setLocationRelativeTo(null);
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
	public UserLogin() {
		setTitle("Kullan\u0131c\u0131 Giri\u015Fi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pfPassword = new JPasswordField();
		pfPassword.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		pfPassword.setBounds(211, 130, 164, 30);
		contentPane.add(pfPassword);
		
		tfUsername = new JTextField();
		tfUsername.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		tfUsername.setBounds(211, 94, 164, 30);
		contentPane.add(tfUsername);
		tfUsername.setColumns(10);
		
		JLabel lbl_kullanici_giris_ad = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lbl_kullanici_giris_ad.setForeground(Color.WHITE);
		lbl_kullanici_giris_ad.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		lbl_kullanici_giris_ad.setBounds(60, 94, 164, 30);
		contentPane.add(lbl_kullanici_giris_ad);
		
		JLabel lbl_kullanici_giris_parola = new JLabel("Parola");
		lbl_kullanici_giris_parola.setForeground(Color.WHITE);
		lbl_kullanici_giris_parola.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		lbl_kullanici_giris_parola.setBounds(60, 130, 166, 30);
		contentPane.add(lbl_kullanici_giris_parola);
		// ikon oluþturma
		Image img = new ImageIcon(this.getClass().getResource("/batan32x32.png")).getImage();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255,140,0));
		panel.setBounds(0, 0, 561, 309);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnifremiUnuttum = new JButton("\u015Eifremi Unuttum");
		// ikon oluþturma
		Image img6 = new ImageIcon(this.getClass().getResource("/forgot32x32.png")).getImage();
		btnifremiUnuttum.setIcon(new ImageIcon(img6));
		btnifremiUnuttum.setBounds(60, 210, 445, 45);
		panel.add(btnifremiUnuttum);
		btnifremiUnuttum.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		

		

		
		JButton btnTemizle = new JButton("Temizle");
		btnTemizle.setBounds(360, 165, 145, 40);
		// ikon oluþturma
		Image img4 = new ImageIcon(this.getClass().getResource("/delete32x32.png")).getImage();
		btnTemizle.setIcon(new ImageIcon(img4));
		panel.add(btnTemizle);
		btnTemizle.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		

		
		JButton btnGiris = new JButton("Giri\u015F");
		btnGiris.setBounds(60, 165, 145, 40);
		// ikon oluþturma
		Image img2 = new ImageIcon(this.getClass().getResource("/login32x32.png")).getImage();
		btnGiris.setIcon(new ImageIcon(img2));
		panel.add(btnGiris);
		btnGiris.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		
		JButton btnKayit = new JButton("Kay\u0131t");
		btnKayit.setBounds(210, 165, 145, 40);
		// ikon oluþturma
		Image img3 = new ImageIcon(this.getClass().getResource("/register32x32.png")).getImage();
		btnKayit.setIcon(new ImageIcon(img3));
		panel.add(btnKayit);
		btnKayit.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		
		JLabel labelLogo = new JLabel("Batan Turizm");
		labelLogo.setBounds(130, 42, 296, 40);
		panel.add(labelLogo);
		labelLogo.setHorizontalAlignment(SwingConstants.CENTER);
		labelLogo.setForeground(Color.WHITE);
		labelLogo.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		labelLogo.setIcon(new ImageIcon(img));
		btnKayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				NewUser nu = new NewUser();
				dispose();
				nu.setLocationRelativeTo(null);
				nu.setVisible(true);
			}
		});
		btnGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mesaj="";
				String username = tfUsername.getText().trim();
				String password = new String(pfPassword.getPassword()).trim();
				Baglanti baglanti = new Baglanti();
				
				boolean result = baglanti.login(username, password);
				int stat = baglanti.statControl(username);
				if(result && stat==0) { // stat==0 --> Kullanýcý ise
					UserPanel up = new UserPanel();
					dispose();
					up.setLocationRelativeTo(null);
					up.setVisible(true);
				}
				else if(result && stat==1) { // stat==1 --> Admin ise
					AdminPanel ap = new AdminPanel();
					dispose();
					ap.setLocationRelativeTo(null);
					ap.setVisible(true);
					} 
				
				else if(result && stat==2) { // stat==2 --> Guest ise
					GuestPanel gp = new GuestPanel();
					dispose();
					gp.setLocationRelativeTo(null);
					gp.setVisible(true);
				}
				else if(username.isEmpty() || password.isEmpty()) {
					mesaj = "Alanlar boþ býrakýlamaz";
					JOptionPane.showMessageDialog(null, mesaj);
				}
				else {
					mesaj = "Giriþ yapýlamadý";
					JOptionPane.showMessageDialog(null, mesaj);
				} 
				
			}
		});
		btnTemizle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mesaj = "Alanlar temizlendi";
				tfUsername.setText("");
				pfPassword.setText("");
				JOptionPane.showMessageDialog(null, mesaj);
				
				
				
			}
		});
		btnifremiUnuttum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ForgotPassword fp = new ForgotPassword();
				fp.setLocationRelativeTo(null);
				dispose();
				fp.setVisible(true);
			}
		});
		


	}
}
