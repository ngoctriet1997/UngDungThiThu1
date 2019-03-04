package ControllerTSNT;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.DataAccess;
import Modal.ThiSinh;

/**
 * Servlet implementation class SuaTS
 */
@WebServlet("/SuaTS")
public class SuaTS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaTS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		DataAccess da = new DataAccess();
		List<ThiSinh> lstThiSinh =null;
		lstThiSinh = da.getThiSinhById(Integer.parseInt(id));
		ThiSinh temp=lstThiSinh.get(0);
		ObjectMapper mapper=new ObjectMapper();
		String res=mapper.writeValueAsString(temp);
		 response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("Ma");
		String soDienThoai=request.getParameter("SoDienThoai");
		String ten=request.getParameter("Ten");
		String matKhau=request.getParameter("MatKhau");
		DataAccess da = new DataAccess();
		da.edit(Integer.parseInt(id), soDienThoai, ten, matKhau);
		response.setContentType("text/html;charset=UTF-8");
		response.sendRedirect("DanhSachThiSinh");
	}

}
