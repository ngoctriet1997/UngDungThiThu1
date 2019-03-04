package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model1.CauHoi;
import Model1.CauTraLoi;



public class CauTraLoiMapper {
	
	public CauTraLoi getCauTraLoi(ResultSet rs) throws SQLException {
		CauTraLoi temp=null;
		while(rs.next()) {
			int ma=rs.getInt("Ma");
			String noidung=rs.getString("NoiDung");
			int macauhoi=rs.getInt("MaCauHoi");
			temp=new CauTraLoi(ma,noidung,macauhoi);
			}
		return temp;
	}
	
	public ArrayList<CauTraLoi> getListCauTraLoi(ResultSet rs) throws SQLException{
		ArrayList<CauTraLoi> temp=new ArrayList<CauTraLoi>();
		while(rs.next()) {
			int ma=rs.getInt("Ma");
			String noidung=rs.getString("NoiDung");
			int macauhoi=rs.getInt("MaCauHoi");
			
			temp.add(new CauTraLoi(ma,noidung,macauhoi));
		}
		return temp;
	}

	
}
