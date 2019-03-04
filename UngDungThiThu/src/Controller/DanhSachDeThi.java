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

import DAO.DeThiDAO;
import Modal.NguoiDung;
import Model1.DeThi;


@WebServlet("/DSDT")
public class DanhSachDeThi extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		HttpSession session=req.getSession();
		if(session.getAttribute("maNguoiDung")!=null)
		{
			if( NguoiDung.DangNhap((Integer)session.getAttribute("maNguoiDung"), session.getAttribute("matKhau").toString()
					,3))
			{
		DeThiDAO DeThiDao =new DeThiDAO();
		ArrayList<DeThi> lstDeThi;
		try {
			lstDeThi = DeThiDao.getAllDeThi();
			req.setAttribute("lstDeThi", lstDeThi);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("WEB-INF/DSDT.jsp").forward(req, res);
		return;
			}
		}
		res.sendRedirect("DangNhap");
	}
}	
