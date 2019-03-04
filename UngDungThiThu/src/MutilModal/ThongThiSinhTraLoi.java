package MutilModal;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;

import Modal.BangDiem;
import Modal.DBMain;
import Modal.MonHoc;
@SuppressWarnings("serial")

public class ThongThiSinhTraLoi implements Serializable {
private List<CauHoiVaCauTraLoi> ThongTinCauTraLoi;
private int MaDeThi;
private int MaThiSinh;
private Timestamp ThoiGianBatDauLamBai;



public ThongThiSinhTraLoi(List<CauHoiVaCauTraLoi> thongTinCauTraLoi, int maDeThi, int maThiSinh,
		Timestamp thoiGianBatDauLamBai, Timestamp thoiGianNopBai) {
	super();
	ThongTinCauTraLoi = thongTinCauTraLoi;
	MaDeThi = maDeThi;
	MaThiSinh = maThiSinh;
	ThoiGianBatDauLamBai = thoiGianBatDauLamBai;
	ThoiGianNopBai = thoiGianNopBai;
}
public List<CauHoiVaCauTraLoi> getThongTinCauTraLoi() {
	return ThongTinCauTraLoi;
}
public void setThongTinCauTraLoi(List<CauHoiVaCauTraLoi> thongTinCauTraLoi) {
	ThongTinCauTraLoi = thongTinCauTraLoi;
}
public int getMaDeThi() {
	return MaDeThi;
}
public void setMaDeThi(int maDeThi) {
	MaDeThi = maDeThi;
}
public int getMaThiSinh() {
	return MaThiSinh;
}
public void setMaThiSinh(int maThiSinh) {
	MaThiSinh = maThiSinh;
}
public Timestamp getThoiGianBatDauLamBai() {
	return ThoiGianBatDauLamBai;
}
public void setThoiGianBatDauLamBai(Timestamp thoiGianBatDauLamBai) {
	ThoiGianBatDauLamBai = thoiGianBatDauLamBai;
}
public Timestamp getThoiGianNopBai() {
	return ThoiGianNopBai;
}
public void setThoiGianNopBai(Timestamp thoiGianNopBai) {
	ThoiGianNopBai = thoiGianNopBai;
}
private Timestamp ThoiGianNopBai;
// lấy thông tin đề thi thí sinh
public static ThongThiSinhTraLoi LayThongTinMonHoc(int maDeThi,int maThiSinh)
{
	List<CauHoiVaCauTraLoi> lst=new ArrayList<>();
	ThongThiSinhTraLoi thongtin=new ThongThiSinhTraLoi(new ArrayList<CauHoiVaCauTraLoi>(), 0, 0, null, null);
	Connection c=null;
	try {
		CauHoiVaCauTraLoi tt;
		DBMain db=new DBMain();
		String querySQL=" call LayDanhSachThongTinTraLoiCuaThiSinhThongQuaMaDe(?,?)";
		 c=db.getConnection();
		PreparedStatement pstm=c.prepareStatement(querySQL);
		pstm.setInt(1, maDeThi);
		pstm.setInt(2, maThiSinh);
		ResultSet rs=pstm.executeQuery();
		int i=0;
		while(rs.next())
		{
			if(i==0)
			{
				thongtin.MaDeThi=rs.getInt("madethi");
				thongtin.MaThiSinh=rs.getInt("mathisinh");
				thongtin.ThoiGianBatDauLamBai=rs.getTimestamp("thoigianbatdau");
				thongtin.ThoiGianNopBai=rs.getTimestamp("thoigianketthuc");
			}
			i++;
			tt=new CauHoiVaCauTraLoi(rs.getInt("macauhoi"), rs.getInt("macautraloi"));
			
			lst.add(tt);
		}
		thongtin.ThongTinCauTraLoi=lst;
		
	
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
	return thongtin;
}
// thông tin đề thi thí sinh
public static List<CauHoiVaCauTraLoi> LayThongTinDeThi(int maDeThi,int maThiSinh)
{
	List<CauHoiVaCauTraLoi> lst=new ArrayList<>();
	Connection c=null;
	try {
	
		CauHoiVaCauTraLoi tt;
		DBMain db=new DBMain();
		c=db.getConnection();
		String querySQL="call LayDanhSachThongTinTraLoiCuaThiSinhThongQuaMaDe(?,?)";
		PreparedStatement pstm=c.prepareStatement(querySQL);
		pstm.setInt(1, maDeThi);
		pstm.setInt(2, maThiSinh);
		ResultSet rs=pstm.executeQuery();

		while(rs.next())
		{			
			tt=new CauHoiVaCauTraLoi(rs.getInt("macauhoi"), rs.getInt("macautraloi"));			
			lst.add(tt);
			
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
public static Timestamp CapNhatThoiGianBatDauLamBai(int maDethi,int maThiSinh)
{
	DBMain db=null;
	Connection c=null;
	Timestamp thoigian=null;
	long thoiGianLamBaiThucSu=0;
	try {
		db = new DBMain();
		String querySQL="call CapNhatThoiGianBatDauLamBai(?,?)";
		 c=db.getConnection();
		PreparedStatement pstm=null;
		pstm = c.prepareCall(querySQL);
		pstm.setInt(1, maDethi);
		pstm.setInt(2, maThiSinh);
		ResultSet rs= pstm.executeQuery();
		while(rs.next())
		{
			thoigian= rs.getTimestamp("thoigianbatdau");
		}
		//mathisinh,madethi,thoigianbatdaulam
		System.out.println("Thoi gian bat dau: "+ thoigian);
		String querySQL1="call tinhthoigianhetgiolambai(?,?,'"+thoigian+"');";
		PreparedStatement pstm1=null;
		pstm1=c.prepareCall(querySQL1);
		pstm1.setInt(1, maThiSinh);
		pstm1.setInt(2,  maDethi);
		
		ResultSet rs1= pstm1.executeQuery();
		rs1.next();
		thoiGianLamBaiThucSu=rs1.getLong(1);
		System.out.println("thoigianlambaithucsu: "+rs1.getLong(1));
		// tao sự kiệndasdsa
		String nameSuKien="sukien"+maThiSinh+maDethi;
		String querySQL2="CREATE EVENT IF NOT EXISTS  "+ nameSuKien +"\r\n" + 
				"	ON SCHEDULE \r\n" + 
				"	AT CURRENT_TIMESTAMP + interval "+ thoiGianLamBaiThucSu +" second\r\n" + 
				"	DO \r\n" + 
				"	call Nopbai(?,?);";// mathisinh,madethi
		PreparedStatement pstm2=null;
		pstm2=c.prepareStatement(querySQL2);
		pstm2.setInt(1, maThiSinh);
		pstm2.setInt(2,  maDethi);
		pstm2.execute();
		System.out.println(querySQL2);
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
public static boolean CapNhatBangDiemChoBangAo(int maDeThi,int maThiSinh,int maCauHoi,int maCauTraLoi)
{
	Connection c=null;
	boolean flag=false;
	try {
		
		DBMain db=new DBMain();
		String querySQL=" call CapNhatBangDiemAo(?,?,?,?)";
		c=db.getConnection();
		PreparedStatement pstm=c.prepareCall(querySQL);
		pstm.setInt(1, maDeThi);
		pstm.setInt(2, maThiSinh);
		pstm.setInt(3, maCauHoi);
		pstm.setInt(4, maCauTraLoi);
		flag= pstm.executeUpdate()>0;
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
public static boolean KiemTraSoLanThi(int maDeThi,int maThiSinh)
{
	Connection c=null;
	boolean flag=false;
	try {
		
		DBMain db=new DBMain();
		String querySQL="select KiemSoLanThiCuaThiSinhTheoDeThi(?,?);"; // mathisinh,madethi
		c=db.getConnection();
		PreparedStatement pstm=c.prepareStatement(querySQL);
		pstm.setInt(1, maThiSinh);
		pstm.setInt(2, maDeThi);
	
		ResultSet rs= pstm.executeQuery();
		rs.next();
		
		flag= rs.getInt(1)>0;
		
	
	
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
public static boolean NopBai(int maThiSinh,int maDeThi)
{
	Connection c=null;
	boolean flag=false;
	try {
		 
		DBMain db=new DBMain();
		String querySQL="CALL NopBai(?,?);"; // mathisinh,madethi
		 c=db.getConnection();
		PreparedStatement pstm=c.prepareCall(querySQL);
		pstm.setInt(1, maThiSinh);
		pstm.setInt(2, maDeThi);
		flag= pstm.executeUpdate()>0;		
	
	} 
	catch (ClassNotFoundException e) {
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
}
