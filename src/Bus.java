import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Bus extends JFrame {

	private JPanel contentPane;
	private JTextField tfModel;
	private JTextField tfPlaka;
	private JTextField tfKoltuk;
	private JTable table;
	
	DefaultTableModel modelim = new DefaultTableModel();
	
	Object[] kolonlar = {"id","Model","Plaka","Koltuk Sayýsý"};
	Object[] satirlar = new Object[4];
	private JTextField tfModel2;
	private JTextField tfKoltuk2;
	private JTextField tfPlaka2;
	private JTextField tf2ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bus frame = new Bus();
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
	public Bus() {
		setTitle("Otob\u00FCs i\u015Flemleri");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255,140,0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tabbedPane.setBounds(0, 0, 779, 443);
		contentPane.add(tabbedPane);
		
		JPanel eklePanel = new JPanel();
		tabbedPane.addTab("Ekle", null, eklePanel, null);
		eklePanel.setLayout(null);
		
		JLabel lblMarkamodel = new JLabel("Marka/Model ");
		lblMarkamodel.setForeground(Color.WHITE);
		lblMarkamodel.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblMarkamodel.setBounds(25, 30, 148, 14);
		eklePanel.add(lblMarkamodel);
		
		JLabel lblPlaka_1 = new JLabel("Plaka ");
		lblPlaka_1.setForeground(Color.WHITE);
		lblPlaka_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblPlaka_1.setBounds(25, 60, 148, 14);
		eklePanel.add(lblPlaka_1);
		

		
		JLabel lblKoltuk = new JLabel("Koltuk");
		lblKoltuk.setForeground(Color.WHITE);
		lblKoltuk.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblKoltuk.setBounds(25, 90, 148, 14);
		eklePanel.add(lblKoltuk);
		
		JPanel duzenlePanel = new JPanel();
		tabbedPane.addTab("D\u00FCzenle", null, duzenlePanel, null);
		duzenlePanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 34, 442, 283);
		duzenlePanel.add(scrollPane);
		
		table = new JTable();

		modelim.setColumnIdentifiers(kolonlar);

		table.setBounds(300, 86, 290, 154);
		//duzenlePanel.add(table);
		scrollPane.setViewportView(table);
		

		

		
		JLabel lblMesaj = new JLabel("");
		lblMesaj.setForeground(Color.BLUE);
		lblMesaj.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesaj.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMesaj.setBounds(63, 192, 346, 84);
		eklePanel.add(lblMesaj);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(255,140,0));
		panel.setBounds(0, -46, 774, 461);
		eklePanel.add(panel);
		panel.setLayout(null);
		
		tfModel = new JTextField();
		tfModel.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		tfModel.setBounds(194, 75, 104, 20);
		panel.add(tfModel);
		tfModel.setColumns(10);
		
		tfPlaka = new JTextField();
		tfPlaka.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		tfPlaka.setBounds(194, 106, 104, 20);
		panel.add(tfPlaka);
		tfPlaka.setColumns(10);
		
		tfKoltuk = new JTextField();
		tfKoltuk.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		tfKoltuk.setBounds(194, 137, 104, 20);
		panel.add(tfKoltuk);
		tfKoltuk.setColumns(10);
		
		JButton btnEkle = new JButton("Ekle");
		btnEkle.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		
		
		Image imgbutton2 = new ImageIcon(this.getClass().getResource("/Add-icon.png")).getImage();
		btnEkle.setIcon(new ImageIcon(imgbutton2));
		btnEkle.setBounds(194, 168, 104, 41);
		panel.add(btnEkle);
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// INSERT INTO tabloýsmý (alanadý1,alanadý2,alanadý3) values('deger1','deger2','deger3')
				String model,plaka;
				int koltuk;
				
				model = tfModel.getText();
				plaka = tfPlaka.getText();
				koltuk = Integer.parseInt(tfKoltuk.getText());
				
				Baglanti baglanti = new Baglanti();
				baglanti.otobusEkle(model, plaka, koltuk);
				//lblMesaj.setText("Otobüs baþarýyla eklendi!");
				
				
				
				JOptionPane.showMessageDialog(null, "Otobüs baþarýyla eklendi!");
				
			}
		});
		
		JButton btnListele = new JButton("Listele");
		btnListele.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		Image imgbutton3 = new ImageIcon(this.getClass().getResource("/listicon.png")).getImage();
		btnListele.setIcon(new ImageIcon(imgbutton3));
		
		btnListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Baglanti baglanti = new Baglanti();
				ResultSet rs = baglanti.otobusListele();
				
				
				try {
					while(rs.next()) {
						satirlar[0] = rs.getString("id");
						satirlar[1] = rs.getString("model");
						satirlar[2] = rs.getString("plaka");
						satirlar[3] = rs.getString("seat");
						modelim.addRow(satirlar);
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				table.setModel(modelim);
				JOptionPane.showMessageDialog(null, "Otobüsler baþarýyla listelendi!");
			}
		});
		btnListele.setBounds(626, 24, 106, 33);
		duzenlePanel.add(btnListele);
		

		

		
		JButton btnGuncelle = new JButton("G\u00FCncelle");
		btnGuncelle.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		Image imgbutton4 = new ImageIcon(this.getClass().getResource("/updateýcon.png")).getImage();
		btnGuncelle.setIcon(new ImageIcon(imgbutton4));
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// UPDATE tabloismi set alan1='',alan=45 where numara=5
				String model,plaka;
				int id,seat;
				
				
				id = Integer.parseInt(tf2ID.getText());
				model = tfModel2.getText();
				plaka = tfPlaka2.getText();
				seat = Integer.parseInt(tfKoltuk2.getText());
				

				Baglanti baglanti = new Baglanti();
				baglanti.otobusGuncelle(id, model, plaka, seat);
				JOptionPane.showMessageDialog(null, "Bilgiler Baþarýyla Güncellendi!");
			}
		});
		btnGuncelle.setBounds(510, 267, 125, 33);
		duzenlePanel.add(btnGuncelle);
		
		tfModel2 = new JTextField();
		tfModel2.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		tfModel2.setColumns(10);
		tfModel2.setBounds(626, 140, 106, 20);
		duzenlePanel.add(tfModel2);
		
		tfKoltuk2 = new JTextField();
		tfKoltuk2.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		tfKoltuk2.setColumns(10);
		tfKoltuk2.setBounds(626, 200, 106, 20);
		duzenlePanel.add(tfKoltuk2);
		
		JLabel lblKoltuk_1 = new JLabel("Koltuk ");
		lblKoltuk_1.setForeground(Color.WHITE);
		lblKoltuk_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblKoltuk_1.setBounds(510, 200, 106, 14);
		duzenlePanel.add(lblKoltuk_1);
		
		JLabel lblPlaka = new JLabel("Plaka ");
		lblPlaka.setForeground(Color.WHITE);
		lblPlaka.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblPlaka.setBounds(510, 170, 106, 14);
		duzenlePanel.add(lblPlaka);
		
		tfPlaka2 = new JTextField();
		tfPlaka2.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		tfPlaka2.setColumns(10);
		tfPlaka2.setBounds(626, 170, 106, 20);
		duzenlePanel.add(tfPlaka2);
		
		JLabel lblModel = new JLabel("Model ");
		lblModel.setForeground(Color.WHITE);
		lblModel.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblModel.setBounds(510, 140, 106, 14);
		duzenlePanel.add(lblModel);
		
		tf2ID = new JTextField();
		tf2ID.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		tf2ID.setColumns(10);
		tf2ID.setBounds(626, 110, 106, 20);
		duzenlePanel.add(tf2ID);
		
		JLabel lblId = new JLabel("ID ");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblId.setBounds(510, 110, 106, 14);
		duzenlePanel.add(lblId);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tf2ID.setText((String) modelim.getValueAt(table.getSelectedRow(), 0));
				tfModel2.setText((String) modelim.getValueAt(table.getSelectedRow(), 1));
				tfPlaka2.setText((String) modelim.getValueAt(table.getSelectedRow(), 2));
				tfKoltuk2.setText((String) modelim.getValueAt(table.getSelectedRow(), 3)) ;
				
			}
		});
		
		JButton btnSil = new JButton("Sil");
		btnSil.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		Image imgbutton5 = new ImageIcon(this.getClass().getResource("/delete icon.png")).getImage();
		btnSil.setIcon(new ImageIcon(imgbutton5));
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// delete * from bus where id=id
				
				int id = Integer.parseInt(tf2ID.getText());
				Baglanti baglanti = new Baglanti();
				baglanti.otobusSil(id);
				JOptionPane.showMessageDialog(null, "Silme Ýþlemi Baþarýyla Gerçekleþti!");
			}
		});
		btnSil.setBounds(645, 267, 119, 33);
		
		duzenlePanel.add(btnSil);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 774, 415);
		panel_1.setBackground(new Color(255, 140, 0));
		duzenlePanel.add(panel_1);
		
		
	}
	
	
	
	static void BusRemove() {
		
		
	}
}
