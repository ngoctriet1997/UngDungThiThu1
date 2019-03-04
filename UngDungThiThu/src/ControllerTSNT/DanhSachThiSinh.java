package ControllerTSNT;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DataAccess;
import Modal.NguoiDung;
import Modal.NhomThi;
import Modal.ThiSinh;

/**
 * Servlet implementation class DanhSachThiSinh
 */
@WebServlet(name= "DanhSachThiSinh",urlPatterns = {"/DanhSachThiSinh"})
public class DanhSachThiSinh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachThiSinh() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**List<ThiSinh> danhSachThiSinh=new ArrayList<>();
		danhSachThiSinh=ThiSinh.LayDanhSachThiSinh();*/
		HttpSession session=request.getSession();
		if(session.getAttribute("maNguoiDung")!=null)
		{
			if( NguoiDung.DangNhap((Integer)session.getAttribute("maNguoiDung"), session.getAttribute("matKhau").toString()
					,2))
			{
		response.setCharacterEncoding("utf-8");
		request.setAttribute("danhSachThiSinh", DataAccess.getAll());
		
		List<NhomThi> danhSachNhomThi=new ArrayList<>();
		danhSachNhomThi=NhomThi.LayDanhSachNhomThi();
		request.setAttribute("danhSachNhomThi", danhSachNhomThi);
		
		request.getRequestDispatcher("WEB-INF/DanhSachThiSinh.jsp").forward(request, response);
		return;
			}
		}
		response.sendRedirect("DangNhap");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
