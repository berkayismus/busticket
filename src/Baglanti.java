
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.*;

public class Baglanti {
	
	private String kullanici_adi = "root";
	private String parola = "";
	private String db_ismi = "bus";
	private String host = "localhost";
	private int port = 3306;
	
	private Connection con = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public PreparedStatement getPreparedStatement() {
		return preparedStatement;
	}

	public void setPreparedStatement(PreparedStatement preparedStatement) {
		this.preparedStatement = preparedStatement;
	}

	
	// ------------------------------------- KULLANICI FONKSÝYONLARI - Göko ----------------------------------

    public void kullaniciGuncelle(int id,String name,String phone,String email,String username,String password,String answer,String question,int stat) {

                   String sorgu1 = "UPDATE user SET name=?,phone=?,email=?,username=?,password=?,answer=?,question=?,stat=? where id=?";

                   try {

                                   preparedStatement = con.prepareStatement(sorgu1);
                                   preparedStatement.setString(1, name);
                                   preparedStatement.setString(2,phone);
                                   preparedStatement.setString(3, email);
                                   preparedStatement.setString(4, username);
                                   preparedStatement.setString(5, password);
                                   preparedStatement.setString(6, answer);
                                   preparedStatement.setString(7, question);
                                   preparedStatement.setInt(8,stat);
                                   preparedStatement.setInt(9,id);
                                   preparedStatement.executeUpdate();

                   } catch (SQLException e) {
                	   System.out.println("Güncelleme hatasý");
                   }
    }

public void kullanicisil(int id) {
								String sorgu1 = "DELETE FROM user WHERE id=?";
                                   try {
                                	   preparedStatement = con.prepareStatement(sorgu1);
                                	   preparedStatement.setInt(1,id);
                                	   preparedStatement.executeUpdate();

                                   } catch (SQLException e) {

                                	   System.out.println("Kullanýcý Silme Hatasý");

                                   }
                   }

	

	public boolean login(String username,String password) {
		String sorgu = "select * from user where username=? and password=?";
		try {
			preparedStatement = con.prepareStatement(sorgu);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public int statControl(String username) {
		String sorgu = "select stat from user where username=?";
		int stat = 0;
		try {
			preparedStatement = con.prepareStatement(sorgu);
			preparedStatement.setString(1, username);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) 
				stat = rs.getInt("stat");
				//if(stat==1) return 1;
				//else if(stat==0) return 0;
				//else return 2;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("statControl hatasý");
		}
		return stat;
	}
	
    public ResultSet kullaniciListele() {
    	ResultSet rs = null;
        try {
        	statement = con.createStatement();
        	rs = statement.executeQuery("select * from user");
        	
        } catch (SQLException e) {
        		System.out.println("Kullanýcý Listeleme Hatasý");
        }
        return rs;
}
    
    public void KullaniciEkle(String name,String username,String password,String phone,String email,String question,String answer) {
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
    }
    
    

	

	
	// ------------------------------- OTOBÜS FONKSÝYONLARI - Beko --------------------------------------
	
	public ResultSet otobusListele() {
		ResultSet rs = null;
		try {
			statement = con.createStatement();
			rs = statement.executeQuery("select * from bus");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public void otobusEkle(String model,String plaka,int koltuk) {
		String sorgu = "insert into bus (model,plaka,seat) values (?,?,?)";
		try {
			preparedStatement = con.prepareStatement(sorgu);
			preparedStatement.setString(1,model);
			preparedStatement.setString(2, plaka);
			preparedStatement.setInt(3, koltuk);
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void otobusGuncelle(int id,String model,String plaka,int seat) {
		String sorgu1 = "UPDATE bus SET model=? , plaka=? , seat=? where id=?";
		try {
			preparedStatement = con.prepareStatement(sorgu1);
			preparedStatement.setString(1, model);
			preparedStatement.setString(2, plaka);
			preparedStatement.setInt(3, seat);
			preparedStatement.setInt(4, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Güncelleme hatasý");
		}
	}
	
	public void otobusSil(int id) {
		String sorgu = "delete from bus where id=?";
		try {
			preparedStatement = con.prepareStatement(sorgu);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Silme hatasý");
		}
	}
	
	//---------------------- SEFER ÝÞLEMLERÝ - GÖKO -------------------------
	
    public void seferduzenle(int id,String nereden,String nereye,int price,String route,String date,String time,String bus) {
    	String sorgu1="UPDATE travel SET nereden=?,nereye=?,price=?,route=?,date=?,time=?,bus=? where id=?";
    	try {
    		preparedStatement = con.prepareStatement(sorgu1);
            preparedStatement.setString(1, nereden);
            preparedStatement.setString(2,nereye);
            preparedStatement.setInt(3, price);
            preparedStatement.setString(4, route);
            preparedStatement.setString(5, date);
            preparedStatement.setString(6, time);
            preparedStatement.setString(7, bus);
            preparedStatement.setInt(8, id);
            preparedStatement.executeUpdate();
    		
    	}catch(SQLException e) {
    		System.out.println("Güncelleme hatasý");
    	}
    }
	
	
	
	
	public void sefersil(int id) {
	String sorgu1 = "DELETE FROM travel WHERE id=?";
       try {
    	   preparedStatement = con.prepareStatement(sorgu1);
    	   preparedStatement.setInt(1,id);
    	   preparedStatement.executeUpdate();

       } catch (SQLException e) {

    	   System.out.println("Kullanýcý Silme Hatasý");

       }
}


//seferlistele
	public ResultSet seferlistele() {
		ResultSet rs=null;
		try {
			statement = con.createStatement();
			rs=statement.executeQuery("select * from travel");
		}catch(SQLException e){
			System.out.println("Sefer Listeleme Hatasý");
		}
		return rs;
	}
	
	public void SeferEkle(String nereden,String nereye,int price,String route,String date,String time,String bus) {

		   String sorgu = "insert into travel (nereden,nereye,price,route,date,time,bus) values (?,?,?,?,?,?,?)";

		         try {

		             preparedStatement = con.prepareStatement(sorgu);
		             preparedStatement.setString(1,nereden);
		             preparedStatement.setString(2,nereye );
		             preparedStatement.setInt(3, price);
		             preparedStatement.setString(4,route );
		             preparedStatement.setString(5,date );
		             preparedStatement.setString(6,time );
		             preparedStatement.setString(7,bus );
		             preparedStatement.executeUpdate();

		             } catch (SQLException e) {
		             System.out.println("Sefer ekleme hatasý");
		             }
		       }
	

	public Baglanti() {
		String url = "jdbc:mysql://" + host + ":" +port + "/" + db_ismi +"?useUnicode=true&characterEncoding=utf8";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException ex){
			System.out.println("Driver Bulunamadý");
		}
			
		try {
			con = DriverManager.getConnection(url,kullanici_adi,parola);
			//System.out.println("Baðlantý baþarýlý");
		} catch (SQLException e) {
			//System.out.println("Baðlantý baþarýsýz");
		}
		 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Baglanti baglanti = new Baglanti();
		//baglanti.getBus(1); 
		//baglanti.getUser(1);

	}

}
