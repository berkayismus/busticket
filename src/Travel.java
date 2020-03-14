import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ItemListener;
import java.io.Console;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import java.awt.Font;

public class Travel extends JFrame {

	DefaultTableModel modelim = new DefaultTableModel();
	Object[] kolonlar= {"id","nereden","nereye","price","route","date","time","bus"};
	Object[] satirlar= new Object[8];
	private JPanel contentPane;
	private JTextField txt_fiyat;
	private JTable table;
	private JTextField txtid;
	private JTextField txtnereden;
	private JTextField txtnereye;
	private JTextField txtprice;
	private JTextField txtbus;
	private JTextField txtsaat;

	/**
	 * Launch the application.
	 */
	
	static DefaultComboBoxModel cbotobus = new DefaultComboBoxModel();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Travel frame = new Travel();
					frame.setVisible(true);
					Baglanti baglan = new Baglanti();
					ResultSet rs = baglan.otobusListele();
					while(rs.next()) {
						String otobus = rs.getString("model");
						cbotobus.addElement(otobus);
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
	public Travel() {
		setTitle("Sefer \u0130\u015Flemleri");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255,140,0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		tabbedPane.setBounds(21, 11, 574, 431);
		contentPane.add(tabbedPane);
		
		JPanel eklePanel = new JPanel();
		eklePanel.setBackground(new Color(255,140,0));
		tabbedPane.addTab("Ekle", null, eklePanel, null);
		eklePanel.setLayout(null);
		
		JLabel lblnereden = new JLabel("Nereden ");
		lblnereden.setForeground(Color.WHITE);
		lblnereden.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblnereden.setBounds(10, 28, 81, 14);
		eklePanel.add(lblnereden);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u0130stanbul", "Ankara", "\u0130zmir", "Tekirda\u011F", "\u00C7orlu"}));
		comboBox.setBounds(112, 22, 96, 20);
		eklePanel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\u0130stanbul", "Ankara", "\u0130zmir", "Tekirda\u011F", "\u00C7orlu"}));
		comboBox_1.setBounds(112, 52, 96, 20);
		eklePanel.add(comboBox_1);
		
		JLabel lblnereye = new JLabel("Nereye ");
		lblnereye.setForeground(Color.WHITE);
		lblnereye.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblnereye.setBounds(10, 58, 81, 14);
		eklePanel.add(lblnereye);
		
		JLabel lblFiyat = new JLabel("Fiyat ");
		lblFiyat.setForeground(Color.WHITE);
		lblFiyat.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblFiyat.setBounds(10, 148, 81, 14);
		eklePanel.add(lblFiyat);
		
		txt_fiyat = new JTextField();
		txt_fiyat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_fiyat.setColumns(10);
		txt_fiyat.setBounds(112, 142, 96, 20);
		eklePanel.add(txt_fiyat);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		textArea.setBounds(112, 202, 369, 61);
		eklePanel.add(textArea);
		
		JLabel lblGzergah = new JLabel("G\u00FCzergah ");
		lblGzergah.setForeground(Color.WHITE);
		lblGzergah.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblGzergah.setBounds(10, 208, 81, 14);
		eklePanel.add(lblGzergah);
		
		
		
		JPanel duzenlePanel = new JPanel();
		duzenlePanel.setBackground(new Color(255,140,0));
		tabbedPane.addTab("D\u00FCzenle", null, duzenlePanel, null);
		duzenlePanel.setLayout(null);
		

		JButton btnSil = new JButton("Sil");
		btnSil.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		Image imgbutton9 = new ImageIcon(this.getClass().getResource("/delete32x32.png")).getImage();
		btnSil.setIcon(new ImageIcon(imgbutton9));
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id;
				id=Integer.parseInt(txtid.getText());
				Baglanti baglanti = new Baglanti();
				baglanti.sefersil(id);
				JOptionPane.showMessageDialog(null, "Ýlgili sefer silindi..!");
			}
		});
		btnSil.setBounds(445, 80, 114, 30);
		duzenlePanel.add(btnSil);
		JButton btnListele = new JButton("Listele");
		btnListele.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		btnListele.setBounds(445, 10, 114, 30);
		JScrollPane scrollPane = new JScrollPane();

		table = new JTable();
		scrollPane.setViewportView(table);

		//eksik oldugu için göstermiyordu.!!!
		modelim.setColumnIdentifiers(kolonlar);
		
		scrollPane.setBounds(10, 161, 549, 231);
		duzenlePanel.add(scrollPane);
		duzenlePanel.add(btnListele);
		Image imgbutton3 = new ImageIcon(this.getClass().getResource("/listicon.png")).getImage();
		btnListele.setIcon(new ImageIcon(imgbutton3));
		btnListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Baglanti baglanti=new Baglanti();
				ResultSet rs=baglanti.seferlistele();
				try {
					while(rs.next()) {
						
						
						satirlar[0]=rs.getString("id");
						satirlar[1]=rs.getString("nereden");
						satirlar[2]=rs.getString("nereye");
						satirlar[3]=rs.getString("price");
						satirlar[4]=rs.getString("route");
						satirlar[5]=rs.getString("date");
						satirlar[6]=rs.getString("time");
						satirlar[7]=rs.getString("bus");
						modelim.addRow(satirlar);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				table.setModel(modelim);
				JOptionPane.showMessageDialog(null, "Seferler baþarýyla listelendi!");
			}
		});
        
		txtid = new JTextField();
		txtid.setBounds(116, 10, 86, 20);
		duzenlePanel.add(txtid);
		txtid.setColumns(10);
		
		txtnereden = new JTextField();
		txtnereden.setBounds(116, 40, 86, 20);
		duzenlePanel.add(txtnereden);
		txtnereden.setColumns(10);
		
		txtnereye = new JTextField();
		txtnereye.setBounds(116, 70, 86, 20);
		duzenlePanel.add(txtnereye);
		txtnereye.setColumns(10);
		
		txtprice = new JTextField();
		txtprice.setBounds(293, 10, 86, 20);
		duzenlePanel.add(txtprice);
		txtprice.setColumns(10);
		
		JLabel lbl_id = new JLabel("\u0130d ");
		lbl_id.setForeground(Color.WHITE);
		lbl_id.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lbl_id.setBounds(10, 10, 96, 14);
		duzenlePanel.add(lbl_id);
		
		JLabel lbl_nereye = new JLabel("Nereye ");
		lbl_nereye.setForeground(Color.WHITE);
		lbl_nereye.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lbl_nereye.setBounds(10, 70, 96, 14);
		duzenlePanel.add(lbl_nereye);
		
		JLabel lbl_fiyat = new JLabel("Fiyat ");
		lbl_fiyat.setForeground(Color.WHITE);
		lbl_fiyat.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lbl_fiyat.setBounds(212, 10, 71, 14);
		duzenlePanel.add(lbl_fiyat);
		
		JLabel lbl_guzergah = new JLabel("Rota");
		lbl_guzergah.setForeground(Color.WHITE);
		lbl_guzergah.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lbl_guzergah.setBounds(212, 70, 71, 14);
		duzenlePanel.add(lbl_guzergah);
		
		JLabel lbl_nereden = new JLabel("Nereden ");
		lbl_nereden.setForeground(Color.WHITE);
		lbl_nereden.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lbl_nereden.setBounds(10, 40, 96, 14);
		duzenlePanel.add(lbl_nereden);
		
		txtbus = new JTextField();
		txtbus.setBounds(293, 40, 86, 20);
		duzenlePanel.add(txtbus);
		txtbus.setColumns(10);
		
		JLabel lbl_tarih = new JLabel("Tarih ");
		lbl_tarih.setForeground(Color.WHITE);
		lbl_tarih.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lbl_tarih.setBounds(10, 100, 96, 14);
		duzenlePanel.add(lbl_tarih);
		
		JLabel lbl_saat = new JLabel("Saat ");
		lbl_saat.setForeground(Color.WHITE);
		lbl_saat.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lbl_saat.setBounds(10, 130, 86, 14);
		duzenlePanel.add(lbl_saat);
		
		txtsaat = new JTextField();
		txtsaat.setBounds(116, 130, 86, 20);
		duzenlePanel.add(txtsaat);
		txtsaat.setColumns(10);
		
		JLabel lbl_otobus = new JLabel("Otob\u00FCs ");
		lbl_otobus.setForeground(Color.WHITE);
		lbl_otobus.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lbl_otobus.setBounds(212, 40, 71, 14);
		duzenlePanel.add(lbl_otobus);
		
		JTextArea txtroute12 = new JTextArea();
		txtroute12.setBounds(293, 70, 142, 64);
		duzenlePanel.add(txtroute12);
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
			}
		});
		
		
		MaskFormatter mf2 = null;
		try {
			mf2 = new MaskFormatter("##-##-####");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JFormattedTextField txt_tarih = new JFormattedTextField(mf2);
		txt_tarih.setText("");
		txt_tarih.setBounds(116, 100, 86, 20);
		duzenlePanel.add(txt_tarih);
		
		
		JLabel lblTarih = new JLabel("Tarih ");
		lblTarih.setForeground(Color.WHITE);
		lblTarih.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblTarih.setBounds(10, 88, 81, 14);
		eklePanel.add(lblTarih);
		
		JLabel lblSaat = new JLabel("Saat ");
		lblSaat.setForeground(Color.WHITE);
		lblSaat.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblSaat.setBounds(10, 118, 81, 14);
		eklePanel.add(lblSaat);
		
		JDateChooser date_chooser = new JDateChooser();
		date_chooser.setDateFormatString("dd-MM-yyyy");
		date_chooser.setBounds(112, 82, 95, 20);
		eklePanel.add(date_chooser);
		
		JLabel lblOtobus = new JLabel("Otobus ");
		lblOtobus.setForeground(Color.WHITE);
		lblOtobus.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblOtobus.setBounds(10, 178, 81, 14);
		eklePanel.add(lblOtobus);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_2.setModel(cbotobus);
		comboBox_2.setBounds(112, 172, 96, 20);
		eklePanel.add(comboBox_2);
		MaskFormatter mf = null;
		try {
			mf = new MaskFormatter("##:##");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JFormattedTextField txt_saat = new JFormattedTextField(mf);
		txt_saat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_saat.setText("");
		txt_saat.setBounds(112, 111, 96, 20);
		eklePanel.add(txt_saat);
		

	JButton button = new JButton("Ekle");
	button.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
	Image imgbutton2 = new ImageIcon(this.getClass().getResource("/Add-icon.png")).getImage();
	button.setIcon(new ImageIcon(imgbutton2));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nereden,nereye,route,date,time,bus;
				int price;
				nereden=comboBox.getSelectedItem().toString();
				nereye=comboBox_1.getSelectedItem().toString();
				price=Integer.parseInt(txt_fiyat.getText());
				route=textArea.getText();
				
				//dateformatladýk...
				date=date_chooser.getDateFormatString();
				DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				date = df.format(date_chooser.getDate());
				
				time=txt_saat.getText();
				bus=comboBox_2.getSelectedItem().toString();
				Baglanti baglanti = new Baglanti();
				baglanti.SeferEkle(nereden, nereye, price, route,date,time,bus);
				JOptionPane.showMessageDialog(null, "Sefer baþarýyla eklendi!");
			}
		});
		button.setBounds(112, 272, 89, 23);
		eklePanel.add(button);
		
		JButton btnDuzenle = new JButton("D\u00FCzenle");
		btnDuzenle.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		Image imgbutton4 = new ImageIcon(this.getClass().getResource("/updateýcon.png")).getImage();
		btnDuzenle.setIcon(new ImageIcon(imgbutton4));
		btnDuzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nereden,nereye,route,date,time,bus;
				int id;
				int price;
				id=Integer.parseInt(txtid.getText());
				nereden=txtnereden.getText();
				nereye=txtnereye.getText();
				price=Integer.parseInt(txtprice.getText());
				route=txtroute12.getText();
				date =txt_tarih.getText();
				time = txtsaat.getText();
				bus = txtbus.getText();
				Baglanti baglanti = new Baglanti();
				baglanti.seferduzenle(id, nereden, nereye, price, route,date,time,bus);
				
				JOptionPane.showMessageDialog(null, "Ýlgili sefer düzenlendi!");
				
		}
		});
		btnDuzenle.setBounds(445, 45, 114, 30);
		duzenlePanel.add(btnDuzenle);
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				txtid.setText((String) modelim.getValueAt(table.getSelectedRow(),0));
				txtnereden.setText((String) modelim.getValueAt(table.getSelectedRow(),1));
				txtnereye.setText((String) modelim.getValueAt(table.getSelectedRow(),2));
				txtprice.setText((String) modelim.getValueAt(table.getSelectedRow(),3));
				txtroute12.setText((String) modelim.getValueAt(table.getSelectedRow(),4));
				//dc.setDate((Date) modelim.getValueAt(table.getSelectedRow(), 5));
				txt_tarih.setText((String) modelim.getValueAt(table.getSelectedRow(),5));
				txtsaat.setText((String) modelim.getValueAt(table.getSelectedRow(),6));
				txtbus.setText((String) modelim.getValueAt(table.getSelectedRow(),7));

			}
		});
		

	}
}
