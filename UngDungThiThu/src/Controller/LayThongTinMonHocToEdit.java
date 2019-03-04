package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Modal.MonHoc;

/**
 * Servlet implementation class LayThongTinMonHocToEdit
 */
@WebServlet("/LayThongTinMonHocToEdit")
public class LayThongTinMonHocToEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LayThongTinMonHocToEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String maMonHoc=request.getParameter("maMonHoc");
		MonHoc monHoc=MonHoc.LayThongTinMonHoc(maMonHoc);
		Gson gson=new Gson();
		String element2=gson.toJson(monHoc);
		  response.setContentType("application/json");
		  response.getWriter().println(element2);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
