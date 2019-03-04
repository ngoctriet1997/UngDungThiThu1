package Modal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeThiTrongLopHoc {


private int maDe;
private int maNhom;
private java.sql.Timestamp thoiGianBatDau;
private java.sql.Timestamp thoiKetThuc;
private String ten;
private int thoiLuong;
private int soLanThi;
private int soLanDaThi;
public int getSoLanDaThi() {
	return soLanDaThi;
}
public void setSoLanDaThi(int soLanDaThi) {
	this.soLanDaThi = soLanDaThi;
}
public int getSoLanThi() {
	return soLanThi;
}
public void setSoLanThi(int soLanThi) {
	this.soLanThi = soLanThi;
}
public int getMaDe() {
	return maDe;
}
public void setMaDe(int maDe) {
	this.maDe = maDe;
}
public int getMaNhom() {
	return maNhom;
}
public void setMaNhom(int maNhom) {
	this.maNhom = maNhom;
}
public java.util.Date getThoiGianBatDau() {
	return thoiGianBatDau;
}
public void setThoiGianBatDau(java.sql.Timestamp thoiGianBatDau) {
	this.thoiGianBatDau = thoiGianBatDau;
}
public java.util.Date getThoiKetThuc() {
	return thoiKetThuc;
}
public void setThoiKetThuc(java.sql.Timestamp thoiKetThuc) {
	this.thoiKetThuc = thoiKetThuc;
}
public String getTen() {
	return ten;
}
public void setTen(String ten) {
	this.ten = ten;
}
public int getThoiLuong() {
	return thoiLuong;
}
public void setThoiLuong(int thoiLuong) {
	this.thoiLuong = thoiLuong;
}
public DeThiTrongLopHoc(int maDe, int maNhom, java.sql.Timestamp thoiGianBatDau, java.sql.Timestamp thoiKetThuc, String ten, int thoiLuong
		,int soLanThi,int soLanDaThi) {
	super();
	this.maDe = maDe;
	this.maNhom = maNhom;
	this.thoiGianBatDau = thoiGianBatDau;
	this.thoiKetThuc = thoiKetThuc;
	this.ten = ten;
	this.thoiLuong = thoiLuong;
	this.soLanThi=soLanThi;
	this.soLanDaThi=soLanDaThi;
}
public static List<DeThiTrongLopHoc> layThongTinDeThi(int maLop,int maThiSinh )
{
	List<DeThiTrongLopHoc> ls= new ArrayList<DeThiTrongLopHoc>();
	DBMain db=null;
	Connection c=null;
	try {
		db = new DBMain();
		c=db.getConnection();
		Statement st=c.createStatement();
		ResultSet rs= st.executeQuery("select bangdiem.solandathi,bangdiem.MaDeThi,MaLopHoc,dethilophoc.ThoiGianBatDau,dethilophoc.ThoiGianKetThuc,dethi.Ten,dethi.ThoiGianLamBai,solanthi from\r\n" + 
				"			 dethilophoc left join  dethi on dethi.ma =dethilophoc.madethi  \r\n" + 
				"             left join bangdiem on bangdiem.madethi=dethi.ma and bangdiem.mathisinh="+maThiSinh+"\r\n" + 
				"			where\r\n" + 
				"			dethilophoc.MaLopHoc="+maLop+"  and datediff(Now(),dethilophoc.ThoiGianBatDau) > -4 and\r\n" + 
				"			timeDIFF(Now(),dethilophoc.ThoiGianKetThuc)<0 \r\n" + 
				"");
		while(rs.next())
		{
			DeThiTrongLopHoc lh= new DeThiTrongLopHoc(rs.getInt("MaDeThi"),rs.getInt("MaLopHoc"),rs.getTimestamp("ThoiGianBatDau"),
					rs.getTimestamp("ThoiGianKetThuc"),rs.getString("Ten"),rs.getInt("ThoiGianLamBai"),rs.getInt("solanthi"),rs.getInt("solandathi"));
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
public static List<DeThiTrongLopHoc> layThongTinDeThiTrongKhoangTG(int maLop,int maThiSinh )
{
	List<DeThiTrongLopHoc> ls= new ArrayList<DeThiTrongLopHoc>();
	DBMain db=null;
	Connection c=null;
	try {
		db = new DBMain();
		c=db.getConnection();
		Statement st=c.createStatement();
		ResultSet rs= st.executeQuery("select bangdiem.solandathi,bangdiem.MaDeThi,MaLopHoc,dethilophoc.ThoiGianBatDau,dethilophoc.ThoiGianKetThuc,dethi.Ten,dethi.ThoiGianLamBai,solanthi from\r\n" + 
				"			 dethilophoc left join  dethi on dethi.ma =dethilophoc.madethi  \r\n" + 
				"             left join bangdiem on bangdiem.madethi=dethi.ma and bangdiem.mathisinh="+maThiSinh+" \r\n" + 
				"			where\r\n" + 
				"			dethilophoc.MaLopHoc="+maLop+"  and datediff(Now(),dethilophoc.ThoiGianBatDau) > -5 and \r\n" + 
				"			timeDIFF(Now(),dethilophoc.ThoiGianKetThuc)<0 \r\n" + 
				"");
		while(rs.next())
		{
			DeThiTrongLopHoc lh= new DeThiTrongLopHoc(rs.getInt("MaDeThi"),rs.getInt("MaLopHoc"),rs.getTimestamp("ThoiGianBatDau"),
					rs.getTimestamp("ThoiGianKetThuc"),rs.getString("Ten"),rs.getInt("ThoiGianLamBai"),rs.getInt("solanthi"),rs.getInt("solandathi"));
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
public static boolean Tao(int maDethi,int maLopHoc,String ngayMoDeThi,String ngayDongDeThi) 
{
	
	DBMain db=null;
	boolean flag=false;
	Connection c=null;
	try {
		db = new DBMain();
		c=db.getConnection();
		String queryTaoDeThiTrongLopHoc="insert into dethilophoc(madethi,malophoc,thoigianbatdau,thoigianketthuc)\r\n" + 
				"values("+maDethi+","+maLopHoc+",'"+ngayMoDeThi+"','"+ngayDongDeThi+"')";
		Statement st1=c.createStatement();
		st1.executeQuery(queryTaoDeThiTrongLopHoc);
		
		// tao su kien
		String tenSuKien=ngayMoDeThi.replace(" ", "")+ngayDongDeThi.replace(" ", "")+maLopHoc+maDethi;
		tenSuKien=tenSuKien.toLowerCase();
		
		String querySubmitKhiDongDeThi="delimiter //\r\n" + 
				"create EVENT " + tenSuKien +"t\r\n" + 
				"    ON SCHEDULE AT CURRENT_TIMESTAMP + INTERVAL ? second   \r\n" + 
				"    DO\r\n" + 
				"    begin\r\n" + 
				"		call  NopBaiKhiHetGio(?,?);\r\n" + 
				"	end ;//\r\n" + 
				"delimiter ;\r\n" ; 
		SimpleDateFormat format=new SimpleDateFormat("YYYY-MM-DD HH:MM:SS");
		Date ngayDongDe=null;
		Date ngayMoDe=null;
		try {
			ngayDongDe = format.parse(ngayDongDeThi);
			ngayMoDe= format.parse(ngayMoDeThi);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long thoiGianChoDeThi=ngayDongDe.getTime()-ngayMoDe.getTime();
		
		
		PreparedStatement pstm=null;
		
			pstm = c.prepareStatement(querySubmitKhiDongDeThi);
		
			pstm.setLong(1, thoiGianChoDeThi);
			pstm.setInt(2, maDethi);
			pstm.setInt(3, maLopHoc);
			flag= true;
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
}
