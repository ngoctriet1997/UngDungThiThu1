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
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import Modal.CauHoi;
import Modal.CauTraLoi;
import MutilModal.CauHoiVaCauTraLoi;
import MutilModal.ThongThiSinhTraLoi;
import jdk.nashorn.api.tree.Parser;

/**
 * Servlet implementation class LayCauHoiLenDeThi
 */
@WebServlet("/LayCauHoiLenDeThi")
public class LayCauHoiLenDeThi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LayCauHoiLenDeThi() {
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
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String taiKhoang=session.getAttribute("maNguoiDung").toString();
		String maDe=request.getParameter("maDe");
		List<CauHoiVaCauTraLoi> list=new ArrayList<>();
		list=ThongThiSinhTraLoi.LayThongTinDeThi(Integer.parseInt(maDe), Integer.parseInt(taiKhoang));
		
		response.setCharacterEncoding("utf-8");
		int maCauHoi=  Integer.parseInt(request.getParameter("maCauHoi"));
		List<CauTraLoi> lscauTraLoi=new ArrayList<>();
		lscauTraLoi=CauTraLoi.LayThongTinCauTraLoiTheoCauHoi(maCauHoi);
		CauHoi cauHoi=CauHoi.LayThongTinCauHoi(maCauHoi);
		Gson gson= new Gson();
		String element1=gson.toJson(cauHoi);
		JsonElement element= gson.toJsonTree(lscauTraLoi, new TypeToken<List<CauTraLoi>>(){}.getType());
		JsonElement listCauTraLoi= gson.toJsonTree(list, new TypeToken<List<CauHoiVaCauTraLoi>>(){}.getType());
		JsonElement listtl=listCauTraLoi.getAsJsonArray();
		JsonArray danhSachCauHoi=element.getAsJsonArray();
		String data="["+element1+","+element+","+listtl+"]";
	    System.out.println("List cau traloi: "+listtl);
	    System.out.println("List cau lscauTraLoi: "+element);
	    System.out.println("List cau lscauTraLoi: "+element1);
		response.setContentType("application/json");
		response.getWriter().println(data);
	}

}
