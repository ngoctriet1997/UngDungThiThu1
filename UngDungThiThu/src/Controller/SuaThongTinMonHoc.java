package Controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Modal.MonHoc;

/**
 * Servlet implementation class SuaThongTinMonHoc
 */
@MultipartConfig
@WebServlet("/SuaThongTinMonHoc")
public class SuaThongTinMonHoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaThongTinMonHoc() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		Part filePart = request.getPart("hinh");
		 InputStream   inputStream = filePart.getInputStream(); // input stream of the upload file
		 String maMonHoc=request.getParameter("txtMaMonHoc");
		 String tenMonHoc=request.getParameter("txtTenMonHoc");
	
		 if(MonHoc.ChinhSua(maMonHoc, inputStream, tenMonHoc))
		 {
			 response.sendRedirect("DanhSachMonHoc");
		 }
		 else
			 response.getWriter().print("Error");
		
	}

}
