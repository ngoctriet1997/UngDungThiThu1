package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model1.CauHoi;
import Model1.NhomThi;



public class NhomThiMapper {
	
	public NhomThi getNhomThi(ResultSet rs) throws SQLException {
		NhomThi temp=null;
		while(rs.next()) {
			int ma=rs.getInt("Ma");
			String ten=rs.getString("Ten");
			temp=new NhomThi(ma,ten);
			}
		return temp;
	}
	
	public ArrayList<NhomThi> getListNhomThi(ResultSet rs) throws SQLException{
		ArrayList<NhomThi> temp=new ArrayList<NhomThi>();
		while(rs.next()) {
			int ma=rs.getInt("Ma");
			String ten=rs.getString("Ten");
			temp.add(new NhomThi(ma,ten));
		}
		return temp;
	}
	

	
}
