import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Image;
import java.text.ParseException;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class NewUser extends JFrame {

	private JPanel contentPane;
	private JTextField tfAd;
	private JTextField tfKullanici;
	private JPasswordField pf;
	private JPasswordField pfTekrar;
	private JTextField tfEposta;
	private JTextField tfCevap;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUser frame = new NewUser();
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
	public NewUser() {
		setTitle("\u00DCye Kay\u0131t");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255,140,0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_uye_kayit = new JLabel("\u00DCYE KAYIT");
		lbl_uye_kayit.setForeground(Color.WHITE);
		lbl_uye_kayit.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
		lbl_uye_kayit.setBounds(252, 30, 209, 30);
		contentPane.add(lbl_uye_kayit);
		
		JLabel lbl_uye_kayit_adsoyad = new JLabel("Ad Soyad");
		lbl_uye_kayit_adsoyad.setForeground(Color.WHITE);
		lbl_uye_kayit_adsoyad.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lbl_uye_kayit_adsoyad.setBounds(181, 90, 104, 14);
		contentPane.add(lbl_uye_kayit_adsoyad);
		
		JLabel lbl_uye_kayit_telefon = new JLabel("K.Ad\u0131");
		lbl_uye_kayit_telefon.setForeground(Color.WHITE);
		lbl_uye_kayit_telefon.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lbl_uye_kayit_telefon.setBounds(181, 120, 104, 14);
		contentPane.add(lbl_uye_kayit_telefon);
		
		JLabel lblParola = new JLabel("Parola");
		lblParola.setForeground(Color.WHITE);
		lblParola.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblParola.setBounds(181, 150, 104, 14);
		contentPane.add(lblParola);
		
		JLabel lblParolaTekrar = new JLabel("P.Tekrar");
		lblParolaTekrar.setForeground(Color.WHITE);
		lblParolaTekrar.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblParolaTekrar.setBounds(181, 180, 104, 14);
		contentPane.add(lblParolaTekrar);
		
		tfAd = new JTextField();
		tfAd.setBounds(311, 90, 170, 20);
		contentPane.add(tfAd);
		tfAd.setColumns(10);
		
		tfKullanici = new JTextField();
		tfKullanici.setBounds(311, 120, 170, 20);
		contentPane.add(tfKullanici);
		tfKullanici.setColumns(10);
		
		pf = new JPasswordField();
		pf.setBounds(311, 150, 170, 20);
		contentPane.add(pf);
		
		pfTekrar = new JPasswordField();
		pfTekrar.setBounds(311, 180, 170, 20);
		contentPane.add(pfTekrar);
		

		

		
		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setForeground(Color.WHITE);
		lblTelefon.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblTelefon.setBounds(181, 210, 150, 14);
		contentPane.add(lblTelefon);
		
		JLabel lblEposta = new JLabel("E-posta");
		lblEposta.setForeground(Color.WHITE);
		lblEposta.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblEposta.setBounds(181, 240, 150, 14);
		contentPane.add(lblEposta);
		
		tfEposta = new JTextField();
		tfEposta.setColumns(10);
		tfEposta.setBounds(311, 240, 170, 20);
		contentPane.add(tfEposta);
		
		tfCevap = new JTextField();
		tfCevap.setColumns(10);
		tfCevap.setBounds(311, 300, 170, 20);
		contentPane.add(tfCevap);
		
		JLabel lblGizliSoru = new JLabel("Gizli Soru");
		lblGizliSoru.setForeground(Color.WHITE);
		lblGizliSoru.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblGizliSoru.setBounds(181, 270, 104, 14);
		contentPane.add(lblGizliSoru);
		
		JLabel lblCevap = new JLabel("Cevap");
		lblCevap.setForeground(Color.WHITE);
		lblCevap.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblCevap.setBounds(181, 300, 104, 14);
		contentPane.add(lblCevap);
		
		// Formatted texti (telefonu) formatlýyorum
		
		MaskFormatter mf = null;
		try {
			mf = new MaskFormatter("(0###) - ### - ## - ##");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JFormattedTextField tfTelefon = new JFormattedTextField(mf);
		tfTelefon.setBounds(311, 210, 170, 20);
		contentPane.add(tfTelefon); 
		
		JComboBox cbGizliSoru = new JComboBox();
		cbGizliSoru.setModel(new DefaultComboBoxModel(new String[] {"Annenizin k\u0131zl\u0131k soyad\u0131 nedir?", "\u0130lk evcil hayvan\u0131n\u0131z\u0131n ad\u0131 nedir?", "\u0130lk arac\u0131n\u0131z\u0131n modeli nedir?", "Hangi \u015Fehirde do\u011Fdunuz?", "Baban\u0131z\u0131n ortanca ismi nedir?", "\u00C7ocukluk lakab\u0131n\u0131z nedir?"}));
		cbGizliSoru.setBounds(311, 270, 170, 20);
		contentPane.add(cbGizliSoru);
		

		
		JLabel labelMesaj = new JLabel("");
		labelMesaj.setHorizontalAlignment(SwingConstants.CENTER);
		labelMesaj.setForeground(Color.ORANGE);
		labelMesaj.setFont(new Font("Tahoma", Font.PLAIN, 24));
		labelMesaj.setBounds(191, 388, 300, 38);
		contentPane.add(labelMesaj);
		

		
		JButton btnKayit = new JButton("Kay\u0131t");
		btnKayit.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		Image imgbutton3 = new ImageIcon(this.getClass().getResource("/Add-icon.png")).getImage();
		btnKayit.setIcon(new ImageIcon(imgbutton3));
		btnKayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name,username,password,phone,email,question,answer;
				
				name = tfAd.getText();
				username = tfKullanici.getText();
				password = new String(pf.getPassword());
				String passwordTekrar = new String(pfTekrar.getPassword());
				phone = tfTelefon.getText();
				email = tfEposta.getText();
				question = cbGizliSoru.getSelectedItem().toString();
				answer = tfCevap.getText();	
				
				Baglanti baglanti = new Baglanti();
				if(password.equals(passwordTekrar) && !name.isEmpty() && !username.isEmpty() && !password.isEmpty() && !passwordTekrar.isEmpty() && !phone.isEmpty() && !email.isEmpty() && !answer.isEmpty())
				baglanti.KullaniciEkle(name, username, password, phone, email, question, answer);
				if(!password.equals(passwordTekrar))
				labelMesaj.setText("Þifreler uyuþmuyor!");
				
				else {
					labelMesaj.setText("Kullanýcý baþarýyla eklendi!");
					UserLogin ul = new UserLogin();
					ul.setLocationRelativeTo(null);
					dispose();
					ul.setVisible(true);
				}

				
			}
		});
		btnKayit.setBounds(181, 330, 128, 30);
		contentPane.add(btnKayit);
		
		JButton btnGiris = new JButton("Giri\u015F");
		btnGiris.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		Image imgbutton5 = new ImageIcon(this.getClass().getResource("/login32x32.png")).getImage();
		btnGiris.setIcon(new ImageIcon(imgbutton5));
		btnGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserLogin ul = new UserLogin();
				ul.setLocationRelativeTo(null);
				dispose();
				ul.setVisible(true);
			}
		});
		btnGiris.setBounds(311, 330, 128, 30);
		contentPane.add(btnGiris);
		
		JButton btnTemizle = new JButton("Temizle");
		btnTemizle.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		Image imgbutton4 = new ImageIcon(this.getClass().getResource("/delete icon.png")).getImage();
		btnTemizle.setIcon(new ImageIcon(imgbutton4));
		btnTemizle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tfAd.setText("");
				tfKullanici.setText("");
				pf.setText("");
				pfTekrar.setText("");
				tfTelefon.setText("");
				tfEposta.setText("");
				tfCevap.setText("");
				labelMesaj.setText("Alanlar temizlendi!");
			}
		});
		btnTemizle.setBounds(442, 330, 128, 30);
		contentPane.add(btnTemizle);
		
	}
}
