package Mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model1.DeThiLopHoc;
import Model1.CauHoi;
import Model1.CauTraLoi;



public class DeThiLopHocMapper {
	
	public DeThiLopHoc getDeThiLopHoc(ResultSet rs) throws SQLException {
		DeThiLopHoc temp=null;
		while(rs.next()) {
			int madethi=rs.getInt("dethilophoc.MaDeThi");
			int malophoc=rs.getInt("dethilophoc.MaLopHoc");
			String tendethi=rs.getString("dethi.Ten");
			String tenlophoc=rs.getString("nhomthi.Ten");
			String thoigianbatdau=rs.getString("ThoiGianBatDau");
			String thoigianketthuc=rs.getString("ThoiGianKetThuc");
			int solanthi=rs.getInt("SoLanThi");
			temp=new DeThiLopHoc(madethi,tendethi,malophoc,tenlophoc,thoigianbatdau,thoigianketthuc,solanthi) ;
			}
		return temp;
	}
	
	public ArrayList<DeThiLopHoc> getListDeThiLopHoc(ResultSet rs) throws SQLException{
		ArrayList<DeThiLopHoc> temp=new ArrayList<DeThiLopHoc>();
		while(rs.next()) {
			int madethi=rs.getInt("dethilophoc.MaDeThi");
			int malophoc=rs.getInt("dethilophoc.MaLopHoc");
			String tendethi=rs.getString("dethi.Ten");
			String tenlophoc=rs.getString("nhomthi.Ten");
			String thoigianbatdau=rs.getString("ThoiGianBatDau");
			String thoigianketthuc=rs.getString("ThoiGianKetThuc");
			int solanthi=rs.getInt("SoLanThi");
			temp.add(new DeThiLopHoc(madethi,tendethi,malophoc,tenlophoc,thoigianbatdau,thoigianketthuc,solanthi)) ;
		}
		return temp;
	}

	
}
