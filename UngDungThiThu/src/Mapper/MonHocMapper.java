package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model1.MonHoc;



public class MonHocMapper {
	
	public MonHoc getMonHoc(ResultSet rs) throws SQLException {
		MonHoc temp=null;
		while(rs.next()) {
			int ma=rs.getInt("Ma");
			String hinh=rs.getString("Hinh");
			String ten=rs.getString("Ten");
			temp=new MonHoc(ma,hinh,ten);
			}
		return temp;
	}
	
	public ArrayList<MonHoc> getListMonHoc(ResultSet rs) throws SQLException{
		ArrayList<MonHoc> temp=new ArrayList<MonHoc>();
		while(rs.next()) {
			int ma=rs.getInt("Ma");
			String hinh=rs.getString("Hinh");
			String ten=rs.getString("Ten");
			temp.add(new MonHoc(ma,hinh,ten));
		}
		return temp;
	}

	
}
