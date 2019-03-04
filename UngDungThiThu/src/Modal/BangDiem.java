package Modal;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;


public class BangDiem {
private int Ma;
private int MaDeThi;
private int MaThiSinh;
public BangDiem(int ma, int maDeThi, int maThiSinh, Timestamp thoiGianBatDau, Timestamp thoiGianKetThuc, float diem,
		int soLanDaThi) {
	super();
	Ma = ma;
	MaDeThi = maDeThi;
	MaThiSinh = maThiSinh;
	ThoiGianBatDau = thoiGianBatDau;
	ThoiGianKetThuc = thoiGianKetThuc;
	Diem = diem;
	SoLanDaThi = soLanDaThi;
}
public int getMaThiSinh() {
	return MaThiSinh;
}
public void setMaThiSinh(int maThiSinh) {
	MaThiSinh = maThiSinh;
}
private Timestamp ThoiGianBatDau;
public BangDiem(int ma, int maDeThi, Timestamp thoiGianBatDau, Timestamp thoiGianKetThuc, float diem, int soLanDaThi) {
	super();
	Ma = ma;
	MaDeThi = maDeThi;
	ThoiGianBatDau = thoiGianBatDau;
	ThoiGianKetThuc = thoiGianKetThuc;
	Diem = diem;
	SoLanDaThi = soLanDaThi;
}
public int getMa() {
	return Ma;
}
public void setMa(int ma) {
	Ma = ma;
}
public int getMaDeThi() {
	return MaDeThi;
}
public void setMaDeThi(int maDeThi) {
	MaDeThi = maDeThi;
}
public Timestamp getThoiGianBatDau() {
	return ThoiGianBatDau;
}
public void setThoiGianBatDau(Timestamp thoiGianBatDau) {
	ThoiGianBatDau = thoiGianBatDau;
}
public Timestamp getThoiGianKetThuc() {
	return ThoiGianKetThuc;
}
public void setThoiGianKetThuc(Timestamp thoiGianKetThuc) {
	ThoiGianKetThuc = thoiGianKetThuc;
}
public float getDiem() {
	return Diem;
}
public void setDiem(int diem) {
	Diem = diem;
}
public int getSoLanDaThi() {
	return SoLanDaThi;
}
public void setSoLanDaThi(int soLanDaThi) {
	SoLanDaThi = soLanDaThi;
}
private Timestamp ThoiGianKetThuc;
private float Diem;
private int SoLanDaThi;


public static long CapNhatSoLanThiVaThoiGianBatDau(int maThiSinh,int maDeThi)
{
	Connection c=null;
	long thoigian=0;
	try {
		
		DBMain db=new DBMain();
		String queryCheck="select thoigianbatdau from  BangDiem  where mathisinh=? and madethi=?";
		
		c=db.getConnection();
		PreparedStatement pstcheck=c.prepareStatement(queryCheck);
		pstcheck.setInt(1, maThiSinh);
		pstcheck.setInt(2, maDeThi);
		ResultSet rs=pstcheck.executeQuery();
		if(rs.next())
		{
			if(rs.getDate("thoigianbatdau")!=null)
			{
				  thoigian=rs.getDate("thoigianbatdau").getTime();
			}							
		}	
		else
		{
			String querySQL="update  BangDiem set thoigianbatdau=now() where mathisinh=? and madethi=?";
			PreparedStatement pstm=c.prepareStatement(querySQL);
			pstm.setInt(1, maThiSinh);
			pstm.setInt(2, maDeThi);
			if( pstm.executeUpdate()>0)
			{	
				
				thoigian= new Date().getTime();
			}
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
	return thoigian;
}
public static BangDiem LayThongTinBangDiemAo(int maThiSinh,int maDeThi)
{
	Connection c=null; 
	BangDiem bangDiem=null;
	try {
		
		DBMain db=new DBMain();
		c=db.getConnection();
	
		String queryCheck=" select BangDiemAo.*,solandathi from  BangDiemAo left join bangdiem on BangDiemAo.ma=bangdiem.ma\r\n" + 
				" where BangDiemAo.mathisinh=? and BangDiemAo.madethi=?";
		PreparedStatement pstm=c.prepareStatement(queryCheck);
		pstm.setInt(1, maThiSinh);
		pstm.setInt(2, maDeThi);
		ResultSet rs=pstm.executeQuery();
		while(rs.next())
		{
			bangDiem = new BangDiem(rs.getInt("ma"),rs.getInt("maDeThi"),rs.getTimestamp("thoiGianBatDau"),
					rs.getTimestamp("thoiGianKetThuc"),rs.getFloat("diem"),rs.getInt("soLanDaThi"))	;						
		}
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		
		{
			try {
				if(c!=null)
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	return bangDiem;
}
public static boolean CapNhatDiemVaThoiGianKetThuc(int maThiSinh,int maDeThi)
{
	Connection c=null; 
	boolean flag=false;
	try {
		String queryCheck="call CapNhatDiemVaThoiGianKetThuc(?,?)"; // mathisinh,madethi
		DBMain db=new DBMain();
		c=db.getConnection();
		PreparedStatement pstm=c.prepareCall(queryCheck);
		pstm.setInt(1, maThiSinh);
		pstm.setInt(2, maDeThi);
		
		flag=pstm.executeUpdate()>0;
	
	
		
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
public static void XoaSuKien(int maThiSinh,int maDeThi)
{
	String tenSuKien="sukien"+maThiSinh+maDeThi;
	Connection c=null;
	try {
		String queryCheck="drop event IF EXISTS " + tenSuKien; // mathisinh,madethi
		DBMain db=new DBMain();
		c=db.getConnection();
		PreparedStatement pstm=c.prepareStatement(queryCheck);
		pstm.execute();
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
	
}
}
