package Modal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NguoiDung {
private int Ma;
private String Ten;
private String MatKhau;
private int VaiTro;
public NguoiDung(int ma, String ten, String matKhau, int vaiTro) {
	super();
	Ma = ma;
	Ten = ten;
	MatKhau = matKhau;
	VaiTro = vaiTro;
}
public int getMa() {
	return Ma;
}
public void setMa(int ma) {
	Ma = ma;
}
public String getTen() {
	return Ten;
}
public void setTen(String ten) {
	Ten = ten;
}
public String getMatKhau() {
	return MatKhau;
}
public void setMatKhau(String matKhau) {
	MatKhau = matKhau;
}
public int getVaiTro() {
	return VaiTro;
}
public void setVaiTro(int vaiTro) {
	VaiTro = vaiTro;
}
public static boolean DangNhap(int ma,String matKhau,int vaiTro )
{
	
	DBMain db=null;
	Connection c=null;
	boolean flag=false;
	try {
		db = new DBMain();
		c=db.getConnection();
		Statement st=c.createStatement();
		ResultSet rs= st.executeQuery("Select * from nguoidung where Ma="+ma+" and matkhau='"+matKhau+"' and mavaitro="+vaiTro);
		while(rs.next())
		{
			flag= true;
		}
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	finally {
		try {
			if(c!=null)
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	return flag;
}
}
