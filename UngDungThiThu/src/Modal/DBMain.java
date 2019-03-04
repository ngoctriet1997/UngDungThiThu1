package Modal;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.ResultSetMetaData;





public class DBMain {
	String url="jdbc:mysql://localhost:3306/phanmemthithu";
	String username="root";
	String password="123456";
	Connection c=null;

	
	public DBMain() throws SQLException, ClassNotFoundException
	{
		
	
	}
	public ResultSet  ExecuteQuery(String querySQL)
	{				
		ResultSet result=null;
		PreparedStatement pstmt=null;
		try {
			c=DriverManager.getConnection(url, username, password);
			pstmt=c.prepareStatement(querySQL);
			result=pstmt.executeQuery();			
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally {
			
			
		}	
		return result;	
	}

	public Connection  getConnection()
	{				
		
			try {
			
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				
				return DriverManager.getConnection(url,username,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				
			}
		
		return null;
	}
	
}
