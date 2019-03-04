package Modal;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class MonHoc {
private int Ma;
private byte[] Hinh;
private String HinhHienThi;
private String Ten;
private void ChuyenDoiBinaryImgTobase64()
{
	if(Hinh!=null)
	{			
		this.HinhHienThi=Base64.getEncoder().encodeToString(Hinh);
	}
}
public String getHinhHienThi() {
	return HinhHienThi;
}

public void setHinhHienThi(String hinhHienThi) {
	HinhHienThi = hinhHienThi;
}
public byte[] getHinh() {
	return Hinh;
}
public void setHinh(byte[] hinh) {
	this.Hinh = hinh;
	ChuyenDoiBinaryImgTobase64();
}
public MonHoc(int ma, byte[] hinh, String ten) {
	super();
	Ma = ma;
	Hinh = hinh;
	Ten = ten;
	setHinh(hinh); 
}
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
public static boolean ThemMonHoc(InputStream hinh,String ten)
{
	try {
		DBMain db=new DBMain();
		Connection c=db.getConnection();
		String querySQL="insert into MonHoc(Hinh,Ten)\r\n" + 
				"values(?,?)";
		PreparedStatement pstm=c.prepareStatement(querySQL);
		pstm.setBlob(1, hinh);
		pstm.setString(2, ten);
		if(pstm.executeUpdate()>0)
			return true;
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}
public static List<MonHoc> DanhSachMonHoc()
{

	try {
		List<MonHoc> lstMonHoc=new ArrayList<MonHoc>();
		DBMain db=new DBMain();
		String querySQL="select * from MonHoc";
		ResultSet rs=db.ExecuteQuery(querySQL);
		while(rs.next())
		{
			MonHoc mh=new MonHoc(rs.getInt("ma") ,rs.getBytes("hinh"),rs.getString("ten"));	
			lstMonHoc.add(mh);
		}
		return lstMonHoc;
	
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
public static MonHoc LayThongTinMonHoc(String ma)
{

	try {
		MonHoc monHoc=null;
		DBMain db=new DBMain();
		String querySQL="select * from MonHoc where ma=?";
		Connection c=db.getConnection();
		PreparedStatement pstm=c.prepareStatement(querySQL);
		pstm.setString(1, ma);
		ResultSet rs=pstm.executeQuery();
		while(rs.next())
		{
			monHoc=new MonHoc(rs.getInt("ma") ,rs.getBytes("hinh"),rs.getString("ten"));	
		}
		return monHoc;
	
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
public static boolean ChinhSua(String ma,InputStream hinh,String ten)
{
	Connection c=null;
	boolean flag=false;
	try {
		
		DBMain db=new DBMain();
		String querySQL="";
		c=db.getConnection();
		PreparedStatement pstm=null;
		
		try {
			if(hinh.available()==0)
			{
				querySQL="update MonHoc set Ten=? where Ma=?";
				pstm=c.prepareStatement(querySQL);
				pstm.setString(1, ten);
				pstm.setString(2, ma);
			
			}
			else
			{
				querySQL="update MonHoc set Hinh=?,Ten=? where Ma=?";
				pstm=c.prepareStatement(querySQL);
				pstm.setBlob(1, hinh);
				pstm.setString(2, ten);
				pstm.setString(3, ma);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		if(pstm.executeUpdate()>0)
		{
			flag= true;
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
	return flag;
}
public static MonHoc LayMonHocQuaMaCauHoi(int maCauHoi)
{
	MonHoc monHoc=null;
	Connection c=null;
	try {
		
		DBMain db=new DBMain();
		String querySQL="select ten,monhoc.ma,monhoc.hinh from monhoc,cauhoi where monhoc.ma = cauhoi.mamon and cauhoi.ma=?";
		c=db.getConnection();
		PreparedStatement pstm=c.prepareStatement(querySQL);
		pstm.setInt(1, maCauHoi);
		ResultSet rs=pstm.executeQuery();
		while(rs.next())
		{
			monHoc=new MonHoc(rs.getInt("ma") ,rs.getBytes("hinh"),rs.getString("ten"));	
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
	return monHoc;
}
}
