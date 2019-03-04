package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Mapper.DeThiMapper;
import Modal.DBMain;
import Model1.CauTraLoi;
import Model1.DeThi;

public class DeThiDAO {
	DeThiMapper mapper=new DeThiMapper();
	public void themDeThi(String ten,int thoiGianLamBai,int soLanThi) throws ClassNotFoundException, SQLException {
		String sql="insert into dethi values(null,'"+ten+"',"+thoiGianLamBai+","+soLanThi+")";
		DBMain db=new DBMain();	
		Connection c=db.getConnection();
		Statement st=c.createStatement();
		st.executeUpdate(sql);
		
		if(c!=null)
		{
			c.close();
		}
	
	}
	public ArrayList<DeThi> getAllDeThi() throws ClassNotFoundException, SQLException{
		String sql="select * from dethi";
		ArrayList<DeThi> lst=new ArrayList<>();
		DBMain db=new DBMain();	
		Connection c=db.getConnection();
		Statement st=c.createStatement();
		 ResultSet rs=st.executeQuery(sql);
		 lst=mapper.getListDeThi(rs);
		if(c!=null)
		{
			c.close();
		}
		return lst;
		
	}
	public int getLastIdDeThi() throws ClassNotFoundException, SQLException {
		int maDethi=-1;
		String sql="SELECT Ma FROM dethi ORDER BY Ma DESC LIMIT 1";
		DBMain db=new DBMain();	
		Connection c=db.getConnection();
		Statement st=c.createStatement();
		ResultSet rs=st.executeQuery(sql);
		if(rs.next()) {
			maDethi= rs.getInt("Ma");
		}
		if(c!=null)
		{
			c.close();
		}
		return maDethi;
	}
	public void ThemCTDT(int maDeThi,int maCauHoi) throws ClassNotFoundException, SQLException {
		String sql="insert into chitietdethi values("+maDeThi+","+maCauHoi+")";
		DBMain db=new DBMain();	
		Connection c=db.getConnection();
		Statement st=c.createStatement();
		st.executeUpdate(sql);
		if(c!=null)
		{
			c.close();
		}
	}
}
