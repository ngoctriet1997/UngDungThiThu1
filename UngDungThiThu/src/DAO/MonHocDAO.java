package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import Mapper.MonHocMapper;
import Modal.DBMain;
import Model1.MonHoc;



public class MonHocDAO {
	MonHocMapper mapper=new MonHocMapper();
	
	public ArrayList<MonHoc> getListMonHoc() throws ClassNotFoundException, SQLException{
		String sql="Select * from monhoc";	
		ArrayList<MonHoc> lst= new ArrayList<>();
		DBMain db=new DBMain();	
		Connection c=db.getConnection();
		Statement st=c.createStatement();
		ResultSet rs=st.executeQuery(sql);
		lst= mapper.getListMonHoc(rs);
		if(c!=null)
		{
			c.close();
		}
		return lst;
	}
	
	

	
}
