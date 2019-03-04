package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modal.*;

/**
 * Servlet implementation class DanhSachMonHoc
 */
@WebServlet("/DanhSachMonHoc")
public class DanhSachMonHoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachMonHoc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("maNguoiDung")!=null)
		{
			if( NguoiDung.DangNhap((Integer)session.getAttribute("maNguoiDung"), session.getAttribute("matKhau").toString()
					,4))
			{
		List<MonHoc> lstMonHoc=new ArrayList<MonHoc>();
		lstMonHoc=MonHoc.DanhSachMonHoc();
		request.setAttribute("lstMonHoc", lstMonHoc);
		request.getRequestDispatcher("WEB-INF/DanhSachMonHoc.jsp").forward(request, response);
		return;
			}
		}
		response.sendRedirect("DangNhap");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
