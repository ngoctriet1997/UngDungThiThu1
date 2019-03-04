package ControllerTSNT;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modal.NguoiDung;
import Modal.NhomThi;

/**
 * Servlet implementation class DanhSachNhomThi
 */
@WebServlet("/DanhSachNhomThi")
public class DanhSachNhomThi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachNhomThi() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("maNguoiDung")!=null)
		{
			if( NguoiDung.DangNhap((Integer)session.getAttribute("maNguoiDung"), session.getAttribute("matKhau").toString()
					,2))
			{
		List<NhomThi> danhSachNhomThi=new ArrayList<>();
		danhSachNhomThi=NhomThi.LayDanhSachNhomThi();
		request.setAttribute("danhSachNhomThi", danhSachNhomThi);
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("WEB-INF/DanhSachNhomThi.jsp").forward(request, response);
		return ;
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
