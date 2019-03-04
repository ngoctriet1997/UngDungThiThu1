package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import Modal.NguoiDung;
import Modal.ThiSinh;

/**
 * Servlet implementation class DangNhap
 */
@WebServlet("/DangNhap")
public class DangNhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangNhap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		if(session.getAttribute("maNguoiDung")==null  )
		{	
			request.getRequestDispatcher("WEB-INF/DangNhap.jsp").forward(request, response);
		}
		else
		{
		
			String vaiTro=session.getAttribute("vaiTro").toString();
			System.out.println(vaiTro);
			
			if(Integer.parseInt(vaiTro)==1)
			{
				System.out.println("vao day");
				response.sendRedirect("TrangChuThiThu");
			}
				
			else if(Integer.parseInt(vaiTro)==2)
			{
				
				response.sendRedirect("DanhSachThiSinh");	
			}
			else if(Integer.parseInt(vaiTro)==3)
			{
				response.sendRedirect("DeThiLopHoc");	
			}
			else if(Integer.parseInt(vaiTro)==4)
			{
				response.sendRedirect("DanhSachCauHoi");
			}
			//1 thí sinh
			//2 quản lý thí sinh
			//3 quản lý đề thi
			//4 Quản lý câu hỏi
		
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int taiKhoang=Integer.parseInt(request.getParameter("txtTaiKhoang"));
		String matKhau=request.getParameter("txtMatKhau");
		int vaiTro=Integer.parseInt(request.getParameter("vaitro"));
		System.out.println(matKhau);
		System.out.println(taiKhoang);
		System.out.println(vaiTro);
		if(vaiTro==1)
		{
			if(ThiSinh.DangNhap(taiKhoang,matKhau))
			{
				session.setAttribute("maNguoiDung", taiKhoang);
				session.setAttribute("matKhau", matKhau);
				session.setAttribute("vaiTro",1);
				response.sendRedirect("TrangChuThiThu");
			}
			else				
				request.getRequestDispatcher("WEB-INF/DangNhap.jsp").forward(request, response);
			
		}
		else if(vaiTro==2)
		{
			if(NguoiDung.DangNhap(taiKhoang,matKhau,vaiTro))
			{
				session.setAttribute("maNguoiDung", taiKhoang);
				session.setAttribute("matKhau", matKhau);
				session.setAttribute("vaiTro",2);
				response.sendRedirect("DanhSachThiSinh");
			}
			else				
				request.getRequestDispatcher("WEB-INF/DangNhap.jsp").forward(request, response);
			//1 thí sinh
			//2 quản lý thí sinh
			//3 quản lý đề thi
			//4 Quản lý câu hỏi
		}
		else if(vaiTro==3)
		{
			if(NguoiDung.DangNhap(taiKhoang,matKhau,vaiTro))
			{
				session.setAttribute("maNguoiDung", taiKhoang);
				session.setAttribute("matKhau", matKhau);
				session.setAttribute("vaiTro",3);
				response.sendRedirect("DSDT");
			}
			else				
				request.getRequestDispatcher("WEB-INF/DangNhap.jsp").forward(request, response);
		}
		else if(vaiTro==4)
		{
			if(NguoiDung.DangNhap(taiKhoang,matKhau,vaiTro))
			{
				session.setAttribute("maNguoiDung", taiKhoang);
				session.setAttribute("matKhau", matKhau);
				session.setAttribute("vaiTro",4);
				response.sendRedirect("DanhSachCauHoi");
			}
			else				
				request.getRequestDispatcher("WEB-INF/DangNhap.jsp").forward(request, response);
		}
	}

}
