package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.CauHoiDAO;
import DAO.CauTraLoiDAO;
import DAO.DeThiDAO;
import DAO.DeThiLopHocDAO;
import DAO.NhomThiDAO;
import Modal.NguoiDung;
import Model1.CauHoi;
import Model1.CauTraLoi;
import Model1.DeThi;
import Model1.NhomThi;

@WebServlet("/DeThiLopHoc")
public class RaDeThi extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		HttpSession session=req.getSession();
		if(session.getAttribute("maNguoiDung")!=null)
		{
			if( NguoiDung.DangNhap((Integer)session.getAttribute("maNguoiDung"), session.getAttribute("matKhau").toString()
					,3))
			{
		DeThiDAO DeThiDao=new DeThiDAO();
		NhomThiDAO NhomThiDao=new NhomThiDAO();
		DeThiLopHocDAO DTLHDao=new DeThiLopHocDAO();
		
		try {
			ArrayList<DeThi> lstDeThi=DeThiDao.getAllDeThi();
			ArrayList<NhomThi> lstNhomThi=NhomThiDao.getAllNhomThi();
			ArrayList<Model1.DeThiLopHoc> lstDTLH=DTLHDao.getAllDeThiLopHoc();
			req.setAttribute("lstDTLH", lstDTLH);
			req.setAttribute("lstDeThi", lstDeThi);
			req.setAttribute("lstNhomThi", lstNhomThi);
			req.getRequestDispatcher("WEB-INF/DeThiLopHoc.jsp").forward(req, res);
			return;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			}
			
		}
	res.sendRedirect("DangNhap");
		
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		String manhomthi=req.getParameter("nhomthi");
		String madethi=req.getParameter("dethi");
		String tgbatdau=req.getParameter("tgbatdau");
		String tgketthuc=req.getParameter("tgketthuc");
		
		
		DeThiLopHocDAO DTLHDao=new DeThiLopHocDAO();
		try {
			DTLHDao.insertDeThiLopHoc(Integer.parseInt(madethi),Integer.parseInt(manhomthi), tgbatdau, tgketthuc);
			res.sendRedirect("DeThiLopHoc");
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}	
