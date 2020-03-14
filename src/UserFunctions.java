import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserFunctions extends Baglanti {
	
	Baglanti baglanti = new Baglanti();

	public Connection con = baglanti.getCon();
	public Statement st = baglanti.getStatement();
	public PreparedStatement ps = baglanti.getPreparedStatement();
	

	//-----göko----
	 public ResultSet biletListele(String pnr) {
	    	ResultSet rs = null;
	        try {
	        	String sorgu = "select * from ticket where pnr=?";
	        	ps = con.prepareStatement(sorgu);
	        	ps.setString(1, pnr);
	        	rs =ps.executeQuery();
	        	
	        } catch (SQLException e) {
	        		System.out.println("Kullanýcý Listeleme Hatasý");
	        }
	        return rs;
	 }
	//-----göko----
	 
	 
	 
	//-----göko----
	    public void musteriduzenle(int id,String nereden2,String nereye2,String bus,String date,String time,int price,String TC,String name,String sex,int seat,String pnr,int stat) {
	    	String sorgu1="UPDATE ticket SET nereden=?,nereye=?,bus=?,date=?,time=?,price=?,TC=?,name=?,sex=?,seat=?,pnr=?,stat=? where id=?";
	    	try {
	    		ps=con.prepareStatement(sorgu1);
	            ps.setString(1, nereden2);
	            ps.setString(2,nereye2);
	            ps.setString(3,bus);
	            ps.setString(4,date);
	            ps.setString(5,time);
	            ps.setInt(6, price);
	            ps.setString(7,TC);
	            ps.setString(8, name);
	            ps.setString(9, sex);
	            ps.setInt(10, seat);
	            ps.setString(11, pnr);
	            ps.setInt(12, stat);
	            ps.setInt(13, id);
	            ps.executeUpdate();
	    		
	    	}catch(SQLException e) {
	    		System.out.println("Güncelleme hatasý");
	    		e.printStackTrace();
	    	}
	    }
	  //-----göko----
	    
	    
	    
	  //-----göko---- 
	    public void biletiptal(int id) {
	    	String sorgu1="UPDATE ticket SET stat=0 where id=?";
	    	try {
	    		ps=con.prepareStatement(sorgu1);
	            ps.setInt(1, id);
	            ps.executeUpdate();
	    		
	    	}catch(SQLException e) {
	    		System.out.println("Güncelleme hatasý");
	    		e.printStackTrace();
	    	}
	    }
	 
	  //-----beko----
	public ResultSet seferSorgula(String nereden,String nereye,String tarih) {
		ResultSet rs=null;
		try {
			String sorgu = "select * from travel where nereden=? and nereye=? and date=?";
			ps = con.prepareStatement(sorgu);
			ps.setString(1, nereden);
			ps.setString(2, nereye);
			ps.setString(3, tarih);
			rs = ps.executeQuery();
		}catch(SQLException e){
			System.out.println("Sefer Sorgulama Hatasý");
		}
		return rs;
	}
	 //-----beko----
	
    public int koltukSayisi(String model) {
		int koltuksayisi=0;
		ResultSet rs = null;
		String sorgu = "select seat from bus where model=?";
		try {
			ps = con.prepareStatement(sorgu);
			ps.setString(1, model);
			rs = ps.executeQuery();
			if (rs.next()) {
				koltuksayisi = rs.getInt("seat");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return koltuksayisi;
	}
    
    
    public Boolean biletBul(String otobus, String date, Integer seat) {
    	ResultSet rs = null;
        try {
        	String sorgu = "select * from ticket where bus=? and date=? and seat=?";
        	ps = con.prepareStatement(sorgu);
        	ps.setString(1, otobus);
        	ps.setString(2, date);
        	ps.setString(3, String.valueOf(seat));
        	rs = ps.executeQuery();
        	
	        if (rs.next() && rs.getInt("stat")==1) {
	        	return true;
	        }
	    
	        /* else {
	        	return false;
	        } */
        } catch (SQLException e) {
        	System.out.println("Bilet Bulma Hatasý");
        }
        return false;
    }
    
    /* public void KullaniciEkle(String name,String username,String password,String phone,String email,String question,String answer) {
    	int stat = 0;
    	String sorgu = "insert into user (name,phone,email,username,password,answer,question,stat) values (?,?,?,?,?,?,?,?)";
    	try {
			preparedStatement = con.prepareStatement(sorgu);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, phone);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, username);
			preparedStatement.setString(5, password);
			preparedStatement.setString(6, answer);
			preparedStatement.setString(7, question);
			preparedStatement.setInt(8, stat);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Kullanýcý ekleme hatasý");
		}
    } */
    
    
    public void biletAl(String nereden,String nereye,String bus,String date,String time,int price,String TC,String name,String sex,int seat,String pnr,int stat) {
    	String sorgu = "insert into ticket (nereden,nereye,bus,date,time,price,TC,name,sex,seat,pnr,stat) values (?,?,?,?,?,?,?,?,?,?,?,?)";
    	try {
			ps = con.prepareStatement(sorgu);
			ps.setString(1, nereden);
			ps.setString(2, nereye);
			ps.setString(3, bus);
			ps.setString(4, date);
			ps.setString(5, time);
			ps.setInt(6, price);
			ps.setString(7, TC);
			ps.setString(8, name);
			ps.setString(9, sex);
			ps.setInt(10, seat);
			ps.setString(11, pnr);
			ps.setInt(12, stat);
			ps.executeUpdate();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Bilet alma hatasý");
		}
    	
    }
}
