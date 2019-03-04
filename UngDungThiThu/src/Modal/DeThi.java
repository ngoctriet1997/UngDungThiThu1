package Modal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeThi {
	private int ma;
	private String ten;
	private int thoiGianLamBai;
	public DeThi(int ma, String ten, int thoiGianLamBai) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.thoiGianLamBai = thoiGianLamBai;
	}
	public static DeThi getStudentInfo(int ma)
	{
		DeThi ls = null;
		DBMain db=null;
		Connection c=null;
		try {
			db = new DBMain();
			c=db.getConnection();
			Statement st=c.createStatement();
			ResultSet rs= st.executeQuery("Select * from dethi where Ma='"+ma+"'");
			while(rs.next())
			{
				 ls= new DeThi(rs.getInt("Ma"),rs.getString("Ten"),rs.getInt("ThoiGianLamBai"));
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	finally {
		try {
			if(c!=null)
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		return ls;
	}
	public int getMa() {
		return ma;
	}
	public void setMa(int ma) {
		this.ma = ma;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getThoiGianLamBai() {
		return thoiGianLamBai;
	}
	public void setThoiGianLamBai(int thoiGianLamBai) {
		this.thoiGianLamBai = thoiGianLamBai;
	}
	
}
