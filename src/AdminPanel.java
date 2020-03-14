import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

public class AdminPanel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel frame = new AdminPanel();
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
	public AdminPanel() {
		setTitle("Admin Paneli");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Image imgbutton = new ImageIcon(this.getClass().getResource("/butonicon.png")).getImage();
		Image imgLabel = new ImageIcon(this.getClass().getResource("/ýcon1.png")).getImage();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 140, 0));
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 0, 449, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_icon = new JLabel("");
		lbl_icon.setBounds(59, 94, 78, 72);
		panel.add(lbl_icon);
		lbl_icon.setIcon(new ImageIcon(imgLabel));
		
		JLabel lbl_islem = new JLabel("\u0130SLEM SEC\u0130N\u0130Z");
		lbl_islem.setBounds(231, 30, 183, 26);
		panel.add(lbl_islem);
		lbl_islem.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		lbl_islem.setForeground(new Color(255, 255, 255));
		
		JButton btnOtobus = new JButton("Otobus \u0130\u015Flemleri");
		btnOtobus.setBounds(199, 171, 210, 40);
		panel.add(btnOtobus);
		btnOtobus.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		
		Image imgbutton1 = new ImageIcon(this.getClass().getResource("/busýcon.png")).getImage();
		btnOtobus.setIcon(new ImageIcon(imgbutton1));
		
		JButton btnKullanici = new JButton("Kullanici \u0130\u015Flemleri");
		btnKullanici.setBounds(199, 120, 210, 40);
		panel.add(btnKullanici);
		btnKullanici.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		btnKullanici.setIcon(new ImageIcon(imgbutton));
		
		JButton btnSefer = new JButton("Sefer \u0130\u015Flemleri");
		btnSefer.setBounds(199, 70, 210, 40);
		panel.add(btnSefer);
		btnSefer.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		Image imgbutton2 = new ImageIcon(this.getClass().getResource("/sefer.png")).getImage();
		btnSefer.setIcon(new ImageIcon(imgbutton2));
		
		
		btnSefer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Travel travel = new Travel();
				travel.setLocationRelativeTo(null);
				travel.setVisible(true);
				
			}
		});
		
		btnKullanici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = new User();
				user.setLocationRelativeTo(null);
				user.setVisible(true);
			}
		});
		
		btnOtobus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bus bus = new Bus();
				bus.setLocationRelativeTo(null);
				bus.setVisible(true);
			}
		});
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
