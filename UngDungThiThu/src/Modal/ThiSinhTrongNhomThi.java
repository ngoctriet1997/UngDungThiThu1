package Modal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ThiSinhTrongNhomThi {
	private int MaThiSinh;
	private int MaNhomThi;
	public ThiSinhTrongNhomThi(int maThiSinh, int maNhomThi) {
		super();
		MaThiSinh = maThiSinh;
		MaNhomThi = maNhomThi;
	}
	public int getMaThiSinh() {
		return MaThiSinh;
	}
	public void setMaThiSinh(int maThiSinh) {
		MaThiSinh = maThiSinh;
	}
	public int getMaNhomThi() {
		return MaNhomThi;
	}
	public void setMaNhomThi(int maNhomThi) {
		MaNhomThi = maNhomThi;
	}
	public static List<ThiSinhTrongNhomThi> LayDanhSachTSNT()
	{
		ThiSinhTrongNhomThi nt;
		List<ThiSinhTrongNhomThi> lst=new ArrayList<>();
		DBMain db=null;
		Connection c=null;
		try {
			db = new DBMain();
			String queryLayDanhSach="select * from thisinhtrongnhomthi";
			c=db.getConnection();
			Statement st=c.createStatement();
			ResultSet rs= st.executeQuery(queryLayDanhSach);
				while(rs.next())
				{
					nt = new ThiSinhTrongNhomThi(rs.getInt("maThiSinh"),rs.getInt("maNhomThi"));
					lst.add(nt);
				}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		return lst; 
	}
		
		
	
	public static List<ThiSinhTrongNhomThi> LayDanhSachTSNT1()
	{
		ThiSinhTrongNhomThi nt;
		List<ThiSinhTrongNhomThi> lst=new ArrayList<>();
		DBMain db=null;
		try {
			db = new DBMain();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String queryLayDanhSach="select * from thisinhtrongnhomthi";
		ResultSet rs= db.ExecuteQuery(queryLayDanhSach);
		try {
			while(rs.next())
			{
				nt = new ThiSinhTrongNhomThi(rs.getInt("maThiSinh"),rs.getInt("maNhomThi"));
				lst.add(nt);
			}
			return lst;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}

}
