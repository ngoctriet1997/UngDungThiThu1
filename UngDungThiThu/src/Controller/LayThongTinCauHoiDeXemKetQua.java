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
import MutilModal.CauTraLoiCauHoiVaDapAnDung;

/**
 * Servlet implementation class LayThongTinCauHoiDeXemKetQua
 */
@WebServlet("/LayThongTinCauHoiDeXemKetQua")
public class LayThongTinCauHoiDeXemKetQua extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LayThongTinCauHoiDeXemKetQua() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		List<CauTraLoiCauHoiVaDapAnDung> lst=(List<CauTraLoiCauHoiVaDapAnDung>)session.getAttribute("lstDapAn");
		String maCauHoi=request.getParameter("maCauHoi");
		int imaCauHoi=Integer.parseInt(maCauHoi);
		CauTraLoiCauHoiVaDapAnDung ttcauhoi=null;
		for(CauTraLoiCauHoiVaDapAnDung x: lst)
		{
			if(x.getMaCauHoi()==imaCauHoi)
			{//ma cauhoi,macautraloi,madapandung
				ttcauhoi=new CauTraLoiCauHoiVaDapAnDung(x.getMaCauHoi(),x.getMaCauTraLoi(),x.getMaDapAn());
				break;
			}
		}
		
		CauHoi cauHoi=CauHoi.LayThongTinCauHoi(imaCauHoi);
		List<CauTraLoi> lscauTraLoi=new ArrayList<>();
		lscauTraLoi=CauTraLoi.LayThongTinCauTraLoiTheoCauHoi(imaCauHoi);
		Gson gson= new Gson();
		String element1=gson.toJson(cauHoi);
		JsonElement element= gson.toJsonTree(lscauTraLoi, new TypeToken<List<CauTraLoi>>(){}.getType());
		String listCauTraLoi= gson.toJson(ttcauhoi);
	
	
		String data="["+element1+","+element+","+listCauTraLoi+"]";
		System.out.println(data);
		response.setContentType("application/json");
		response.getWriter().println(data);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
