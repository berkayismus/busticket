import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class ForgotPassword extends JFrame {

	private JPanel contentPane;
	private JTextField tfEposta;
	private JPasswordField pfCevap;
	
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPassword frame = new ForgotPassword();
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
	public ForgotPassword() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\eclipse-workspace\\Bus\\images\\title32x32.png"));
		setTitle("\u015Eifremi Unuttum");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		
		contentPane.setLayout(null);
		
		JLabel lb1 = new JLabel("Eposta");
		lb1.setForeground(Color.WHITE);
		lb1.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		lb1.setBounds(45, 50, 76, 32);
		contentPane.add(lb1);
		
		JLabel lb2 = new JLabel("Gizli Soru");
		lb2.setForeground(Color.WHITE);
		lb2.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		lb2.setBounds(45, 90, 100, 29);
		contentPane.add(lb2);
		
		JLabel lb3 = new JLabel("Cevap");
		lb3.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		lb3.setForeground(Color.WHITE);
		lb3.setBounds(45, 130, 100, 32);
		contentPane.add(lb3);
		
		tfEposta = new JTextField();
		tfEposta.setFont(new Font("Arial", Font.PLAIN, 22));
		tfEposta.setBounds(150, 50, 190, 30);
		contentPane.add(tfEposta);
		tfEposta.setColumns(10);
		
		JComboBox cbSoru = new JComboBox();
		cbSoru.setFont(new Font("Arial", Font.PLAIN, 22));
		cbSoru.setModel(new DefaultComboBoxModel(new String[] {"Annenizin k\u0131zl\u0131k soyad\u0131 nedir?", "\u0130lk evcil hayvan\u0131n\u0131z\u0131n ad\u0131 nedir?", "\u0130lk arac\u0131n\u0131z\u0131n modeli nedir?", "Hangi \u015Fehirde do\u011Fdunuz?", "Baban\u0131z\u0131n ortanca ismi nedir?", "\u00C7ocukluk lakab\u0131n\u0131z nedir?"}));
		cbSoru.setBounds(150, 90, 190, 30);
		contentPane.add(cbSoru);
		
		pfCevap = new JPasswordField();
		pfCevap.setBounds(150, 130, 190, 30);
		contentPane.add(pfCevap);
		// ikon oluþturma
		Image img = new ImageIcon(this.getClass().getResource("/login32x32.png")).getImage();
		// ikon oluþturma
		Image img2 = new ImageIcon(this.getClass().getResource("/register32x32.png")).getImage();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 140, 0));
		panel.setBounds(0, 0, 404, 306);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnGiris = new JButton("Giri\u015F");
		btnGiris.setBounds(211, 225, 130, 50);
		panel.add(btnGiris);
		btnGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserLogin ul = new UserLogin();
				ul.setLocationRelativeTo(null);
				dispose();
				ul.setVisible(true);
			}
		});
		btnGiris.setFont(new Font("Arial", Font.PLAIN, 22));
		btnGiris.setIcon(new ImageIcon(img));
		
		JButton btnKayit = new JButton("Kay\u0131t");
		btnKayit.setBounds(71, 226, 130, 50);
		panel.add(btnKayit);
		btnKayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewUser nu = new NewUser();
				nu.setLocationRelativeTo(null);
				dispose();
				nu.setVisible(true);
			}
		});
		btnKayit.setFont(new Font("Arial", Font.PLAIN, 22));
		btnKayit.setIcon(new ImageIcon(img2));
		
		
		JButton btnParola = new JButton("Parolam\u0131 iste");
		btnParola.setBounds(71, 171, 270, 50);
		panel.add(btnParola);
		btnParola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String eposta = tfEposta.getText();
				String gizlisoru = cbSoru.getSelectedItem().toString();
				String cevap = String.valueOf(pfCevap.getPassword());
				String mesaj = "";
				if(eposta.isEmpty() || gizlisoru.isEmpty() || cevap.isEmpty()) mesaj = "Alanlar boþ geçilemez";
				else {
					mesaj = sifremiUnuttum(eposta,gizlisoru,cevap);
				}
				JOptionPane.showMessageDialog(null, mesaj);
			}
		});
		btnParola.setFont(new Font("Arial", Font.PLAIN, 22));
	}
	
	public String sifremiUnuttum(String eposta,String gizlisoru,String cevap) {
		String mesaj = "";
		ResultSet rs = null;
		try {
			UserFunctions uf = new UserFunctions();
			String sorgu = "select * from user where email=? and question=? and answer=?";
			uf.ps = uf.con.prepareStatement(sorgu);
			uf.ps.setString(1, eposta);
			uf.ps.setString(2, gizlisoru);
			uf.ps.setString(3, cevap);
			rs = uf.ps.executeQuery();
			if(rs.next()) {
				mesaj = "Kullanýcý adýnýz: "+rs.getString("username")+" \nParolanýz: "+rs.getString("password");
			}
			else {
				mesaj = "Kullanýcý bulunamadý";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("sifremiunuttum hatasý");
		}
		return mesaj;
		 
	}
}
