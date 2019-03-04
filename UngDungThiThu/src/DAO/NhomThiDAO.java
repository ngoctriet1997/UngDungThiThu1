package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import Mapper.NhomThiMapper;
import Modal.DBMain;
import Model1.MonHoc;
import Model1.NhomThi;

public class NhomThiDAO {
	public ArrayList<NhomThi> getAllNhomThi() throws SQLException, ClassNotFoundException{
		String sql="Select * from nhomthi";
		ArrayList<NhomThi> lst= new ArrayList<>();
		DBMain db=new DBMain();	
		Connection c=db.getConnection();
		Statement st=c.createStatement();
		NhomThiMapper mapper=new NhomThiMapper();
		ResultSet rs=st.executeQuery(sql);
		lst= mapper.getListNhomThi(rs);
		if(c!=null)
		{
			c.close();
		}
		return lst;
	}
}
