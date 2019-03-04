package Modal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhomThi {
	private int Ma;
	private String Ten;
	public int getMa() {
		return Ma;
	}
	public void setMa(int ma) {
		Ma = ma;
	}
	public String getTen() {
		return Ten;
	}
	public void setTen(String ten) {
		Ten = ten;
	}
	public NhomThi(int ma, String ten) {
		super();
		Ma = ma;
		Ten = ten;
	}
	public static List<NhomThi> LayDanhSachNhomThi()
	{
		NhomThi nt;
		List<NhomThi> lst=new ArrayList<>();
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
		String queryLayDanhSach="select * from nhomthi";
		ResultSet rs= db.ExecuteQuery(queryLayDanhSach);
		try {
			while(rs.next())
			{
				nt =new NhomThi(rs.getInt("ma"),rs.getString("ten"));
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
