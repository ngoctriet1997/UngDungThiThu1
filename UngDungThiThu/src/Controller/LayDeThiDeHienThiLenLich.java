package Controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import Modal.DeThiTrongLopHoc;
import Modal.LopHoc;


/**
 * Servlet implementation class LayDeThiDeHienThiLenLich
 */
@WebServlet("/LayDeThiDeHienThiLenLich")
public class LayDeThiDeHienThiLenLich extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LayDeThiDeHienThiLenLich() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String maThiSinh=request.getParameter("maThiSinh");
	     SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
		List<DeThiTrongLopHoc> listDeThiTrongLopHoc = new ArrayList<DeThiTrongLopHoc>();
		  List<LopHoc> listLopHoc= new ArrayList<LopHoc>();
		  listLopHoc= LopHoc.getListClass((Integer.parseInt(maThiSinh)));
		     for(LopHoc lh:listLopHoc)
		     {
		    	 listDeThiTrongLopHoc.addAll(DeThiTrongLopHoc.layThongTinDeThiTrongKhoangTG(lh.getMa(),Integer.parseInt(maThiSinh)));
		    	 
		     }
		    

		 	Gson gson=new Gson();
		 	
			JsonElement element1=gson.toJsonTree(listDeThiTrongLopHoc,  new TypeToken<List<DeThiTrongLopHoc>>(){}.getType());
			JsonArray jsonArray=element1.getAsJsonArray();
			response.setContentType("application/json");
			System.out.println("De thi: "+jsonArray);
			response.getWriter().println(jsonArray);
	}

}
