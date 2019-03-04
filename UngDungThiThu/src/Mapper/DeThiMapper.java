package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model1.CauHoi;
import Model1.DeThi;



public class DeThiMapper {
	
	public DeThi getDeThi(ResultSet rs) throws SQLException {
		DeThi temp=null;
		while(rs.next()) {
			int ma=rs.getInt("Ma");
			String ten=rs.getString("Ten");
			int thoigianlambai=rs.getInt("ThoiGianLamBai");
		
			temp=new DeThi(ma,ten,thoigianlambai);
			}
		return temp;
	}
	
	public ArrayList<DeThi> getListDeThi(ResultSet rs) throws SQLException{
		ArrayList<DeThi> temp=new ArrayList<DeThi>();
		while(rs.next()) {
			int ma=rs.getInt("Ma");
			String ten=rs.getString("Ten");
			int thoigianlambai=rs.getInt("ThoiGianLamBai");
			temp.add(new DeThi(ma,ten,thoigianlambai));
		}
		return temp;
	}

	
}
