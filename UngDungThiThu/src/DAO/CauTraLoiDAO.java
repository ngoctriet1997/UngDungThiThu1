package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



import Mapper.CauTraLoiMapper;
import Modal.DBMain;
import Model1.CauHoi;
import Model1.CauTraLoi;

public class CauTraLoiDAO {
	CauTraLoiMapper mapper=new CauTraLoiMapper();
	public ArrayList<CauTraLoi> getListCauTraLoiTheoCauHoi(int idCauHoi) throws ClassNotFoundException, SQLException{
		DBMain db=new DBMain();
		ArrayList<CauTraLoi> lst=new ArrayList<>();
		Connection c=db.getConnection();
		String sql="SELECT * FROM phanmemthithu.cautraloi where MaCauHoi="+idCauHoi;
		Statement st=c.createStatement();
		ResultSet rs=st.executeQuery(sql);
		lst= mapper.getListCauTraLoi(rs);
		if(c!=null)
		{
			c.close();
		}
		return lst;
	}
	
}
