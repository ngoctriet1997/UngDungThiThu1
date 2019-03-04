package Modal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ThiSinh {
	private int ma;
	private String sdt;
	private String ten;
	private String matKhau;
	public ThiSinh(int ma, String sdt, String ten, String matKhau) {
		super();
		this.ma = ma;
		this.sdt = sdt;
		this.ten = ten;
		this.matKhau = matKhau;
	}
	public int getMa() {
		return ma;
	}
	public void setMa(int ma) {
		this.ma = ma;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public static ThiSinh getStudentInfo(int studentId )
	{
		ThiSinh ls = null;
		DBMain db=null;
		Connection c=null;
		try {
			db = new DBMain();
			c=db.getConnection();
			Statement st= c.createStatement();
			ResultSet rs=st.executeQuery("Select * from thisinh where Ma='"+studentId+"'");
			while(rs.next())
			{
				 ls= new ThiSinh(rs.getInt("Ma"),rs.getString("SoDienThoai"),rs.getString("Ten"),rs.getString("MatKhau"));
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
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
	public static boolean DangNhap(int ma,String matKhau )
	{
		
		DBMain db=null;
		Connection c=null;
		boolean flag=false;
		try {
			db = new DBMain();
			c=db.getConnection();
			Statement st=c.createStatement();
			ResultSet rs= st.executeQuery("Select * from thisinh where Ma="+ma+" and matkhau='"+matKhau+"'");
			while(rs.next())
			{
				flag= true;
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
	
		return flag;
	}
	public static List<ThiSinh> LayDanhSachThiSinh()
	{
		ThiSinh ts;
		List<ThiSinh> lst=new ArrayList<>();
		DBMain db=null;
		Connection c=null;
		try {
			db = new DBMain();
			String queryLayDanhSach="select * from thisinh";
			Statement st=c.createStatement();
			ResultSet rs= st.executeQuery(queryLayDanhSach);
			while(rs.next())
			{
				ts =new ThiSinh(rs.getInt("ma"),rs.getString("soDienThoai") ,rs.getString("ten"), rs.getString("matkhau"));
				lst.add(ts);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
	
}
