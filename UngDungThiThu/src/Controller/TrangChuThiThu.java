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

import com.google.gson.Gson;

import Modal.*;

/**
 * Servlet implementation class TrangChuThiThu
 */
@WebServlet("/TrangChuThiThu")
public class TrangChuThiThu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrangChuThiThu() {
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
			if( ThiSinh.DangNhap((Integer)session.getAttribute("maNguoiDung"), session.getAttribute("matKhau").toString()
					))
			{
				List<LopHoc> listLopHoc= new ArrayList<LopHoc>();
			     List<DeThiTrongLopHoc> listDeThiTrongLopHoc = new ArrayList<DeThiTrongLopHoc>();
			     ThiSinh ts= ThiSinh.getStudentInfo(((Integer)session.getAttribute("maNguoiDung")));
			     listLopHoc= LopHoc.getListClass((Integer)session.getAttribute("maNguoiDung"));
			     for(LopHoc lh:listLopHoc)
			     {
			    	 listDeThiTrongLopHoc.addAll(DeThiTrongLopHoc.layThongTinDeThi(lh.getMa(),ts.getMa()));
			     }
			     System.out.println("Kich thuoc: "+listDeThiTrongLopHoc.size());
			     for(DeThiTrongLopHoc lh:listDeThiTrongLopHoc)
			     {
			    	 System.out.println("de thi: "+lh.getMaDe());
			     }//listDeThiTrongLopHoc.get(0).getThoiGianBatDau()()
				 request.setAttribute("danhSachLopHoc", listLopHoc);
				 request.setAttribute("maThiSinh", ts.getMa());
				 request.setAttribute("danhSachDeThi",listDeThiTrongLopHoc);
				 request.setAttribute("cus", ts.getTen());
				
				request.getRequestDispatcher("WEB-INF/TrangChuThiThu.jsp").forward(request, response);
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
