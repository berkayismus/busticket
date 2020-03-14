import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Image;

public class User extends JFrame {

	private JPanel contentPane;
	private JTable table;
    
	DefaultTableModel modelim = new DefaultTableModel();
	Object[] kolonlar= {"ID","Ad","Telefon","Email","Kullanýcý Adý","Sifre","Cevap","Soru","Statü"};
	Object[] satirlar= new Object[9];
	private JTextField txt_name;
	private JTextField txt_phone;
	private JTextField txt_email;
	private JTextField txt_username;
	private JTextField txt_password;
	private JTextField txt_answer;
	private JTextField txt_question;
	private JTextField txt_stat;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			
				try {
					User frame = new User();
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
	public User() {
		setTitle("Kullan\u0131c\u0131 \u0130\u015Flemleri");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 849, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(255,140,0));
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(28, 28, 539, 293);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("D\u00FCzenle/Sil", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(10, 11, 515, 246);
		panel.add(scrollPane);
		
		table = new JTable();
		modelim.setColumnIdentifiers(kolonlar);

		
		table.setBounds(287, 66, 98, 90);
		//panel.add(table);
		scrollPane.setViewportView(table);
		
		JButton btnListele = new JButton("Listele");
		btnListele.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		Image imgbutton2 = new ImageIcon(this.getClass().getResource("/listicon.png")).getImage();
		btnListele.setIcon(new ImageIcon(imgbutton2));
		btnListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//modelim.addRow(satirlar);
				//table.setModel(modelim);
				
				Baglanti baglanti = new Baglanti();
				ResultSet rs=baglanti.kullaniciListele();
				try {
					while(rs.next()) {
						satirlar[0]=rs.getString("id");
						satirlar[1]=rs.getString("name");
						satirlar[2]=rs.getString("phone");
						satirlar[3]=rs.getString("email");
						satirlar[4]=rs.getString("username");
						satirlar[5]=rs.getString("password");
						satirlar[6]=rs.getString("answer");
						satirlar[7]=rs.getString("question");
						satirlar[8]=rs.getString("stat");
						modelim.addRow(satirlar);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				table.setModel(modelim);
				JOptionPane.showMessageDialog(null, "Kullanýcý bilgileri baþarýyla listelendi!");
			}
		});
		btnListele.setBounds(695, 11, 128, 23);
		contentPane.add(btnListele);
		
		JTextField txt_id = new JTextField();
		txt_id.setBounds(695, 60, 128, 20);
		contentPane.add(txt_id);
		txt_id.setColumns(10);
		
		txt_name = new JTextField();
		txt_name.setBounds(695, 90, 128, 20);
		contentPane.add(txt_name);
		txt_name.setColumns(10);
		
		txt_phone = new JTextField();
		txt_phone.setBounds(695, 120, 128, 20);
		contentPane.add(txt_phone);
		txt_phone.setColumns(10);
		
		txt_email = new JTextField();
		txt_email.setBounds(695, 150, 128, 20);
		contentPane.add(txt_email);
		txt_email.setColumns(10);
		
		txt_username = new JTextField();
		txt_username.setBounds(695, 180, 128, 20);
		contentPane.add(txt_username);
		txt_username.setColumns(10);
		
		txt_password = new JTextField();
		txt_password.setBounds(695, 210, 128, 20);
		contentPane.add(txt_password);
		txt_password.setColumns(10);
		
		txt_answer = new JTextField();
		txt_answer.setBounds(695, 240, 128, 20);
		contentPane.add(txt_answer);
		txt_answer.setColumns(10);
		
		txt_question = new JTextField();
		txt_question.setBounds(695, 270, 128, 20);
		contentPane.add(txt_question);
		txt_question.setColumns(10);
		
		txt_stat = new JTextField();
		txt_stat.setBounds(695, 300, 128, 20);
		contentPane.add(txt_stat);
		txt_stat.setColumns(10);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txt_id.setText((String) modelim.getValueAt(table.getSelectedRow(),0));
				txt_name.setText((String) modelim.getValueAt(table.getSelectedRow(),1));
				txt_phone.setText((String) modelim.getValueAt(table.getSelectedRow(),2));
				txt_email.setText((String) modelim.getValueAt(table.getSelectedRow(),3));
				txt_username.setText((String) modelim.getValueAt(table.getSelectedRow(),4));
				txt_password.setText((String) modelim.getValueAt(table.getSelectedRow(),5));
				txt_answer.setText((String) modelim.getValueAt(table.getSelectedRow(),6));
				txt_question.setText((String) modelim.getValueAt(table.getSelectedRow(),7));
				txt_stat.setText((String) modelim.getValueAt(table.getSelectedRow(),8));
				
			}
		});
	
		//kullanýcýduzenle
		JButton btnNewButton = new JButton("D\u00FCzenle");
		btnNewButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		Image imgbutton7 = new ImageIcon(this.getClass().getResource("/updateýcon.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(imgbutton7));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String name,phone,email,username,password,answer,question;
				int id,stat;
				id=Integer.parseInt(txt_id.getText());
				name=txt_name.getText();
				phone=txt_phone.getText();
				email=txt_email.getText();
				username=txt_username.getText();
				password=txt_password.getText();
				answer=txt_answer.getText();
				question=txt_question.getText();
				stat=Integer.parseInt(txt_stat.getText());
				
				Baglanti baglanti = new Baglanti();
				baglanti.kullaniciGuncelle(id, name, phone, email, username, password, answer, question, stat);
				JOptionPane.showMessageDialog(null, "Kullanýcý bilgileri baþarýyla düzenlendi!");
			}
		});
		//kullanýcýsil
		btnNewButton.setBounds(577, 330, 116, 23);
		contentPane.add(btnNewButton);
		
		JButton btnSil = new JButton("Sil");
		btnSil.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		Image imgbutton9 = new ImageIcon(this.getClass().getResource("/delete icon.png")).getImage();
		btnSil.setIcon(new ImageIcon(imgbutton9));
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id;
				id=Integer.parseInt(txt_id.getText());
				Baglanti baglanti = new Baglanti();
				baglanti.kullanicisil(id);
				JOptionPane.showMessageDialog(null, "Kullanýcý bilgileri baþarýyla silindi..!");
			}
		});
		btnSil.setBounds(695, 330, 128, 23);
		contentPane.add(btnSil);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblNewLabel.setBounds(577, 60, 108, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ad");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(577, 90, 108, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Telefon");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(577, 120, 108, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("E-Mail");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(577, 150, 108, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(577, 180, 108, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Sifre");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(577, 210, 108, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Cevap");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(577, 240, 108, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Soru");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblNewLabel_7.setBounds(577, 270, 108, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Stat\u00FC");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblNewLabel_8.setBounds(577, 300, 108, 14);
		contentPane.add(lblNewLabel_8);
		
		
	}
}
