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
import Modal.ThiSinh;
import Modal.ThiSinhTrongNhomThi;

/**
 * Servlet implementation class SuaTSNT
 */
@WebServlet("/SuaTSNT")
public class SuaTSNT extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaTSNT() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		System.out.print(1);
		DataAccess da = new DataAccess();
		List<ThiSinhTrongNhomThi> lstThiSinh =null;
		lstThiSinh = da.getTSNTById(Integer.parseInt(id));
		ThiSinhTrongNhomThi temp=lstThiSinh.get(0);
		ObjectMapper mapper=new ObjectMapper();
		String res=mapper.writeValueAsString(temp);
		 response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
