package Modal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CauTraLoi {
private int Ma;
private String NoiDungCauHoi;
private int MaCauHoi;
public int getMa() {
	return Ma;
}
public void setMa(int ma) {
	Ma = ma;
}
public CauTraLoi(int ma, String noiDungCauHoi, int maCauHoi) {
	super();
	Ma = ma;
	NoiDungCauHoi = noiDungCauHoi;
	MaCauHoi = maCauHoi;
}
public String getNoiDungCauHoi() {
	return NoiDungCauHoi;
}
public void setNoiDungCauHoi(String noiDungCauHoi) {
	NoiDungCauHoi = noiDungCauHoi;
}
public int getMaCauHoi() {
	return MaCauHoi;
}
public void setMaCauHoi(int maCauHoi) {
	MaCauHoi = maCauHoi;
}
public static List<CauTraLoi> DanhSachCauTraLoi()
{
	Connection c=null;
	List<CauTraLoi> lstMonHoc=new ArrayList<CauTraLoi>();
	try {
		
		DBMain db=new DBMain();
		c=db.getConnection();
		String querySQL="select * from cautraloi";
		Statement st=c.createStatement();
	
		ResultSet rs=st.executeQuery(querySQL);
		while(rs.next())
		{
			CauTraLoi mh=new CauTraLoi(rs.getInt("ma"), rs.getString("noidung"), rs.getInt("macauhoi"));				
			lstMonHoc.add(mh);
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
	return lstMonHoc;
}
public static List<CauTraLoi> LayThongTinCauTraLoiTheoCauHoi(int maCauHoi)
{
	Connection c=null;
	List<CauTraLoi> lstcauTraLoi=new ArrayList<>();
	try {
		CauTraLoi cauHoiTraLoi=null;
		
		DBMain db=new DBMain();
		c=db.getConnection();
		String querySQL="select * from cautraloi where macauhoi=?;";
		PreparedStatement pstm=c.prepareStatement(querySQL);
		pstm.setInt(1, maCauHoi);
		ResultSet rs=pstm.executeQuery();
		while(rs.next())
		{
			cauHoiTraLoi=new CauTraLoi(rs.getInt("ma"), rs.getString("NoiDung"), rs.getInt("MaCauHoi"));	
			lstcauTraLoi.add(cauHoiTraLoi);
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
	return lstcauTraLoi;
}
}
