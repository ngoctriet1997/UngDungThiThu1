package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import Mapper.DeThiLopHocMapper;
import Modal.DBMain;
import Model1.DeThiLopHoc;

public class DeThiLopHocDAO {
	public void insertDeThiLopHoc(int madethi,int malophoc,String thoigianbatdau,String thoigianketthuc) throws ClassNotFoundException, SQLException {
		String sql="insert into dethilophoc values("+madethi+","+malophoc+",'"+thoigianbatdau+"'\r\n" + 
				",'"+thoigianketthuc+"')";
		System.out.println(sql);
		DBMain db=new DBMain();	
		Connection c=db.getConnection();
		Statement st=c.createStatement();
		st.executeUpdate(sql);
		if(c!=null)
		{
			c.close();
		}
	}
	public ArrayList<DeThiLopHoc> getAllDeThiLopHoc() throws SQLException, ClassNotFoundException {
		String sql="SELECT * FROM phanmemthithu.dethilophoc,dethi,nhomthi where dethi.Ma=dethilophoc.MaDeThi and dethilophoc.MaLopHoc=nhomthi.Ma";
		ArrayList<DeThiLopHoc> lst=new ArrayList<>();
		DBMain db=new DBMain();	
		Connection c=db.getConnection();
		Statement st=c.createStatement();
		ResultSet rs=st.executeQuery(sql);
		DeThiLopHocMapper mapper =new DeThiLopHocMapper();
		lst= mapper.getListDeThiLopHoc(rs);
		if(c!=null)
		{
			c.close();
		}
		return lst;
	}
}
