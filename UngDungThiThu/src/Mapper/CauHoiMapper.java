package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model1.CauHoi;



public class CauHoiMapper {
	
	public CauHoi getCauHoi(ResultSet rs) throws SQLException {
		CauHoi temp=null;
		while(rs.next()) {
			int ma=rs.getInt("Ma");
			String noidung=rs.getString("NoiDung");
			int mamon=rs.getInt("MaMon");
			String monhoc=rs.getString("monhoc.Ten");
			int mamucdo=rs.getInt("MaMucDo");
			int macautraloidung=rs.getInt("MaCauTraLoiDung");
			temp=new CauHoi(ma,noidung,mamon,monhoc,mamucdo,macautraloidung);
			}
		return temp;
	}
	
	public ArrayList<CauHoi> getListCauHoi(ResultSet rs) throws SQLException{
		ArrayList<CauHoi> temp=new ArrayList<CauHoi>();
		while(rs.next()) {
			int ma=rs.getInt("cauhoi.Ma");
			String noidung=rs.getString("NoiDung");
			int mamon=rs.getInt("MaMon");
			String monhoc=rs.getString("monhoc.Ten");
			int mamucdo=rs.getInt("MaMucDo");
			int macautraloidung=rs.getInt("MaCauTraLoiDung");
			temp.add(new CauHoi(ma,noidung,mamon,monhoc,mamucdo,macautraloidung));
		}
		return temp;
	}
	

	
}
