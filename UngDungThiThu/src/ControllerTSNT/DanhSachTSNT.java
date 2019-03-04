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
import Modal.ThiSinhTrongNhomThi;

/**
 * Servlet implementation class DanhSachTSNT
 */
@WebServlet("/DanhSachTSNT")
public class DanhSachTSNT extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachTSNT() {
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
					,2))
			{
		List<ThiSinhTrongNhomThi> danhSachTSNT=new ArrayList<>();
		danhSachTSNT=ThiSinhTrongNhomThi.LayDanhSachTSNT1();
		List<NhomThi> danhSachNhomThi=new ArrayList<>();
		danhSachNhomThi=NhomThi.LayDanhSachNhomThi();
		request.setAttribute("danhSachNhomThi", danhSachNhomThi);
		request.setAttribute("danhSachTSNT", danhSachTSNT);
		request.getRequestDispatcher("WEB-INF/DanhSachTSNT.jsp").forward(request, response);
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
