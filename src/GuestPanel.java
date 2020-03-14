import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.awt.event.ActionEvent;
import com.toedter.components.JLocaleChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GuestPanel extends JFrame {
	
	//-----göko----
		DefaultTableModel modelim = new DefaultTableModel();
		Object[] kolonlar = {"ID","Nereden","Nereye","Otobus","Tarih","Saat","Fiyat","TC No","Ad","Cinsiyet","Koltuk","PNR","Durum"};
		Object[] satirlar = new Object[13];
	//-----göko----
		
		

	private JPanel contentPane;
	private JTextField tfSaat;
	private JTextField tfUcret;
	private JTextField tfAd;
	private JTextField tfKoltuk;
	private JTextField tfPNR;
	private JTable table;
	
	
	static DefaultComboBoxModel cbmodel = new DefaultComboBoxModel();
	static DefaultComboBoxModel cbmodel2 = new DefaultComboBoxModel();
	
	static DefaultTableModel tablemodel = new DefaultTableModel();
	Object[] columns = {"ID","Nereden","Nereye","Ücret","Rota","Tarih","Saat","Otobüs", "Koltuk Sayýsý"};
	Object[] rows = new Object[9];
	private JTextField tfOtobus;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuestPanel frame = new GuestPanel();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					
					UserFunctions uf = new UserFunctions();
					ResultSet rs = uf.seferlistele();
					//ResultSet rs2 = uf.seferlistele();
						while(rs.next()) {
							String nereden = rs.getString("nereden");
							String nereye = rs.getString("nereye");
							cbmodel.addElement(nereden);
							cbmodel2.addElement(nereye);
						}
						
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuestPanel() {
		setTitle("Kullan\u0131c\u0131 Paneli");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1013, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255,140,0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(new Color(255, 255, 255));
		tabbedPane.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		tabbedPane.setBounds(10, 11, 977, 477);
		tabbedPane.setBackground(new Color(0, 0, 0)); // bekoson
		contentPane.add(tabbedPane);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(255,140,0));
		tabbedPane.addTab("Bilet", null, panel1, null);
		panel1.setLayout(null);
		
		JLabel label = new JLabel("Nereden");
		label.setForeground(Color.WHITE);
		label.setBounds(10, 15, 72, 25);
		label.setFont(new Font("Trebuchet MS", Font.PLAIN, 19));
		panel1.add(label);
		
		JLabel label_1 = new JLabel("Nereye");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(10, 45, 72, 25);
		label_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 19));
		panel1.add(label_1);
		
		JComboBox cbNereden = new JComboBox();
		//cbNereden.setModel(new DefaultComboBoxModel(new String[] {"yok"}));
		cbNereden.setModel(cbmodel);
		cbNereden.setBounds(84, 15, 124, 25);
		cbNereden.setFont(new Font("Dialog", Font.PLAIN, 18));
		panel1.add(cbNereden);
		
		JComboBox cbNereye = new JComboBox();
		cbNereye.setModel(cbmodel2);
		cbNereye.setBounds(84, 45, 124, 23);
		cbNereye.setFont(new Font("Dialog", Font.PLAIN, 18));
		panel1.add(cbNereye);
		

		
		JLabel lblOtobs = new JLabel("Otob\u00FCs");
		lblOtobs.setForeground(Color.WHITE);
		lblOtobs.setBounds(10, 147, 88, 25);
		lblOtobs.setFont(new Font("Trebuchet MS", Font.PLAIN, 19));
		panel1.add(lblOtobs);
		
		JLabel lblTarih = new JLabel("Tarih");
		lblTarih.setForeground(Color.WHITE);
		lblTarih.setBounds(10, 75, 72, 25);
		lblTarih.setFont(new Font("Trebuchet MS", Font.PLAIN, 19));
		panel1.add(lblTarih);
		
		JLabel lblSaat = new JLabel("Saat");
		lblSaat.setForeground(Color.WHITE);
		lblSaat.setBounds(10, 177, 64, 25);
		lblSaat.setFont(new Font("Trebuchet MS", Font.PLAIN, 19));
		panel1.add(lblSaat);
		
		JLabel lblcret = new JLabel("\u00DCcret");
		lblcret.setForeground(Color.WHITE);
		lblcret.setBounds(10, 207, 64, 25);
		lblcret.setFont(new Font("Trebuchet MS", Font.PLAIN, 19));
		panel1.add(lblcret);
		
		tfSaat = new JTextField();
		tfSaat.setEnabled(false);
		tfSaat.setBounds(84, 177, 124, 25);
		tfSaat.setFont(new Font("Dialog", Font.PLAIN, 18));
		tfSaat.setColumns(10);
		panel1.add(tfSaat);
		
		tfUcret = new JTextField();
		tfUcret.setEnabled(false);
		tfUcret.setBounds(84, 207, 124, 25);
		tfUcret.setFont(new Font("Dialog", Font.PLAIN, 18));
		tfUcret.setColumns(10);
		panel1.add(tfUcret);
		
		JLabel lblTc = new JLabel("TC");
		lblTc.setForeground(Color.WHITE);
		lblTc.setBounds(257, 15, 72, 25);
		lblTc.setFont(new Font("Trebuchet MS", Font.PLAIN, 19));
		panel1.add(lblTc);
		
		JLabel lblAd = new JLabel("Ad");
		lblAd.setForeground(Color.WHITE);
		lblAd.setBounds(257, 45, 72, 25);
		lblAd.setFont(new Font("Trebuchet MS", Font.PLAIN, 19));
		panel1.add(lblAd);
		
		JLabel label_8 = new JLabel("Cinsiyet");
		label_8.setForeground(Color.WHITE);
		label_8.setBounds(257, 75, 72, 25);
		label_8.setFont(new Font("Trebuchet MS", Font.PLAIN, 19));
		panel1.add(label_8);
		
		JLabel lblKoltuk = new JLabel("Koltuk");
		lblKoltuk.setForeground(Color.WHITE);
		lblKoltuk.setBounds(257, 105, 61, 25);
		lblKoltuk.setFont(new Font("Trebuchet MS", Font.PLAIN, 19));
		panel1.add(lblKoltuk);
		
		MaskFormatter tcFormatla = null;
		try {
			tcFormatla = new MaskFormatter("###########");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JFormattedTextField tfTC = new JFormattedTextField(tcFormatla);
		tfTC.setEnabled(false);
		tfTC.setBounds(328, 15, 124, 25);
		panel1.add(tfTC);
		
		tfAd = new JTextField();
		tfAd.setEnabled(false);
		tfAd.setBounds(328, 45, 124, 25);
		tfAd.setFont(new Font("Dialog", Font.PLAIN, 18));
		tfAd.setColumns(10);
		panel1.add(tfAd);
		
		tfKoltuk = new JTextField();
		tfKoltuk.setEnabled(false);
		tfKoltuk.setBounds(328, 105, 124, 25);
		tfKoltuk.setFont(new Font("Dialog", Font.PLAIN, 18));
		tfKoltuk.setColumns(10);
		panel1.add(tfKoltuk);
		

		
		JComboBox cbCinsiyet = new JComboBox();
		cbCinsiyet.setEnabled(false);
		cbCinsiyet.setModel(new DefaultComboBoxModel(new String[] {"Erkek", "Kad\u0131n"}));
		cbCinsiyet.setBounds(328, 75, 124, 25);
		cbCinsiyet.setFont(new Font("Dialog", Font.PLAIN, 18));
		panel1.add(cbCinsiyet);
		
		JButton btnCikis = new JButton("\u00C7\u0131k\u0131\u015F");
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserLogin ul = new UserLogin();
				dispose();
				ul.setLocationRelativeTo(null);
				ul.setVisible(true);
			}
		});
		btnCikis.setBounds(489, 85, 157, 30);
		btnCikis.setFont(new Font("Dialog", Font.PLAIN, 18));
		// ikon oluþturma
		Image img4 = new ImageIcon(this.getClass().getResource("/exit32x32.png")).getImage();
		btnCikis.setIcon(new ImageIcon(img4));
		panel1.add(btnCikis);
		
		JLabel lblPnr = new JLabel("PNR");
		lblPnr.setForeground(Color.WHITE);
		lblPnr.setFont(new Font("Trebuchet MS", Font.PLAIN, 19));
		lblPnr.setBounds(257, 135, 88, 25);
		panel1.add(lblPnr);
		
		tfPNR = new JTextField();
		tfPNR.setEnabled(false);
		tfPNR.setFont(new Font("Dialog", Font.PLAIN, 18));
		tfPNR.setColumns(10);
		tfPNR.setBounds(328, 135, 124, 25);
		panel1.add(tfPNR);
		
		JLabel lblGzergah = new JLabel("Rota");
		lblGzergah.setForeground(Color.WHITE);
		lblGzergah.setFont(new Font("Trebuchet MS", Font.PLAIN, 19));
		lblGzergah.setBounds(257, 165, 88, 25);
		panel1.add(lblGzergah);
		
		JTextArea tfRota = new JTextArea();
		tfRota.setEnabled(false);
		tfRota.setBounds(328, 165, 124, 55);
		panel1.add(tfRota);
		
		JDateChooser dcTarih = new JDateChooser();
		dcTarih.setDateFormatString("dd-MM-yyyy");
		dcTarih.setBounds(84, 75, 124, 25);
		panel1.add(dcTarih);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBackground(new Color(255,140,0));
		tablePanel.setForeground(Color.WHITE);
		tablePanel.setBounds(10, 243, 636, 195);
		tablePanel.setVisible(false);
		panel1.add(tablePanel);
		tablePanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 616, 173);
		tablePanel.add(scrollPane);


		
		JButton btnSefer = new JButton("Sefer Sorgula");
		btnSefer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String nereden,nereye,tarih;
				
				nereden = cbNereden.getSelectedItem().toString();
				nereye = cbNereye.getSelectedItem().toString();
				DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				tarih = df.format(dcTarih.getDate());
				
				UserFunctions uf = new UserFunctions();
				ResultSet rs = uf.seferSorgula(nereden, nereye, tarih);
				try {
				while (rs.next()) {						
						rows[0] = rs.getInt("id");
						rows[1] = rs.getString("nereden");
						rows[2] = rs.getString("nereye");
						rows[3] = rs.getInt("price");
						rows[4] = rs.getString("route");
						rows[5] = rs.getString("date");
						rows[6] = rs.getString("time");
						rows[7] = rs.getString("bus");
						rows[8] = uf.koltukSayisi(rs.getString("bus"));
						
						tablemodel.addRow(rows);

					}
				table.setModel(tablemodel);
				if (!rs.next()) tablePanel.setVisible(true);
				



				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			} 
			
		});
		btnSefer.setBounds(10, 105, 198, 38);
		btnSefer.setFont(new Font("Dialog", Font.PLAIN, 18));
		// ikon oluþturma
		Image img = new ImageIcon(this.getClass().getResource("/search24x24.png")).getImage();
		btnSefer.setIcon(new ImageIcon(img));
		panel1.add(btnSefer);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				UserFunctions uf = new UserFunctions();
				
				tfUcret.setText(tablemodel.getValueAt(table.getSelectedRow(), 3).toString());
				tfRota.setText((String) tablemodel.getValueAt(table.getSelectedRow(), 4));
			    tfSaat.setText((String) tablemodel.getValueAt(table.getSelectedRow(), 6));
				tfOtobus.setText((String) tablemodel.getValueAt(table.getSelectedRow(), 7));
				
				Integer koltukSayim = Integer.valueOf(String.valueOf(tablemodel.getValueAt(table.getSelectedRow(), 8)));
				Integer AltSatir = 0;
				for (int i=1; i<=koltukSayim; i++) 
				{
					Color red = new Color(198, 40, 40);
					Color green = new Color(46, 125, 50);
					
					JButton btnkoltuk = new JButton(String.valueOf(i));
					btnkoltuk.setFont(new Font("Dialog", Font.BOLD, 13));
					btnkoltuk.setBackground(green);
					btnkoltuk.setForeground(Color.white);
					
					String date = tablemodel.getValueAt(table.getSelectedRow(), 5).toString();
					
					if (i%4==0) {
						btnkoltuk.setBounds(675, (AltSatir*40), 50, 35);
						
						if (uf.biletBul(tfOtobus.getText(), date, i)) {
							btnkoltuk.setBackground(red);
							btnkoltuk.setEnabled(false);
						}
					} else if (i%4 == 1) {
						btnkoltuk.setBounds(750, (AltSatir*40), 50, 35);
						
						if (uf.biletBul(tfOtobus.getText(), date, i)) {
							btnkoltuk.setBackground(red);
							btnkoltuk.setEnabled(false);
						}
					} else if (i%4 == 2) {
						btnkoltuk.setBounds(825, (AltSatir*40), 50, 35);
						
						if (uf.biletBul(tfOtobus.getText(), date, i)) {
							btnkoltuk.setBackground(red);
							btnkoltuk.setEnabled(false);
						}
					} else if (i%4 == 3) {
						btnkoltuk.setBounds(900, (AltSatir*40), 50, 35);
						
						if (uf.biletBul(tfOtobus.getText(), date, i)) {
							btnkoltuk.setBackground(red);
							btnkoltuk.setEnabled(false);
						}
						AltSatir++;
					}
					
					final Integer i2 = i;
					
					btnkoltuk.addActionListener(new ActionListener()
					{
					  public void actionPerformed(ActionEvent e)
					  {
						  // burada i deðiþkenini kullanmak isterseniz i2 oluþturdum onu kullanýn. - furkan yýlmaz
						  
						 // System.out.println((i2) + ". Button Click");
						 // System.out.println(date);
						  JOptionPane.showMessageDialog(null, "Kayýt olma sayfasýna yönlendiriliyorsunuz...");
						  NewUser nu = new NewUser();
						  nu.setLocationRelativeTo(null);
						  dispose();
						  nu.setVisible(true);
						  
						 // Random r = new Random();
						 // int rastgele = r.nextInt(10000);
						 // tfPNR.setText("PNR-"+Integer.toString(rastgele));
						 // tfKoltuk.setText(Integer.toString(i2));
					  }
					});
					
				panel1.add(btnkoltuk);
				panel1.revalidate();
				panel1.repaint();
				
					
					
				}
			}
		});
		tablemodel.setColumnIdentifiers(columns);
		table.setBounds(512, 155, 124, 70);
		//panel1.add(table);
		scrollPane.setViewportView(table);
		
		
		tfOtobus = new JTextField();
		tfOtobus.setEnabled(false);
		tfOtobus.setFont(new Font("Dialog", Font.PLAIN, 18));
		tfOtobus.setColumns(10);
		tfOtobus.setBounds(84, 147, 124, 25);
		panel1.add(tfOtobus);
				
				modelim.setColumnIdentifiers(kolonlar);
				// ikon oluþturma
				Image img3 = new ImageIcon(this.getClass().getResource("/search24x24.png")).getImage();
				// ikon oluþturma
				Image img1 = new ImageIcon(this.getClass().getResource("/edit24x24.png")).getImage();
				// ikon oluþturma
				Image img34 = new ImageIcon(this.getClass().getResource("/exit32x32.png")).getImage();
				// ikon oluþturma
				Image img35 = new ImageIcon(this.getClass().getResource("/print32x32.png")).getImage();
		//-----göko----

				JButton btnSatinAl = new JButton("Sat\u0131n Al");
				btnSatinAl.setEnabled(false);
				btnSatinAl.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String nereden = cbNereden.getSelectedItem().toString();
						String nereye = cbNereye.getSelectedItem().toString();
						String bus = tfOtobus.getText();
						DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
						String date = df.format(dcTarih.getDate());
						String time = tfSaat.getText();
						/*
						 *  int price
						 *  String TC
						 *  String name
						 *  String sex
						 *  int seat
						 *  String pnr
						 *  int stat
						 *  
						 */
						
						int price = Integer.parseInt(tfUcret.getText());
						String TC = tfTC.getText();
						String name = tfAd.getText();
						String sex = cbCinsiyet.getSelectedItem().toString();
						int seat = Integer.parseInt(tfKoltuk.getText());
						String pnr = tfPNR.getText();
						// int stat
						if(nereden.isEmpty() || nereye.isEmpty() || bus.isEmpty() || date.isEmpty() || time.isEmpty() || TC.isEmpty() || name.isEmpty() || sex.isEmpty() || pnr.isEmpty() || Integer.toString(price).isEmpty() || Integer.toString(seat).isEmpty()) {
							JOptionPane.showMessageDialog(null, "Alanlar boþ geçilemez");
						}
						else {
							int stat = 1;
							UserFunctions uf = new UserFunctions();
							uf.biletAl(nereden, nereye, bus, date, time, price, TC, name, sex, seat, pnr, stat);
							JOptionPane.showMessageDialog(null, "Bilet Satýn Alýndý");
							
							
							//contentPane.removeAll();
							//contentPane.revalidate();
							//contentPane.repaint();
							
							
						}
						
						
						
						//System.out.println(date);
					}
				});
				btnSatinAl.setBounds(489, 15, 157, 30);
				btnSatinAl.setFont(new Font("Dialog", Font.PLAIN, 18));
				// ikon oluþturma
				Image img2 = new ImageIcon(this.getClass().getResource("/dollar32x32.png")).getImage();
				btnSatinAl.setIcon(new ImageIcon(img2));
				panel1.add(btnSatinAl);
				
				JButton btnTemizle = new JButton("Temizle");
				btnTemizle.setEnabled(false);
				btnTemizle.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						// temizleme butonu
						while (tablemodel.getRowCount()>0)
				          {
				             tablemodel.removeRow(0);
				          }
						
						//contentPane.remove(btnkoltuk);
						//contentPane.revalidate();
						//contentPane.repaint();
						
					}
				});
				btnTemizle.setBounds(489, 50, 157, 30);
				btnTemizle.setFont(new Font("Dialog", Font.PLAIN, 18));
				// ikon oluþturma
				Image img41 = new ImageIcon(this.getClass().getResource("/delete32x32.png")).getImage();
				btnTemizle.setIcon(new ImageIcon(img41));
				panel1.add(btnTemizle);
		
		
	}
}
