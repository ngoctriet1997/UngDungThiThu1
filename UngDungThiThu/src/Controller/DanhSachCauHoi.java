package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modal.CauHoi;
import Modal.CauTraLoi;
import Modal.MonHoc;
import Modal.NguoiDung;
import Modal.ThiSinh;

/**
 * Servlet implementation class DanhSachCauHoi
 */
@WebServlet("/DanhSachCauHoi")
public class DanhSachCauHoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachCauHoi() {
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
			request.setCharacterEncoding("UTF-8");
			List<MonHoc> danhSachMonHoc=MonHoc.DanhSachMonHoc();
			List<CauTraLoi> danhSachCauTraLoi=CauTraLoi.DanhSachCauTraLoi();
			List<CauHoi> danhSachCauHoi=CauHoi.DanhSachCauHoi();
			request.setAttribute("danhSachMonHoc", danhSachMonHoc);
			request.setAttribute("danhSachCauHoi", danhSachCauHoi);
			request.setAttribute("danhSachCauTraLoi", danhSachCauTraLoi);
			request.getRequestDispatcher("WEB-INF/DanhSachCauHoi.jsp").forward(request, response);
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
