package Modal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class CauHoi {
private int Ma;
private String NoiDung;
private int MaMon;
private int MaMucMon;
private int MaCauTraLoi;
private List<CauTraLoi> CacCauTraLoi;
private String TenMon;
public int getMa() {
	return Ma;
}
public void setMa(int ma) {
	Ma = ma;
}
public String getNoiDung() {
	return NoiDung;
}
public void setNoiDung(String noiDung) {
	NoiDung = noiDung;
}
public int getMaMon() {
	return MaMon;
}
public void setMaMon(int maMon) {
	MaMon = maMon;
}
public int getMaMucMon() {
	return MaMucMon;
}
public void setMaMucMon(int maMucMon) {
	MaMucMon = maMucMon;
}
public int getMaCauTraLoi() {
	return MaCauTraLoi;
}
public void setMaCauTraLoi(int maCauTraLoi) {
	MaCauTraLoi = maCauTraLoi;
}
public List<CauTraLoi> getCacCauTraLoi() {
	return CacCauTraLoi;
}
public void setCacCauTraLoi(List<CauTraLoi> cacCauTraLoi) {
	CacCauTraLoi = cacCauTraLoi;
}
public String getTenMon() {
	return TenMon;
}
public void setTenMon(String tenMon) {
	TenMon = tenMon;
}
public CauHoi(int ma, String noiDung, int maMon, int maMucMon, int maCauTraLoi, List<CauTraLoi> cacCauTraLoi,
		String tenMon) {
	super();
	Ma = ma;
	NoiDung = noiDung;
	MaMon = maMon;
	MaMucMon = maMucMon;
	MaCauTraLoi = maCauTraLoi;
	CacCauTraLoi = cacCauTraLoi;
	TenMon = tenMon;
}

public static boolean Them(List<String> danhSachCauTraLoiSai,CauHoi cauHoi,String cauTraLoiDung)
{
	Connection c=null;
	boolean flag=false;
	try {
		DBMain db=new DBMain();
		String querySQL1="insert into CauHoi(NoiDung,MaMon,MaMucDo,MaCauTraLoiDung)\r\n" + 
				"values(\r\n" + 
				"	?,?,?,null\r\n" + 
				");";
		c=db.getConnection();
		c.setAutoCommit(false);
		PreparedStatement pstm1=c.prepareStatement(querySQL1,Statement.RETURN_GENERATED_KEYS);
		pstm1.setString(1, cauHoi.getNoiDung());
		pstm1.setString(2,String.valueOf(cauHoi.getMaMon()));
		pstm1.setString(3, String.valueOf(cauHoi.getMaMucMon()));
		pstm1.executeUpdate();
		ResultSet rs=pstm1.getGeneratedKeys();
		int maCauHoi=0;
		if(rs.next())
		{
			maCauHoi=rs.getInt(1);
		}
		//cau tra loi sai
		for(String cauTraLoi:danhSachCauTraLoiSai)
		{
			String querySQL2=
					
					"insert into CauTraLoi(NoiDung,MaCauHoi)\r\n" + 
					"values(?,?);";
			PreparedStatement pstm2=c.prepareStatement(querySQL2);
			pstm2.setString(1, cauTraLoi);
			pstm2.setInt(2, maCauHoi);
			pstm2.executeUpdate();
		}
		//cau tra loi dung
		String querySQL3="insert into CauTraLoi(NoiDung,MaCauHoi)\r\n" + 
								"values(?,?);";
		PreparedStatement pstm3=c.prepareStatement(querySQL3,Statement.RETURN_GENERATED_KEYS);
		pstm3.setString(1, cauTraLoiDung);
		pstm3.setInt(2, maCauHoi);
		pstm3.executeUpdate();
		ResultSet rs3=pstm3.getGeneratedKeys();
		int maCauTraLoiDung=0;
		if(rs3.next())
		{
			maCauTraLoiDung=rs3.getInt(1);
		}
		//cap nhat cau tra loi dung vao cau hoi
		String querySQL4="update CauHoi set MaCauTraLoiDung=? where Ma=?";
		PreparedStatement pstm4=c.prepareStatement(querySQL4);
		pstm4.setInt(1, maCauTraLoiDung);
		pstm4.setInt(2, maCauHoi);
		pstm4.executeUpdate();
		c.commit();
		System.out.println("ok");
		flag= true;
//		ResultSet rs=db.ExecuteQuery(querySQL)
	
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		try {
			c.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
public static List<CauHoi> DanhSachCauHoi()
{
	List<CauHoi> lstMonHoc=new ArrayList<CauHoi>();
	Connection c=null;
	try {
	
		DBMain db=new DBMain();
		String querySQL="select cauhoi.ma,cauhoi.noidung,cauhoi.mamucdo,cauhoi.macautraloidung,monhoc.ten as tenmon,"
				+ "cauhoi.mamon as mamon from cauhoi left outer join monhoc on mamon=monhoc.Ma";
		c=db.getConnection();
		
		PreparedStatement pstm=c.prepareStatement(querySQL);
		ResultSet rs=pstm.executeQuery();
		while(rs.next())
		{
			CauHoi mh=new CauHoi(rs.getInt("ma"),rs.getString("noidung"),rs.getInt("maMon"),rs.getInt("maMucdo"),rs.getInt("maCauTraLoidung")
					, null,rs.getString("tenMon"));
					
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
public static CauHoi LayThongTinCauHoi(int ma)
{
	CauHoi cauHoi=null;
	Connection c=null;
	try {
		
		DBMain db=new DBMain();
		String querySQL="select * from cauhoi where ma=?;";
		c=db.getConnection();
		PreparedStatement pstm=c.prepareStatement(querySQL);
		pstm.setInt(1, ma);
		ResultSet rs=pstm.executeQuery();
		while(rs.next())
		{
		cauHoi=new CauHoi(rs.getInt("ma"),rs.getString("noidung"),rs.getInt("maMon"),rs.getInt("maMucdo"),rs.getInt("maCauTraLoidung")
					, null,null);		
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
	return cauHoi;
}
public static boolean Sua(List<CauTraLoi> danhSachCauTraLoi,CauHoi cauHoi)
{
	Connection c=null;
	boolean flag=false;
	try {
		DBMain db=new DBMain();
		String querySQL1="update CauHoi set noidung=?,macautraloidung=?,mamon=?,mamucdo=? where ma=?\r\n" ;
			
		c=db.getConnection();
		PreparedStatement pstm1=c.prepareStatement(querySQL1);
		pstm1.setString(1, cauHoi.getNoiDung());
		pstm1.setString(2,String.valueOf(cauHoi.getMaCauTraLoi()));
		pstm1.setInt(3, cauHoi.getMaMon());
		pstm1.setString(4,String.valueOf(cauHoi.getMaMucMon()));
		pstm1.setString(5,String.valueOf(cauHoi.getMa()));
		
		pstm1.executeUpdate();
		
		
		for(CauTraLoi cauTraLoi:danhSachCauTraLoi)
		{
			String querySQL2="update cautraloi set noidung=? where ma=?";
										
			PreparedStatement pstm2=c.prepareStatement(querySQL2);
			pstm2.setString(1, cauTraLoi.getNoiDungCauHoi());
			pstm2.setInt(2, cauTraLoi.getMa());
			pstm2.executeUpdate();
		}
		flag= true;
	
	
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		try {
			c.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
	System.out.println("false");
	return flag;
}

}
