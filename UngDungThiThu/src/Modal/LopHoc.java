package Modal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class LopHoc {

	private int ma;
	private String ten;
	public LopHoc(int ma, String ten) {
		super();
		this.ma = ma;
		this.ten = ten;
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
	public static List<LopHoc> getListClass(int studentId )
	{
		List<LopHoc> ls= new ArrayList<LopHoc>();
		DBMain db=null;
		Connection c=null;
		try {
			db = new DBMain();
			c=db.getConnection();
			Statement st=c.createStatement();
			ResultSet rs= st.executeQuery("select nhomthi.Ma,nhomthi.Ten from nhomthi,thisinhtrongnhomthi where "
					+ "thisinhtrongnhomthi.MaThiSinh='"+studentId+"' and thisinhtrongnhomthi.MaNhomThi=nhomthi.ma" );
			while(rs.next())
			{
				LopHoc lh= new LopHoc(rs.getInt("Ma"),rs.getString("ten"));
				ls.add(lh);
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
}
