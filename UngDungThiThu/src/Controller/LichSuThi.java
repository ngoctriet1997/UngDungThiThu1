package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modal.ThiSinh;
import MutilModal.*;

/**
 * Servlet implementation class LichSuThi
 */
@WebServlet("/LichSuThi")
public class LichSuThi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LichSuThi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		int maVaiTro= Integer.parseInt(session.getAttribute("vaiTro").toString());
		if(maVaiTro==1)
		{
			String taikhoang=session.getAttribute("maNguoiDung").toString();
			ThiSinh ts=ThiSinh.getStudentInfo(Integer.parseInt(taikhoang));
			List<MutilModal.LichSuThi> lst=MutilModal.LichSuThi.LayTatCaThongTinBangDiem(ts.getMa());
			
			
			request.setAttribute("ts", ts);
			request.setAttribute("lst", lst);
			request.getRequestDispatcher("WEB-INF/LichSuThi.jsp").forward(request, response);
		}
		
		else
		{
			String maThiSinh=request.getParameter("maThiSinh");
			ThiSinh ts=ThiSinh.getStudentInfo(Integer.parseInt(maThiSinh));
			List<MutilModal.LichSuThi> lst=MutilModal.LichSuThi.LayTatCaThongTinBangDiem(ts.getMa());
			
			
			request.setAttribute("ts", ts);
			request.setAttribute("lst", lst);
			request.getRequestDispatcher("WEB-INF/XemLichSuBaiLam.jsp").forward(request, response);
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
