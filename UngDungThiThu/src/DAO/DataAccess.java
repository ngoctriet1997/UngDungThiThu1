/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modal.DBMain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Modal.NhomThi;
import Modal.ThiSinh;
import Modal.ThiSinhTrongNhomThi;

/**
 *
 * @author cocoi
 */
public class DataAccess {
    //phương thức thêm
    public void addNew(ThiSinh t) {
    	DBMain db=null;
    	Connection c=null;
        try {   
        	db=new DBMain();
        	c=db.getConnection();
        	PreparedStatement ps = c.prepareStatement("insert into thisinh ( SoDienThoai, Ten, MatKhau) values(?,?,?)");
			
			ps.setString(1, t.getSdt());
			ps.setString(2, t.getTen());
			ps.setString(3, t.getMatKhau());
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
          
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
    }
    
    //Phương thức lấy dữ liệu

    /**
     *
     * @return
     */
    public static List<ThiSinh> getAll(){
    	List<ThiSinh> ls = new LinkedList<>();
    	DBMain db=null;
    	Connection c=null;
        try {   
        	db=new DBMain();
        	c=db.getConnection();
            ResultSet rs = c.prepareStatement("select * from thisinh").executeQuery();
            while(rs.next()){
                ThiSinh n = new ThiSinh(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                ls.add(n);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            
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
        return ls;
    }
    public static List<ThiSinhTrongNhomThi> getTSNT(){
    	List<ThiSinhTrongNhomThi> ls = new LinkedList<>();
    	DBMain db=null;
    	Connection c=null;
        try {   
        	db=new DBMain();
        	c=db.getConnection();
            ResultSet rs = c.prepareStatement("select * from thisinhtrongnhomthi").executeQuery();
            while(rs.next()){
            	ThiSinhTrongNhomThi n = new ThiSinhTrongNhomThi(rs.getInt(1), rs.getInt(2));
                ls.add(n);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
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
        return ls;
    }
    public static List<ThiSinh> getThiSinhById(int Id){
        List<ThiSinh> ls = new LinkedList<>();
        String sql = "select * from thisinh where Ma = " + Id;
    	DBMain db=null;
    	Connection c=null;
        try {   
        	db=new DBMain();
        	c=db.getConnection();
            ResultSet rs = c.prepareStatement(sql).executeQuery();
            while(rs.next()){
                ThiSinh n = new ThiSinh(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                ls.add(n);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        	try {
				if(c!=null)
					c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return ls;
    }
    public static List<ThiSinh> getThiSinhByIdNT(int Id){
        List<ThiSinh> ls = new LinkedList<>();
        String sql = "select thisinh.Ma,thisinh.SoDienThoai,thisinh.Ten,thisinh.MatKhau from thisinh inner join thisinhtrongnhomthi on thisinh.Ma=thisinhtrongnhomthi.MaThiSinh where thisinhtrongnhomthi.MaNhomThi=" + Id;
        DBMain db=null;
    	Connection c=null;
        try {   
        	db=new DBMain();
        	c=db.getConnection();
            ResultSet rs = c.prepareStatement(sql).executeQuery();
            while(rs.next()){
                ThiSinh n = new ThiSinh(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                ls.add(n);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
        	try {
				if(c!=null)
					c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return ls;
    }
    public static List<NhomThi> getNhomThiById(int Id){
        List<NhomThi> ls = new LinkedList<>();
        String sql = "select * from nhomthi where Ma = " + Id;
        DBMain db=null;
    	Connection c=null;
        try {   
        	db=new DBMain();
        	c=db.getConnection();
            ResultSet rs = c.prepareStatement(sql).executeQuery();
            while(rs.next()){
                NhomThi n = new NhomThi(rs.getInt(1), rs.getString(2));
                ls.add(n);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
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
        return ls;
    }
    
    public static List<ThiSinhTrongNhomThi> getTSNTById(int Id){
        List<ThiSinhTrongNhomThi> ls = new LinkedList<>();
        String sql = "select * from thisinhtrongnhomthi where MaThiSinh = " + Id;
        DBMain db=null;
    	Connection c=null;
        try {   
        	db=new DBMain();
        	c=db.getConnection();
            ResultSet rs = c.prepareStatement(sql).executeQuery();
            while(rs.next()){
                ThiSinhTrongNhomThi n = new ThiSinhTrongNhomThi(rs.getInt(1), rs.getInt(2));
                ls.add(n);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
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
        return ls;
    }
    public static List<ThiSinhTrongNhomThi> getTSNTByIdNT(int Id){
        List<ThiSinhTrongNhomThi> ls = new LinkedList<>();
        String sql = "select thisinhtrongnhomthi.MaThiSinh,thisinhtrongnhomthi.MaNhomThi from thisinhtrongnhomthi inner join nhomthi on nhomthi.Ma = thisinhtrongnhomthi.MaNhomThi where nhomthi.Ma=" + Id;
        DBMain db=null;
    	Connection c=null;
        try {   
        	db=new DBMain();
        	c=db.getConnection();
            ResultSet rs = c.prepareStatement(sql).executeQuery();
            while(rs.next()){
                ThiSinhTrongNhomThi n = new ThiSinhTrongNhomThi(rs.getInt(1), rs.getInt(2));
                ls.add(n);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
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
        return ls;
    }
    public static List<NhomThi> getNhomThiByIdTS(int Id){
        List<NhomThi> ls = new LinkedList<>();
        String sql = "select nhomthi.Ma,nhomthi.Ten from nhomthi inner join thisinhtrongnhomthi on nhomthi.Ma = thisinhtrongnhomthi.MaNhomThi where thisinhtrongnhomthi.MaThiSinh=" + Id;
        DBMain db=null;
    	Connection c=null;
        try {   
        	db=new DBMain();
        	c=db.getConnection();
            ResultSet rs = c.prepareStatement(sql).executeQuery();
            while(rs.next()){
                NhomThi n = new NhomThi(rs.getInt(1), rs.getString(2));
                ls.add(n);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
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
        return ls;
    }
    
    
    public  void edit(int Ma, String SoDienThoai, String Ten, String MatKhau)
    {
    	String sql = "update thisinh set SoDienThoai=?,Ten=?,MatKhau=? where Ma= "+ Ma;
        PreparedStatement ps;
        DBMain db=null;
    	Connection c=null;
        try {   
        	db=new DBMain();
        	c=db.getConnection();
            ps = c.prepareStatement(sql);

            ps.setString(1, SoDienThoai);
            ps.setString(2, Ten);
            ps.setString(3, MatKhau);
  
            ps.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
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
    }
    public  void editnhom(int Ma,  String Ten)
    {
    	String sql = "update nhomthi set Ten=? where Ma="+ Ma;
        PreparedStatement ps;
        DBMain db=null;
    	Connection c=null;
        try {   
        	db=new DBMain();
        	c=db.getConnection();
            ps = c.prepareStatement(sql);
           
            ps.setString(1, Ten);
           
            ps.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
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
    }
    public  void addts( String SoDienThoai, String Ten, String MatKhau)
    {
    	String sql = "insert into thisinh set SoDienThoai=?,Ten=?,MatKhau=? ";
        PreparedStatement ps;
        DBMain db=null;
    	Connection c=null;
        try {   
        	db=new DBMain();
        	c=db.getConnection();
            ps = c.prepareStatement(sql);
           
            ps.setString(1, SoDienThoai);
            ps.setString(2, Ten);
            ps.setString(3, MatKhau);
  
            ps.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }   finally {
        	try {
				if(c!=null)
					c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }  
    }
    public  void addnhom(String Ten)
    {
    	String sql = "insert into nhomthi set Ten=? ";
        PreparedStatement ps;
        DBMain db=null;
    	Connection c=null;
        try {   
        	db=new DBMain();
        	c=db.getConnection();
            ps = c.prepareStatement(sql);
           
            ps.setString(1, Ten);
            ps.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }     finally {
        	try {
				if(c!=null)
					c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
    public  void addtsnt(int MaThiSinh,int MaNhomThi)
    {
    	String sql = "insert into thisinhtrongnhomthi set MaThiSinh=?,MaNhomThi=? ";
        PreparedStatement ps;
        DBMain db=null;
    	Connection c=null;
        try {   
        	db=new DBMain();
        	c=db.getConnection();
            ps = c.prepareStatement(sql);
           
            ps.setInt(1, MaThiSinh);
            ps.setInt(2, MaNhomThi);
            ps.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }     finally {
        	try {
				if(c!=null)
					c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
 
    public  void delete(int Ma)
    {
    	  DBMain db=null;
      	Connection c=null;
          try {   
          	db=new DBMain();
          	c=db.getConnection();
            String sql = "delete from thisinh where Ma =" + Ma;
            PreparedStatement ps = c.prepareStatement(sql);
            
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        	try {
				if(c!=null)
					c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    	
    }
    public  void deletenhom(int Ma)
    {
    	  DBMain db=null;
      	Connection c=null;
          try {   
          	db=new DBMain();
          	c=db.getConnection();
            String sql = "delete from nhomthi where Ma =" + Ma;
            PreparedStatement ps = c.prepareStatement(sql);
            
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
        	try {
				if(c!=null)
					c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
    public  void deletetsnt(int Ma)
    {
    	 DBMain db=null;
       	Connection c=null;
           try {   
           	db=new DBMain();
           	c=db.getConnection();
            String sql = "delete from thisinhtrongnhomthi where MaThiSinh =" + Ma;
            PreparedStatement ps = c.prepareStatement(sql);
            
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
        	try {
				if(c!=null)
					c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
    
}
