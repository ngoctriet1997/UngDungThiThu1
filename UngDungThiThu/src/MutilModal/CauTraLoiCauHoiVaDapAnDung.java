package MutilModal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modal.DBMain;

public class CauTraLoiCauHoiVaDapAnDung {
private int MaCauHoi;
private int MaCauTraLoi;
public CauTraLoiCauHoiVaDapAnDung(int maCauHoi, int maCauTraLoi, int maDapAn) {
	super();
	MaCauHoi = maCauHoi;
	MaCauTraLoi = maCauTraLoi;
	MaDapAn = maDapAn;
}
private	int MaDapAn;
public int getMaCauHoi() {
	return MaCauHoi;
}
public void setMaCauHoi(int maCauHoi) {
	MaCauHoi = maCauHoi;
}
public int getMaCauTraLoi() {
	return MaCauTraLoi;
}
public void setMaCauTraLoi(int maCauTraLoi) {
	MaCauTraLoi = maCauTraLoi;
}
public int getMaDapAn() {
	return MaDapAn;
}
public void setMaDapAn(int maDapAn) {
	MaDapAn = maDapAn;
}
public static List<CauTraLoiCauHoiVaDapAnDung> LayTatCaDapAnTheoMaDe(int maDeThi)
{
	Connection c=null;
	List<CauTraLoiCauHoiVaDapAnDung> lst=new ArrayList<>();
	CauTraLoiCauHoiVaDapAnDung item=null;
	try {
		 
		DBMain db=new DBMain();
		String querySQL=" call LayThongTinCauHoiVaDapAnTheoMaDe(?)"; // madethi
		 c=db.getConnection();
		PreparedStatement pstm=c.prepareCall(querySQL);
		pstm.setInt(1, maDeThi);
	
		ResultSet rs= pstm.executeQuery();	
		while(rs.next())
		{
			item=new CauTraLoiCauHoiVaDapAnDung(rs.getInt("ma"),0, rs.getInt("macautraloidung"));
			lst.add(item);
		}
	
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
	return lst;
}
}
