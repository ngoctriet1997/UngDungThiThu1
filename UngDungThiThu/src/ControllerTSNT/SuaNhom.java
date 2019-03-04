package ControllerTSNT;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.DataAccess;
import Modal.NhomThi;
import Modal.ThiSinh;

/**
 * Servlet implementation class SuaNhom
 */
@WebServlet("/SuaNhom")
public class SuaNhom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaNhom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("static-access")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
				String id=request.getParameter("id");
				DataAccess da = new DataAccess();
				List<NhomThi> lstNhomThi =null;
				lstNhomThi = da.getNhomThiById(Integer.parseInt(id));
				NhomThi temp=lstNhomThi.get(0);
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
		System.out.println(id);
		String ten=request.getParameter("Ten");	
		DataAccess da = new DataAccess();
		da.editnhom(Integer.parseInt(id), ten);
		 response.setContentType("text/html;charset=UTF-8");
		response.sendRedirect("DanhSachNhomThi");
	}

}
