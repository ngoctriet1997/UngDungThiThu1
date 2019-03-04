package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Modal.DBMain;
import Mapper.CauHoiMapper;
import Model1.CauHoi;

public class CauHoiDAO {
	CauHoiMapper mapper=new CauHoiMapper();
	public ArrayList<CauHoi> getListCauHoiTheoMucDo(int MaMon,int mucDo,int soLuong) throws ClassNotFoundException, SQLException{
		DBMain db=new DBMain();
		ArrayList<CauHoi> lst=new ArrayList<>();
		Connection c=db.getConnection();
		String sql="SELECT * FROM phanmemthithu.cauhoi,monhoc where cauhoi.MaMon=monhoc.Ma and MaMon="+MaMon+" and MaMucDo="+mucDo+" order by rand() limit "+ soLuong;
		Statement st=c.createStatement();
		ResultSet rs=st.executeQuery(sql);
		lst= mapper.getListCauHoi(rs);
		if(c!=null)
		{
			c.close();
		}
		return lst;
	}
	public ArrayList<CauHoi> getListCauHoiTrongDeThi(int idDeThi) throws ClassNotFoundException, SQLException{
		DBMain db=new DBMain();
		ArrayList<CauHoi> lst=new ArrayList<>();
		Connection c=db.getConnection();
		String sql="select * from chitietdethi,cauhoi,monhoc where cauhoi.MaMon=monhoc.Ma and chitietdethi.MaCauHoi=cauhoi.Ma and"
				+ " madethi="+idDeThi+" ";
		Statement st=c.createStatement();
		ResultSet rs=st.executeQuery(sql);
		lst= mapper.getListCauHoi(rs);
		if(c!=null)
		{
			c.close();
		}
		return lst;
	}
}
