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
import Modal.NhomThi;
import Modal.ThiSinhTrongNhomThi;

/**
 * Servlet implementation class GetInfoTNST
 */
@WebServlet("/GetInfoTNST")
public class GetInfoTNST extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetInfoTNST() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		
		DataAccess da = new DataAccess();
		List<ThiSinhTrongNhomThi> lstThiSinh =null;
		lstThiSinh = da.getTSNTByIdNT(Integer.parseInt(id));
		ThiSinhTrongNhomThi temp=lstThiSinh.get(0);
		System.out.print(1);
		ObjectMapper mapper=new ObjectMapper();
		String res=mapper.writeValueAsString(lstThiSinh);
		 response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
