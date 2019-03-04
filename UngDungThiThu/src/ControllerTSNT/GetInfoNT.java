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

/**
 * Servlet implementation class GetInfoNT
 */
@WebServlet("/GetInfoNT")
public class GetInfoNT extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetInfoNT() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		DataAccess da = new DataAccess();
		List<NhomThi> lstNhomThi =null;
		lstNhomThi = da.getNhomThiByIdTS(Integer.parseInt(id));
		NhomThi temp=lstNhomThi.get(0);
		System.out.print(1);
		ObjectMapper mapper=new ObjectMapper();
		String res=mapper.writeValueAsString(lstNhomThi);
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
