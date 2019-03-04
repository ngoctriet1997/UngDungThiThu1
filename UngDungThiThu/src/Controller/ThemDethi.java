package Controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CauHoiDAO;
import DAO.DeThiDAO;
import DAO.MonHocDAO;
import Modal.NguoiDung;
import Model1.CauHoi;
import Model1.MonHoc;

@WebServlet("/ThemDeThi")
public class ThemDethi extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		HttpSession session=req.getSession();
		if(session.getAttribute("maNguoiDung")!=null)
		{
			if( NguoiDung.DangNhap((Integer)session.getAttribute("maNguoiDung"), session.getAttribute("matKhau").toString()
					,3))
			{
		RequestDispatcher dispatcher =req.getRequestDispatcher("WEB-INF/QLThemDeThi.jsp");
		MonHocDAO dao=new MonHocDAO();
		List<MonHoc> lstMonHoc;
		try {
			lstMonHoc = dao.getListMonHoc();
			req.setAttribute("lstMonHoc", lstMonHoc);
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
	
		dispatcher.forward(req, res);
		return;
			}
		}
		res.sendRedirect("DangNhap");
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) {
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String ten=req.getParameter("ten");
		String thoiluong=req.getParameter("thoiluong");
		String maMonHoc=req.getParameter("monhoc");
		String soCauHoiDe=req.getParameter("de");
		String soCauHoiTB=req.getParameter("tb");
		String soCauHoiKho=req.getParameter("kho");
		String soLanThi=req.getParameter("solanthi");

		DeThiDAO DeThiDao=new DeThiDAO();
		CauHoiDAO CauHoiDao=new CauHoiDAO();
		try {
			DeThiDao.themDeThi(ten, Integer.parseInt(thoiluong),Integer.parseInt(soLanThi));
			List<CauHoi> lstDe=CauHoiDao.getListCauHoiTheoMucDo(Integer.parseInt(maMonHoc), 1, Integer.parseInt(soCauHoiDe));
			List<CauHoi> lstTB=CauHoiDao.getListCauHoiTheoMucDo(Integer.parseInt(maMonHoc), 2, Integer.parseInt(soCauHoiTB));
			List<CauHoi> lstKho=CauHoiDao.getListCauHoiTheoMucDo(Integer.parseInt(maMonHoc), 3, Integer.parseInt(soCauHoiKho));
			
			int lastIdDeThi=DeThiDao.getLastIdDeThi();
			for(CauHoi i :lstDe) {
				DeThiDao.ThemCTDT(lastIdDeThi, i.getMa());
			}
			for(CauHoi i :lstTB) {
				DeThiDao.ThemCTDT(lastIdDeThi, i.getMa());
			}
			for(CauHoi i :lstKho) {
				DeThiDao.ThemCTDT(lastIdDeThi, i.getMa());
			}
			
		
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
		
		
	}
}
