package MutilModal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import Modal.DBMain;

public class LichSuThi {
private Timestamp ThoiGianBatDau ;
private float Diem;
private int ThoiLuongDeThi ;
private String TenDeThi;
private int MaBangDiem;
private int MaDeThi;
public LichSuThi(Timestamp thoiGianBatDau, float diem, int thoiLuongDeThi, String tenDeThi, int maBangDiem,
		int maDeThi) {
	super();
	ThoiGianBatDau = thoiGianBatDau;
	Diem = diem;
	ThoiLuongDeThi = thoiLuongDeThi;
	TenDeThi = tenDeThi;
	MaBangDiem = maBangDiem;
	MaDeThi = maDeThi;
}
public Timestamp getThoiGianBatDau() {
	return ThoiGianBatDau;
}
public void setThoiGianBatDau(Timestamp thoiGianBatDau) {
	ThoiGianBatDau = thoiGianBatDau;
}
public float getDiem() {
	return Diem;
}
public void setDiem(float diem) {
	Diem = diem;
}
public int getThoiLuongDeThi() {
	return ThoiLuongDeThi;
}
public void setThoiLuongDeThi(int thoiLuongDeThi) {
	ThoiLuongDeThi = thoiLuongDeThi;
}
public String getTenDeThi() {
	return TenDeThi;
}
public void setTenDeThi(String tenDeThi) {
	TenDeThi = tenDeThi;
}
public int getMaBangDiem() {
	return MaBangDiem;
}
public void setMaBangDiem(int maBangDiem) {
	MaBangDiem = maBangDiem;
}
public int getMaDeThi() {
	return MaDeThi;
}
public void setMaDeThi(int maDeThi) {
	MaDeThi = maDeThi;
}
public static List<LichSuThi> LayTatCaThongTinBangDiem(int maThiSinh)
{
	Connection c=null;
	List<LichSuThi> lst=new ArrayList<>();
	LichSuThi item=null;
	try {
		
		DBMain db=new DBMain();
		String querySQL="  select bangdiem.thoigianbatdau,bangdiem.diem,dethi.thoigianlambai as thoiluongdethi,dethi.ten as tendethi,\r\n" + 
				" bangdiem.ma as mabangdiem,bangdiem.madethi \r\n" + 
				" from bangdiem left join dethi on bangdiem.madethi = dethi.ma\r\n" + 
				" where bangdiem.mathisinh=?\r\n" + 
				" ";
		c=db.getConnection();
		PreparedStatement pstm=c.prepareStatement(querySQL);
		pstm.setInt(1, maThiSinh);
	
		ResultSet rs= pstm.executeQuery();
		while(rs.next())
		{
			item=new LichSuThi(rs.getTimestamp("thoiGianBatDau"),rs.getFloat("diem"),rs.getInt("thoiLuongDeThi")
					,rs.getString("tenDeThi"),rs.getInt("maBangDiem"),rs.getInt("maDeThi"));
			lst.add(item);
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
}
