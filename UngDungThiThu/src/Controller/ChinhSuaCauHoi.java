package Controller;

import java.io.IOException;
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

import Modal.CauHoi;
import Modal.CauTraLoi;


/**
 * Servlet implementation class ChinhSuaCauHoi
 */
@WebServlet("/ChinhSuaCauHoi")
public class ChinhSuaCauHoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChinhSuaCauHoi() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		
		int maCauHoi=Integer.parseInt(request.getParameter("maCauHoi"));
		CauHoi cauHoi=CauHoi.LayThongTinCauHoi(maCauHoi);
		List<CauTraLoi> cauTraLoi=CauTraLoi.LayThongTinCauTraLoiTheoCauHoi(maCauHoi);
		Gson g=new Gson();
		String gCauHoi=g.toJson(cauHoi);
		System.out.println(gCauHoi);

		JsonElement gCauTraLoi=g.toJsonTree(cauTraLoi, new TypeToken<List<CauTraLoi>>() {}.getType() );
		System.out.println(gCauTraLoi);
		JsonArray jsonArray=gCauTraLoi.getAsJsonArray();
		String data="["+jsonArray+","+gCauHoi+"]";
		response.getWriter().println(data);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<CauTraLoi> danhSachCauTraLoi=new ArrayList<>();
		String txtCauTraLoi1=request.getParameter("txtCauTraLoi1");
		int maCauTraLoi1=Integer.parseInt(request.getParameter("maCauTraLoi1"));
		String txtCauTraLoi2=request.getParameter("txtCauTraLoi2");
		int maCauTraLoi2=Integer.parseInt(request.getParameter("maCauTraLoi2"));
		String txtCauTraLoi3=request.getParameter("txtCauTraLoi3");
		int maCauTraLoi3=Integer.parseInt(request.getParameter("maCauTraLoi3"));
		String txtCauTraLoi4=request.getParameter("txtCauTraLoi4");
		int maCauTraLoi4=Integer.parseInt(request.getParameter("maCauTraLoi4"));
		String NoiDungCauHoi=request.getParameter("txtNoiDungCauHoi");
		int maCauHoi=Integer.parseInt(request.getParameter("maCauHoi"));
		int maMon= Integer.parseInt(request.getParameter("cboMonHoc"));
		int maMucDo=Integer.parseInt(request.getParameter("cboMucDo"));
		int maDapAnDung=Integer.parseInt(request.getParameter("rdoDapAn"));
		danhSachCauTraLoi.add(new CauTraLoi(maCauTraLoi1, txtCauTraLoi1, maCauHoi));
		danhSachCauTraLoi.add(new CauTraLoi(maCauTraLoi2, txtCauTraLoi2, maCauHoi));
		danhSachCauTraLoi.add(new CauTraLoi(maCauTraLoi3, txtCauTraLoi3, maCauHoi));
		danhSachCauTraLoi.add(new CauTraLoi(maCauTraLoi4, txtCauTraLoi4, maCauHoi));
		CauHoi cauHoi=new CauHoi(maCauHoi, NoiDungCauHoi, maMon, maMucDo, maDapAnDung, null, null);
	
		for(CauTraLoi s:danhSachCauTraLoi)
		{
			System.out.println("NoiDung:"+s.getNoiDungCauHoi());
			System.out.println("Ma:"+s.getMa());
		}
		System.out.println("dap an dung :"+ maDapAnDung);
		System.out.println("ma Cau Hoi :"+ maCauHoi);
		
		System.out.println("ma mon: "+maMon);
		System.out.println("NoiDungcauhoi: "+NoiDungCauHoi);
		System.out.println("ma muc do: "+maMucDo);
		
		CauHoi.Sua(danhSachCauTraLoi, cauHoi);
		response.sendRedirect("DanhSachCauHoi");
	}

}
