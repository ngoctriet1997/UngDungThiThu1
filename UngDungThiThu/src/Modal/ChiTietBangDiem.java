package Modal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import MutilModal.LichSuThi;

public class ChiTietBangDiem {
private int MaBangDiem;
private int MaCauHoi;
private int MaCauTraLoiCuaThiSinh;
public ChiTietBangDiem(int maBangDiem, int maCauHoi, int maCauTraLoiCuaThiSinh) {
	super();
	MaBangDiem = maBangDiem;
	MaCauHoi = maCauHoi;
	MaCauTraLoiCuaThiSinh = maCauTraLoiCuaThiSinh;
}
public int getMaBangDiem() {
	return MaBangDiem;
}
public void setMaBangDiem(int maBangDiem) {
	MaBangDiem = maBangDiem;
}
public int getMaCauHoi() {
	return MaCauHoi;
}
public void setMaCauHoi(int maCauHoi) {
	MaCauHoi = maCauHoi;
}
public int getMaCauTraLoiCuaThiSinh() {
	return MaCauTraLoiCuaThiSinh;
}
public void setMaCauTraLoiCuaThiSinh(int maCauTraLoiCuaThiSinh) {
	MaCauTraLoiCuaThiSinh = maCauTraLoiCuaThiSinh;
}
public static List<ChiTietBangDiem> LayThongTinChiTietBangDiem(int maBangDiem)
{
	Connection c=null;
	List<ChiTietBangDiem> lst=new ArrayList<>();
	ChiTietBangDiem item=null;
	try {
		
		DBMain db=new DBMain();
		String querySQL="select * from chitietbangdiem where mabangdiem=?";
		c=db.getConnection();
		PreparedStatement pstm=c.prepareStatement(querySQL);
		pstm.setInt(1, maBangDiem);
	
		ResultSet rs= pstm.executeQuery();
		while(rs.next())
		{
			item=new ChiTietBangDiem(rs.getInt("maBangDiem"),rs.getInt("macauhoi"),rs.getInt("macautraloicuathisinh"));
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
